package com.zetinc.rest;

import lombok.Getter;
import lombok.Setter;
import java.sql.Date;

@Getter
@Setter
public class Employee {
    private int empNo;
    private String ename;
    private String job;
    private int mgr;
    private Date hiredate;
    private int sal;
    private int comm;
    private int deptno;
}
