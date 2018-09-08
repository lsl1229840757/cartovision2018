package com.zh.DAO;

import java.util.List;

import com.zh.Domain.City;

public abstract class CityDAO {
	//查找所有城市
	public abstract List<City>findAllCity();
	//通过城市名字查找城市
	public abstract City findByCityName(String cityName);
	//通过城市id查找城市
	public abstract City findById(int cityId);
	
}
