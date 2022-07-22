package com.offcn.service;

import com.offcn.bean.Country;
import com.offcn.bean.User;
import com.offcn.bean.Users;

import java.util.List;

public interface UserService {

    public abstract Users selectByUsername(String username);

    public abstract List<Country> selectAllCountry();

}
