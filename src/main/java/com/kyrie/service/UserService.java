package com.kyrie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kyrie.pojo.DynamicsDto;
import com.kyrie.pojo.Kyrie;
import com.kyrie.pojo.page.PageParam;
import com.kyrie.pojo.page.PageWapper;
import com.kyrie.pojo.User;

import java.util.List;

/**
 * @auther: jijin
 * @date: 2023/10/4 0:50 周三
 * @project_name: MyMybatisXML
 * @version: 1.0
 * @description TODO
 */
public interface UserService {
    Page<User> pageList(PageParam pageParam, PageWapper pageWapper);

    User getById(Long id);

    List<User> getInId(List<Integer> lists);

    List<Kyrie> queryByWapper(DynamicsDto dynamicsDto);
}
