package com.offcn.service;

import com.offcn.bean.Product;

import java.util.List;

public interface ProductService {
    public abstract List<Product> selectByProductName(String productName);
}
