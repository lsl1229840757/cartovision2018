package com.zh.DAO;

import java.util.List;

import com.zh.Domain.GDPDetail;

public abstract class GDPDetailDAO {
	//查询所有数据
	public abstract List<GDPDetail> findAll();
	//按照城市年份精确查找数据
	public abstract List<GDPDetail> findByYearAndCity(int cityId,int year);
	//根据城市id查找某个城市5年的GDP三产业分布数据
	public abstract List<GDPDetail> findByCityName(String cityname);
	//根据年份查找当年所有城市GDP三产业分布数据
	public abstract List<GDPDetail> findByYear(int year);
	
}
