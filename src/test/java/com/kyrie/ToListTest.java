package com.kyrie;

import com.alibaba.fastjson.JSON;
import net.minidev.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther: jijin
 * @date: 2023/10/6 17:01 周五
 * @project_name: MyMybatisXML
 * @version: 1.0
 * @description TODO
 */
public class ToListTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        System.out.println(list.toString());
        String jsonString = JSONArray.toJSONString(list);
        System.out.println(jsonString);
        List<Long> longs = JSON.parseArray(jsonString, Long.class);
        System.out.println(longs.toString());
    }
}
