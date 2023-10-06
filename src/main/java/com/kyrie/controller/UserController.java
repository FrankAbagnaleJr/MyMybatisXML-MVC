package com.kyrie.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kyrie.pojo.page.PageParam;
import com.kyrie.pojo.page.PageWapper;
import com.kyrie.pojo.User;
import com.kyrie.pojo.webtest.Jijinliang;
import com.kyrie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @auther: jijin
 * @date: 2023/10/4 0:49 周三
 * @project_name: MyMybatisXML
 * @version: 1.0
 * @description TODO
 */

@RestController
@RequestMapping("/mybatis")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 这个直接用MybatisPlus就完成
     *
     * @param pageParam
     * @param pageWapper
     * @return
     */
    @PostMapping("/listPage")
    public Page<User> list(PageParam pageParam, @RequestBody(required = false) PageWapper pageWapper) {
        Page<User> page = userService.pageList(pageParam, pageWapper);
        return page;
    }


    //参数可以在路径中间
    @GetMapping("/getById/{id}/test")
    User getById(@PathVariable("id") Long id) {
        User kyrie = userService.getById(id);
        return kyrie;
    }


    //@RequestParam是把前端传来的name值给userName，有时候前端传过来值不一样就得加，跟Mapper接口中的@Param注解一样
    //前后端变量名称一致就不用写了，后面passwod就可以省略@RequestParam("password")
    @GetMapping("/getTest")
    String getTest(@RequestParam("name") String userName, @RequestParam("password") int password) {
        return userName + ", " + password;
    }

    /**
     * 可以直接给对象参数赋值，如果请求的参数名称跟对象中的属性一致
     * 请求参数：pageNum=1&pageSize=10
     * 对象中的属性也必须是pageNum和pageSize
     */
    @GetMapping("/getPage")
    String getPage(PageParam pageParam) {
        return pageParam.getPageNum() + ", " + pageParam.getPageSize();
    }

    //请求体转对象，给对象中的对象赋值  ?name=冀金梁&age=15&hehuan.name=贺欢&hehuan.age=10
    @GetMapping("/getJijinliang")
    String getJijinliang(Jijinliang jijinliang) {
        return jijinliang.toString();
    }

    //请求体转数组 [1,2,3]   ["唱","跳","rap"]
    @GetMapping("/getPojoByArray")
    String getPojoByArray(String[] args) {
        return Arrays.toString(args);
    }

    //请求参数转集合?likes="唱"&likes="跳"&likes="rap"
    @GetMapping("/getPojoByArrayList")
    String getPojoByArrayList(@RequestParam List<String> likes) {
        return likes.toString();
    }

    //json转集合 [10,20,30]   ["唱","跳","rap"]
    @GetMapping("/jsonParmList")
    String jsonParmList(@RequestBody List<String> likes) {
        return likes.toString();
    }

    //json转对象 {name:冀金梁，age：15}
    @GetMapping("/jsonParmPojo")
    String jsonParmList(@RequestBody Jijinliang jijinliang) {
        return jijinliang.toString();
    }

    //json转集合[{name:冀金梁，age：15},{name:贺欢，age：10}]
    @GetMapping("/jsonParamArrayList")
    String jsonParamArrayList(@RequestBody List<Jijinliang> list){
        return list.toString();
    }

    //字符串转时间  2023/10/06就不管。2023-10-06就的指定
    @GetMapping("/stringToDate")
    String stringToDate(Date date,@DateTimeFormat(pattern = "yyyy-MM-dd") Date date1){
        return date.toString()+", "+date1.toString();
    }

    //根据集合中的多个id来查找，返回集合
    @PostMapping("/getInId")
    String getInId(@RequestBody List<Integer> lists){
        List<User> list =  userService.getInId(lists);
        return list.toString();
    }

}
