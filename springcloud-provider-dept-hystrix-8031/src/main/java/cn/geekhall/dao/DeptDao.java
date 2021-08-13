package cn.geekhall.dao;

import cn.geekhall.bean.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DeptDao.java
 *
 * @author yiny
 */
@Mapper
@Repository
public interface DeptDao {
    boolean addDept(Dept dept);

    Dept queryById(Long deptno);

    List<Dept> queryAll();

}
