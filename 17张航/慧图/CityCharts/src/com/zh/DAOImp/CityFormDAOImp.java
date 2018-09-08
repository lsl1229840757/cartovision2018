package com.zh.DAOImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zh.DAO.CityFormDAO;
import com.zh.Domain.CityForm;

//根据城市id查找某个城市各年数据分布表单
public class CityFormDAOImp extends CityFormDAO {

	public List<CityForm> findByCityAndFormCategory(int cityId, String category) {
		List<CityForm> list = new ArrayList<CityForm>();
		// 获得数据库连接
		Connection conn = DBHelper.getConnection();
		// 语句对象
		try {
			PreparedStatement prsmt = conn
					.prepareStatement("Select * from cityform where cityId = ? and category = ? ");
			//准备参数
			prsmt.setInt(1, cityId);
			prsmt.setString(2, category);
			// 执行语句
			prsmt.execute();
			// 得到结果集
			ResultSet resultSet = prsmt.getResultSet();
			// 遍历结果集
			while (resultSet.next()) {
				CityForm forms = new CityForm();
				forms.setCityId(resultSet.getInt("cityid"));
				forms.setFormId(resultSet.getInt("formid"));
				forms.setMaxYear(resultSet.getInt("maxyear"));
				forms.setMinYear(resultSet.getInt("minyear"));
				forms.setIsSession(resultSet.getInt("issession"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	//根据年份查找某年所有城市某表单
	public List<CityForm> findByYear(int year, String category) {
		List<CityForm> list = new ArrayList<CityForm>();
		// 获得数据库连接
		Connection conn = DBHelper.getConnection();
		// 语句对象
		try {
			PreparedStatement prsmt = conn
					.prepareStatement("Select * from cityform where myyear = ? and category = ? ");
			//准备参数
			prsmt.setInt(1, year);
			prsmt.setString(2, category);
			// 执行语句
			prsmt.execute();
			// 得到结果集
			ResultSet resultSet = prsmt.getResultSet();
			// 遍历结果集
			while (resultSet.next()) {
				CityForm forms = new CityForm();
				forms.setCityId(resultSet.getInt("cityid"));
				forms.setFormId(resultSet.getInt("formid"));
				forms.setMaxYear(resultSet.getInt("maxyear"));
				forms.setMinYear(resultSet.getInt("minyear"));
				forms.setIsSession(resultSet.getInt("issession"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
