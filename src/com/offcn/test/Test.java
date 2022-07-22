package com.offcn.test;

import com.offcn.bean.User;
import com.offcn.bean.Users;
import com.offcn.service.UserService;
import com.offcn.service.UserServiceImpl;

public class Test {
    public static void main(String[] args) {
        UserService us = new UserServiceImpl();
        Users users = us.selectByUsername("xiabo");
        System.out.println(users);
    }
}
