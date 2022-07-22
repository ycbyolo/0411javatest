package com.offcn.dao;

import com.offcn.bean.Country;
import com.offcn.bean.User;
import com.offcn.bean.Users;
import com.offcn.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao{
    @Override
    public Users selectByUsername(String username) {

        QueryRunner qr = new QueryRunner(JDBCUtil.getDS());
        String sql = "select * from user where username = ?";
        Users users = null;
        try {
            users = qr.query(sql, new BeanHandler<>(Users.class), username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<Country> selectAllCountry() {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDS());
        String sql = "select * from country";
        List<Country> list = null;
        try {
            list = qr.query(sql, new BeanListHandler<>(Country.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
