package com.test.controller;

import com.test.dao.QuestionDao;
import com.test.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class QuestionFind extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionDao dao = new QuestionDao();
        List<Question> list = dao.findAll();
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print("<table border=5px align=center>");
        out.print("<tr>");
        out.print("<td>试题编号</td>");
        out.print("<td>试题内容</td>");
        out.print("<td>选项A</td>");
        out.print("<td>选项B</td>");
        out.print("<td>选项C</td>");
        out.print("<td>选项D</td>");
        out.print("<td>答案</td>");
        out.print("<td>操作</td>");
        out.print("<td>信息内容</td>");
        out.print("</tr>");
        for(Question question:list){
            out.print("<tr>");
            out.print("<td>"+question.getNum()+"</td>");
            out.print("<td>"+question.getQuestion()+"</td>");
            out.print("<td>"+question.getA()+"</td>");
            out.print("<td>"+question.getB()+"</td>");
            out.print("<td>"+question.getC()+"</td>");
            out.print("<td>"+question.getD()+"</td>");
            out.print("<td>"+question.getAnswer()+"</td>");
            out.print("<td><a href='/questiondel?num="+question.getNum()+"'>删除</a></td>");
            out.print("<td><a href='/questionFindById?num="+question.getNum()+"'>修改信息</a></td>");
            out.print("</tr>");
        }
    }
}
