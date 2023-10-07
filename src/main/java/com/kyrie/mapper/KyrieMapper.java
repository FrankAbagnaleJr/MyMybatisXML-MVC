package com.kyrie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kyrie.pojo.DynamicsDto;
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
public interface KyrieMapper extends BaseMapper<Kyrie> {


    List<Kyrie> queryByWapper(DynamicsDto dynamicsDto);
}
