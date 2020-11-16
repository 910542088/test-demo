package com.test.controller;

import com.test.dao.QuestionDao;
import com.test.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Question question1;
        QuestionDao dao;
        int result;
        String num = req.getParameter("num");
        String question = req.getParameter("question");
        String a = req.getParameter("a");
        String b = req.getParameter("b");
        String c = req.getParameter("c");
        String d = req.getParameter("d");
        String answer = req.getParameter("answer");

        dao = new QuestionDao();
        question1 = new Question(Integer.parseInt(num),question,a,b,c,d,answer);
        result = dao.update(question1);
        if(result==1){
            req.setAttribute("key1" ,"试题修改成功");
        }else {
            req.setAttribute("key1","试题修改失败");
        }
        req.getRequestDispatcher("/info_1.jsp").forward(req,resp);
        System.out.println(result);
    }
}
