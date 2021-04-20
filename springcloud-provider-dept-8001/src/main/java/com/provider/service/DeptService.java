package com.provider.service;

import com.viper.pojo.Dept;

import java.util.List;

/**
 * @author Viper
 * @description
 * @date 2021/4/18
 */

public interface DeptService {

    public boolean addDept(Dept dept);

    public Dept queryById(int id);

    public List<Dept> queryAll();

}