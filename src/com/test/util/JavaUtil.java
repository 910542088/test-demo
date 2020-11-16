package com.test.util;

import java.sql.*;

public class JavaUtil {
    Connection conn=null;
    PreparedStatement ps=null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getcon(){
        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/homeworks?serverTimezone=UTC","root","085208");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    public PreparedStatement createstatement(String sql){
        conn=getcon();
        try {
            ps = conn.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ps;
    }

    public void close(){
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void close(ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        close();
    }

}
