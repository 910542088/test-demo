package com.test.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //需要判断url,所以向下转型
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;


        String url = String.valueOf(request.getRequestURL());
        //判断需要过滤的内容，可以使用contains&endsWith来过滤请求！
        if (url.contains("login")||url.endsWith(".js")||url.endsWith(".jpg")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            Object num = request.getSession().getAttribute("int");
            if (num != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }
        }
    }
}
