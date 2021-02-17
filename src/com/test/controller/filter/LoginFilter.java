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
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println(request.getRequestURI());
        /*
         * 这里用uri或是url都是可以判断请求的,只是显示的路径详细信息不同
         * url代表地址栏中的地址: http://localhost:8080/demo/login.do
         * uri这是Tomcat中的请求地址: /demo/login.do
         */
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
