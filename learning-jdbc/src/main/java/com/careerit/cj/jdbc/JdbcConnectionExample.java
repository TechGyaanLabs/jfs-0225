package com.careerit.cj.jdbc;

import com.careerit.cj.util.DbUtil;

import java.sql.*;

public class JdbcConnectionExample {

    public static void main(String[] args) {


        DbUtil dbUtil = DbUtil.getInstance();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            con = dbUtil.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select name,role,team,amount from player");
            while(rs.next()){
                String name = rs.getString("name");
                String role = rs.getString("role");
                String team = rs.getString("team");
                double amount = rs.getDouble("amount");
                System.out.println(name + " " + role + " " + team + " " + String.format("%.2f",amount));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
           dbUtil.close(rs, st, con);
        }

    }
}
