package com.test.controller;

import com.test.dao.UserDao;
import com.test.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao dao = new UserDao();
        int result=0;
        String userName,password,sex,email;

        req.setCharacterEncoding("utf-8");
        userName=req.getParameter("userName");
        password=req.getParameter("password");
        sex=req.getParameter("sex");
        email=req.getParameter("email");

        Users user=new Users(null,userName,password,sex,email);
        Date start =new Date();
        result=dao.add(user);
        Date end = new Date();
        System.out.println("本次注册消耗时间为："+(end.getTime()-start.getTime()));
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(result==1?"<center><h1>注册成功</h1></center>":"<center><h1>注册失败</h1></center>");
    }
}
