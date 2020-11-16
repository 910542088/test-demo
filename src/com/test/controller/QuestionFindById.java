package com.test.controller;

import com.test.dao.QuestionDao;
import com.test.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class QuestionFindById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        QuestionDao dao = new QuestionDao();
        String num = req.getParameter("num");

        Question question1 = dao.findById(num);

        req.setAttribute("key",question1);
        req.getRequestDispatcher("info.jsp").forward(req,resp);
    }
}
