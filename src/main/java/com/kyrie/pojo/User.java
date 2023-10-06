package com.kyrie.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @auther: jijin
 * @date: 2023/10/4 0:41 周三
 * @project_name: MyMybatisXML
 * @version: 1.0
 * @description TODO
 */
@Data
@TableName("tb_kyrie")
public class User {
    @TableId
    private Long id;
    @TableField("user_name")
    private String name;
    private Integer age;
    private Integer status ;
    private Character gender;
}
