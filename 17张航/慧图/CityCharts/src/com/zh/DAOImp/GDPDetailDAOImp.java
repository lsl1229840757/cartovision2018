package com.zh.DAOImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zh.DAO.GDPDetailDAO;
import com.zh.Domain.GDPDetail;

public class GDPDetailDAOImp extends GDPDetailDAO {

	@Override
	public List<GDPDetail> findAll() {
		List<GDPDetail> list = new ArrayList<GDPDetail>();
		// 获得数据库连接
		Connection conn = DBHelper.getConnection();
		// 语句对象
		try {
			PreparedStatement prsmt = conn
					.prepareStatement("Select * from GDPDetail order by total");
			// 执行语句
			prsmt.execute();
			// 得到结果集
			ResultSet resultSet = prsmt.getResultSet();
			// 遍历结果集
			while (resultSet.next()) {
				GDPDetail detail = new GDPDetail();
				detail.setCityId(resultSet.getInt("cityid"));
				detail.setMyYear(resultSet.getInt("myyear"));
				detail.setPrIn(resultSet.getDouble("PrIn"));
				detail.setSeIn(resultSet.getDouble("SeIn"));
				detail.setTeIn(resultSet.getDouble("TeIn"));
				detail.setTotal(resultSet.getDouble("total"));
				detail.setCityName(resultSet.getString("cityname"));
				list.add(detail);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	//按照城市年份精确查找GDP数据
	}
		public List<GDPDetail> findByYearAndCity(int cityId, int year) {
		List<GDPDetail> list = new ArrayList<GDPDetail>();
		// 获得数据库连接
		Connection conn = DBHelper.getConnection();
		// 语句对象
		try {
			PreparedStatement prsmt = conn
					.prepareStatement("Select * from GDPDetail where cityId = ? and myyear = ? ");
			//准备参数
			prsmt.setInt(1, cityId);
			prsmt.setInt(2, year);
			// 执行语句
			prsmt.execute();
			// 得到结果集
			ResultSet resultSet = prsmt.getResultSet();
			// 遍历结果集
			while (resultSet.next()) {
				GDPDetail detail = new GDPDetail();
				detail.setCityId(resultSet.getInt("cityid"));
				detail.setMyYear(resultSet.getInt("myyear"));
				detail.setPrIn(resultSet.getDouble("PrIn"));
				detail.setSeIn(resultSet.getDouble("SeIn"));
				detail.setTeIn(resultSet.getDouble("TeIn"));
				detail.setTotal(resultSet.getDouble("total"));
				detail.setCityName(resultSet.getString("cityname"));
				list.add(detail);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	//根据城市id查找某个城市5年的GDP三产业分布数据
		public List<GDPDetail> findByCityName(String cityname){
		List<GDPDetail> list = new ArrayList<GDPDetail>();
		// 获得数据库连接
		Connection conn = DBHelper.getConnection();
		// 语句对象
		try {
			PreparedStatement prsmt = conn
					.prepareStatement("Select * from GDPDetail where cityname = ?");
			//准备参数
			prsmt.setString(1, cityname);
			// 执行语句
			prsmt.execute();
			// 得到结果集
			ResultSet resultSet = prsmt.getResultSet();
			// 遍历结果集
			while (resultSet.next()) {
				GDPDetail detail = new GDPDetail();
				detail.setCityId(resultSet.getInt("cityid"));
				detail.setMyYear(resultSet.getInt("myyear"));
				detail.setPrIn(resultSet.getDouble("PrIn"));
				detail.setSeIn(resultSet.getDouble("SeIn"));
				detail.setTeIn(resultSet.getDouble("TeIn"));
				detail.setTotal(resultSet.getDouble("total"));
				detail.setCityName(resultSet.getString("cityname"));
				list.add(detail);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	//根据年份查找当年所有城市GDP三产业分布数据
	public List<GDPDetail> findByYear(int year) {
		List<GDPDetail> list = new ArrayList<GDPDetail>();
		// 获得数据库连接
		Connection conn = DBHelper.getConnection();
		// 语句对象
		try {
			PreparedStatement prsmt = conn
					.prepareStatement("Select * from GDPDetail where myyear = ? order by total");
			//准备参数
			prsmt.setInt(1, year);
			// 执行语句
			prsmt.execute();
			// 得到结果集
			ResultSet resultSet = prsmt.getResultSet();
			// 遍历结果集
			while (resultSet.next()){
				GDPDetail detail = new GDPDetail();
				detail.setCityId(resultSet.getInt("cityid"));
				detail.setMyYear(resultSet.getInt("myyear"));
				detail.setPrIn(resultSet.getDouble("PrIn"));
				detail.setSeIn(resultSet.getDouble("SeIn"));
				detail.setTeIn(resultSet.getDouble("TeIn"));
				detail.setTotal(resultSet.getDouble("total"));
				detail.setCityName(resultSet.getString("cityname"));
				list.add(detail);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}

	