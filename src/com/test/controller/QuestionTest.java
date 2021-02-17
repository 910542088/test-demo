package com.test.controller;

import com.test.dao.QuestionDao;
import com.test.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/questionSelect")
public class QuestionTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionDao dao = new QuestionDao();
        List<Question> list = dao.findSelect();

        HttpSession session = req.getSession();
        session.setAttribute("key",list);
        req.getRequestDispatcher("test.jsp").forward(req,resp);
    }
}
