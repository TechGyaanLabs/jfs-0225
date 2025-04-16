package com.careerit.cj.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DbUtil {

    public volatile static DbUtil dbUtil;

    private static Properties properties;

    private DbUtil(){
    }

    static{
        try{
            properties = new Properties();
            properties.load(DbUtil.class.getClassLoader().getResourceAsStream("application.properties"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static DbUtil getInstance(){
        if(dbUtil == null){
            synchronized (DbUtil.class){
                if(dbUtil == null){
                    dbUtil = new DbUtil();
                }
            }
        }
        return dbUtil;
    }

    public Connection getConnection(){
        Connection con = null;
        try {
            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }


    public void close(Statement st, Connection con){
        if(st != null){
            try{
                st.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(con != null){
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void close(ResultSet rs, Statement st, Connection con){
        if(rs != null){
            try{
                rs.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        close(st, con);
    }


}
