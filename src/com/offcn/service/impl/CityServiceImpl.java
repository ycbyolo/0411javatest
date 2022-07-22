package com.offcn.service.impl;

import com.offcn.bean.City;
import com.offcn.dao.CityDao;
import com.offcn.dao.impl.CityDaoImpl;
import com.offcn.service.CityService;

import java.util.List;

public class CityServiceImpl implements CityService {

    CityDao cd = new CityDaoImpl();

    @Override
    public List<City> selectCity(int countryId) {
        return cd.selectCity(countryId);
    }
}
