package com.kyrie.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @auther: jijin
 * @date: 2023/10/6 17:41 周五
 * @project_name: MyMybatisXML
 * @version: 1.0
 * @description TODO
 */

@Data
@TableName("tb_user")
public class Kyrie {
    @TableId
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String profession;
    private Integer age;
    private Integer gender;
    private Integer status;
    private Date createtime;
}
