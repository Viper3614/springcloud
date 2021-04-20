package com.viper.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Viper
 * @description
 * @date 2021/4/18
 */

@Data
@NoArgsConstructor
@Accessors(chain = true) //链式写法
public class Dept implements Serializable {
    private int deptno;
    private String dname;
    private String dbsource;

    public Dept(String dname) {
        this.dname = dname;
    }
}