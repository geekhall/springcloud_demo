package cn.geekhall.service;

import cn.geekhall.bean.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DeptService.java
 *
 * @author yiny
 */
public interface DeptService {
    boolean addDept(Dept dept);

    Dept queryById(Long deptno);

    List<Dept> queryAll();
}
