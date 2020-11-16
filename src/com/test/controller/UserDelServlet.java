package com.test.controller;

import com.test.dao.UserDao;
import com.test.util.JavaUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String userId = req.getParameter("userId");
        UserDao dao = new UserDao();
        int result = dao.del(userId);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        //注意使用下面的语句的时候，形参列表为【String】，不然输出结果可能是【????】
        writer.print(result==1?"<center><h1>注册成功</h1></center>":"<center><h1>注册失败</h1></center>");
    }
}
