package com.offcn.service;

import com.offcn.bean.Country;
import com.offcn.bean.User;
import com.offcn.bean.Users;
import com.offcn.dao.UserDao;
import com.offcn.dao.UserDaoImpl;

import java.util.List;

public class UserServiceImpl implements UserService{

    UserDao ud = new UserDaoImpl();

    @Override
    public Users selectByUsername(String username) {
        return ud.selectByUsername(username);
    }

    @Override
    public List<Country> selectAllCountry() {
        return ud.selectAllCountry();
    }
}
