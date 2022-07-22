package com.offcn.dao.impl;

import com.offcn.bean.Product;
import com.offcn.dao.ProductDao;
import com.offcn.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ProDuctDaoImpl implements ProductDao {
    @Override
    public List<Product> selectByProductName(String productName) {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDS());
        String sql = "select * from product where productname like ?";
        List<Product> list = null;
        try {
            list = qr.query(sql, new BeanListHandler<>(Product.class), "%" + productName + "%");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
