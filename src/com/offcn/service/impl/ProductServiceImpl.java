package com.offcn.service.impl;

import com.offcn.bean.Product;
import com.offcn.dao.ProductDao;
import com.offcn.dao.impl.ProDuctDaoImpl;
import com.offcn.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    ProductDao pd = new ProDuctDaoImpl();

    @Override
    public List<Product> selectByProductName(String productName) {
        return pd.selectByProductName(productName);
    }
}
