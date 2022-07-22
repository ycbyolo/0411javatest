package com.offcn.dao;

import com.offcn.bean.Product;

import java.util.List;

public interface ProductDao {

    // 返回值类型
    public abstract List<Product> selectByProductName(String productName);

}
