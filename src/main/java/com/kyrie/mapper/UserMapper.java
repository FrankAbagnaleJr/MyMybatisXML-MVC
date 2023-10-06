package com.kyrie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kyrie.pojo.Kyrie;
import com.kyrie.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @auther: jijin
 * @date: 2023/10/4 0:44 周三
 * @project_name: MyMybatisXML
 * @version: 1.0
 * @description TODO
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    User getById(Long id);
}
