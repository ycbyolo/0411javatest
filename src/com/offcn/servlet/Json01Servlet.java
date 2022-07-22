package com.offcn.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.offcn.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@WebServlet("/Json01Servlet")
public class Json01Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(1,"zhangsan","男");
        User user1 = new User(2,"lisi","男");
        User user2 = new User(3,"wangwu","女");
        List<User> ulist = new ArrayList<>();
        ulist.add(user);
        ulist.add(user1);
        ulist.add(user2);
        List<User> ulist1 = new ArrayList<>();
        ulist1.add(user2);
        ulist1.add(user);
        // 把对象转换成json格式  ObjectMapper
        ObjectMapper om = new ObjectMapper();
        String s = om.writeValueAsString(user);
        System.out.println(s);

        // ObjectMapper  集合转换成json格式字符串
        String s1 = om.writeValueAsString(ulist);
        System.out.println(s1);

        // ObjectMapper
        Map<Integer, List<User>> map = new TreeMap<>();
        map.put(1, ulist);
        map.put(2, ulist1);
        String s2 = om.writeValueAsString(map);
        System.out.println(s2);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
