package cn.geekhall.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Dept.java
 *
 * @author yiny
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)   // 支持链式写法
public class Dept implements Serializable {

    private Long deptno;
    private String dname;
    private String db_source;

    public Dept(String dname){
        this.dname = dname;
    }
}
