package com.kyrie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kyrie.mapper.UserMapper;
import com.kyrie.pojo.page.PageParam;
import com.kyrie.pojo.page.PageWapper;
import com.kyrie.pojo.User;
import com.kyrie.service.UserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @auther: jijin
 * @date: 2023/10/4 0:50 周三
 * @project_name: MyMybatisXML
 * @version: 1.0
 * @description TODO
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public Page<User> pageList(PageParam pageParam, PageWapper pageWapper) {
        Page<User> page = new Page<>(pageParam.getPageNum(), pageParam.getPageSize());

        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotBlank(pageWapper.getName()), User::getName, pageWapper.getName());
        lqw.ge(pageWapper.getAge() != null && !"".equals(pageWapper.getAge()), User::getAge, pageWapper.getAge());
        lqw.eq(!Objects.isNull(pageWapper.getGender()), User::getGender, pageWapper.getGender());

        Page<User> pageResult = userMapper.selectPage(page, lqw);

        return page;
    }

    @Override
    public User getById(Long id) {
//        return userMapper.getById(id);
        return userMapper.selectById(id);
    }

    @Override
    public List<User> getInId(List<Integer> lists) {
//        User user = userMapper.selectById(lists.get(0));
//        List<User> list = new ArrayList<>();
//        list.add(user);
//        return list;

        List<User> list = userMapper.getInId(lists);
        return list;
    }

}
