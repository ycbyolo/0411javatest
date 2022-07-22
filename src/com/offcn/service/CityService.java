package com.offcn.service;

import com.offcn.bean.City;

import java.util.List;

public interface CityService {

    public abstract List<City> selectCity(int countryId);

}
