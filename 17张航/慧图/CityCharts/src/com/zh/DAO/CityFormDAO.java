package com.zh.DAO;

import java.util.List;

import com.zh.Domain.CityForm;

public abstract class CityFormDAO {

		//根据城市id查找某个城市各年数据分布表单
		public abstract List<CityForm> findByCityAndFormCategory(int cityId,String category);
		//根据年份查找某年所有城市某表单
		public abstract List<CityForm> findByYear(int year,String category);
	
}
