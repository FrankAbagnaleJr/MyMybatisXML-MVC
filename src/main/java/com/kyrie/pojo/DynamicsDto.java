package com.kyrie.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @auther: jijin
 * @date: 2023/10/7 20:27 周六
 * @project_name: MyMybatisXML
 * @version: 1.0
 * @description TODO
 */
@Data
public class DynamicsDto extends Kyrie {
    private Date startTime;
    private Date endTime;
}
