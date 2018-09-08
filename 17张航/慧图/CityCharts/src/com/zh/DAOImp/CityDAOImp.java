package com.zh.DAOImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zh.DAO.CityDAO;
import com.zh.Domain.City;

public class CityDAOImp extends CityDAO {

	// 查找所有城市
	public List<City> findAllCity() {
		List<City> list = new ArrayList<City>();
		// 获得数据库连接
		Connection conn = DBHelper.getConnection();
		// 语句对象
		try {
			PreparedStatement prsmt = conn.prepareStatement("Select * from city ");
			// 执行语句
			prsmt.execute();
			// 得到结果集
			ResultSet resultSet = prsmt.getResultSet();
			// 遍历结果集
			while (resultSet.next()) {
				City city = new City();
				city.setCityId(resultSet.getInt("cityid"));
				city.setCityName(resultSet.getString("cityname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 通过城市名字查找城市
	public City findByCityName(String cityName) {
		// 获得数据库连接
		Connection conn = DBHelper.getConnection();
		// 语句对象
		City city = null;
		try {
			PreparedStatement prsmt = conn.prepareStatement("Select * from city where cityname = ?");
			//设置参数
			prsmt.setString(1, cityName);
			// 执行语句
			prsmt.execute();
			// 得到结果集
			ResultSet resultSet = prsmt.getResultSet();
			// 遍历结果集
			while(resultSet.next()) {
				city = new City();
				city.setCityId(resultSet.getInt("cityid"));
				city.setCityName(resultSet.getString("cityname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return city;
	}

	@Override
	public City findById(int cityId) {
		// 获得数据库连接
		Connection conn = DBHelper.getConnection();
		// 语句对象
		City city = null;
		try {
			PreparedStatement prsmt = conn.prepareStatement("Select * from city where cityid = ? ");
			//设置参数
			prsmt.setInt(1, cityId);
			// 执行语句
			prsmt.execute();
			// 得到结果集
			ResultSet resultSet = prsmt.getResultSet();
			// 遍历结果集
			while(resultSet.next()) {
				city = new City();
				city.setCityId(resultSet.getInt("cityid"));
				city.setCityName(resultSet.getString("cityname"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return city;
	}

}
