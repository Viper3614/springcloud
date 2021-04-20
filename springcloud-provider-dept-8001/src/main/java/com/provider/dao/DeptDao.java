package com.provider.dao;

import com.viper.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Viper
 * @description
 * @date 2021/4/18
 */

@Mapper
@Repository
public interface DeptDao {

    public boolean addDept(Dept dept);

    public Dept queryById(int id);

    public List<Dept> queryAll();
}