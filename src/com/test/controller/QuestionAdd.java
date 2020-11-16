package com.test.controller;

import com.test.dao.QuestionDao;
import com.test.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class QuestionAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String question,a,b,c,d,answer;
        question = req.getParameter("question");
        a = req.getParameter("a");
        b = req.getParameter("b");
        c = req.getParameter("c");
        d = req.getParameter("d");
        answer = req.getParameter("answer");

        Question question1 = new Question(null,question,a,b,c,d,answer);
        QuestionDao dao = new QuestionDao();
        int result = dao.add(question1);

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().print(result==1?"<h1>试题注册成功<h1>":"<h1>试题注册失败<h1>");
    }
}
