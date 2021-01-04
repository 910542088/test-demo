package com.test.dao;
//create table users(id int primary key auto_increment,username varchar(50),password varchar(50),sex varchar(50),email varchar(50));
import com.test.entity.Users;
import com.test.util.JavaUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    JavaUtil util = new JavaUtil();

    public int add(Users user) {
        PreparedStatement ps = null;
        int result = 0;
        String sql = "insert into Users (userName,password,sex,email) values (?,?,?,?)";
        ps = util.createstatement(sql);
        try {
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getSex());
            ps.setString(4, user.getEmail());
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }

    public List<Users> findAll() {
        String sql = "select * from Users";
        List<Users> list = new ArrayList<>();
        PreparedStatement ps = util.createstatement(sql);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer userId = rs.getInt("Id");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String sex = rs.getString("sex");
                String email = rs.getString("email");
                Users user = new Users(userId, userName, password, sex, email);
                list.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close(rs);
        }
        return list;
    }

    public int del(String userId) {
        int result = 0;
        String sql = "delete from Users where Id=?";
        PreparedStatement ps = util.createstatement(sql);
        try {
            ps.setInt(1, Integer.parseInt(userId));
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }

    public int login(String userName, String password) {
        String sql = "select count(*) from Users where userName=? and password=?";
        PreparedStatement ps = util.createstatement(sql);
        ResultSet rs =null;
        int result=0;
        try {
            ps.setString(1, userName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
               result= rs.getInt("count(*)");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close(rs);
        }
        return result;
    }


}
