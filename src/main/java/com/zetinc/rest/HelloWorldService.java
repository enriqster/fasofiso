package com.zetinc.rest;

import com.zetinc.db.HikariCPDataSource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Path("/ticket")
public class HelloWorldService {

    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMsg(@PathParam("param") int empNo) throws SQLException {
        return Response.status(200).entity(fetchData(empNo)).build();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createTicket(Employee employee) {

        System.out.println(employee);

        /*Ticket ticket = Ticket.builder().id(11).subject("subject").detail("detail").createDate(new Date()).build();
        List<Employee> employees = fetchData(empNo);
        StringBuilder outputStr = new StringBuilder();
        for(Employee employee : employees){
            outputStr.append(employee.getJob()).append(employee.getEname()).append(employee.getHiredate());
        }

        String output = "Jersey say : " + empNo + "version : " + outputStr;
        output += ticket.toString();*/

        return Response.status(200).entity(employee).build();

    }

    public static Employee fetchData(int empNo) throws SQLException {
        try (Connection con = HikariCPDataSource.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement("SELECT * FROM EMP WHERE empno=?")) {
                pst.setInt(1, empNo);
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        Employee employee = new Employee();
                        employee.setEmpNo(rs.getInt("empno"));
                        employee.setEname(rs.getString("ename"));
                        employee.setJob(rs.getString("job"));
                        employee.setMgr(rs.getInt("mgr"));
                        employee.setHiredate(rs.getDate("hiredate"));
                        employee.setSal(rs.getInt("sal"));
                        employee.setComm(rs.getInt("comm"));
                        employee.setDeptno(rs.getInt("deptno"));
                        return employee;
                    }
                }
            }
        }
        return null;
    }
}