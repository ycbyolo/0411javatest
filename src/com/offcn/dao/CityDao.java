package com.offcn.dao;

import com.offcn.bean.City;

import java.util.List;

public interface CityDao {

    //
    public abstract List<City> selectCity(int countryId);

}
