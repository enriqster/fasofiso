package com.zetinc.rest;

import com.zetinc.db.HikariCPDataSource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Path("/hello")
public class HelloWorldService {

    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) throws SQLException {

        String version = null;

        Ticket ticket = Ticket.builder().id(11).subject("subject").detail("detail").createDate(new Date()).build();
        fetchData();

        String output = "Jersey say : " + msg + "version : " + version;
        output += ticket.toString();

        return Response.status(200).entity(output).build();

    }


    public static List<Employee> fetchData() throws SQLException {
        List<Employee> employees = null;
        try (Connection con = HikariCPDataSource.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement("SELECT * FROM EMP")) {
                try (ResultSet rs = pst.executeQuery()) {
                    employees = new ArrayList<>();
                    Employee employee;
                    while (rs.next()) {
                        employee = new Employee();
                        employee.setEmpNo(rs.getInt("empno"));
                        employee.setEname(rs.getString("ename"));
                        employee.setJob(rs.getString("job"));
                        employee.setMgr(rs.getInt("mgr"));
                        employee.setHiredate(rs.getDate("hiredate"));
                        employee.setSal(rs.getInt("sal"));
                        employee.setComm(rs.getInt("comm"));
                        employee.setDeptno(rs.getInt("deptno"));
                        employees.add(employee);
                    }
                }
            }
        }
        return employees;
    }
}