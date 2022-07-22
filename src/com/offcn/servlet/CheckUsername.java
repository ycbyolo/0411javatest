package com.offcn.servlet;

import com.offcn.bean.User;
import com.offcn.bean.Users;
import com.offcn.service.UserService;
import com.offcn.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkUsername")
public class CheckUsername extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        // 获取用户名
        String username = req.getParameter("username");
        // 调用
        UserService us = new UserServiceImpl();
        Users users = us.selectByUsername(username);
        // 用户是否为空  空 没有注册过  可以注册
        if (users == null) {
            resp.getWriter().print("yes");
        }else {
            resp.getWriter().print("no");
        }
    }
}
