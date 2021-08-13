package cn.geekhall.service;

import cn.geekhall.bean.Dept;
import cn.geekhall.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DeptServiceImpl.java
 *
 * @author yiny
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;


    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept queryById(Long deptno) {
        return deptDao.queryById(deptno);
    }

    @Override
    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }
}
