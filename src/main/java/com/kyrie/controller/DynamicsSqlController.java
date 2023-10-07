package com.kyrie.controller;

import com.kyrie.pojo.DynamicsDto;
import com.kyrie.pojo.Kyrie;
import com.kyrie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @auther: jijin
 * @date: 2023/10/7 20:18 周六
 * @project_name: MyMybatisXML
 * @version: 1.0
 * @description TODO xml动态SQL
 */
@RestController
@RequestMapping("/sql")
public class DynamicsSqlController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String queryByWapper(@RequestBody DynamicsDto dynamicsDto){
        List<Kyrie> list = userService.queryByWapper(dynamicsDto);
        return list.toString();
    }
}


