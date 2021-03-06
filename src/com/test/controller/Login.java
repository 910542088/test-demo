package com.test.controller;

import com.test.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getPost(req, resp);
//        resp.sendRedirect("/index.jsp");
//        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    private void getPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        UserDao dao = new UserDao();

        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        int result = dao.login(userName, password);

        if (result == 1) {
            req.getSession().setAttribute("int", result);
            req.getSession().setAttribute("name", userName);
        }

        resp.setContentType("text/html;charset=utf-8");
//        源码充分说明print函数的结果都为String类型！！！，前端接收注意用String类型判断  [==="result"] 格式判断
        resp.getWriter().print(result);
    }

}


