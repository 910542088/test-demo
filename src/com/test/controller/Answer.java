package com.test.controller;

import com.test.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet("/answer")
public class Answer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int score = 0;
        String result;
        HttpSession session = req.getSession();
        List<Question> key = (List) session.getAttribute("key");
        String name = (String) session.getAttribute("name");
        for (Question question : key) {
            String answer = question.getAnswer();
            Integer num = question.getNum();
            String s = req.getParameter("answer_" + num);
            if (answer.equals(s)){
                score+=25;
            }
        }
        if (score>=75){
            result = "很不错哦";
        } else {
            result = "要加油哦";
        }
        resp.getWriter().print("<center><h1>"+name+"同学,你本次分数为"+score+"~~~<br>"+result+"</h1></center>");
    }
}
