package com.zh.DAOImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zh.DAO.FormDAO;
import com.zh.Domain.Form;

public class FormDAOImp extends FormDAO {

	@Override
	public Form findByCategory(String category) {
		// 获得数据库连接
		Connection conn = DBHelper.getConnection();
		// 语句对象
		Form form = null;
		try {
			PreparedStatement prsmt = conn.prepareStatement("Select * from form where category = ? ");
			// 设定参数
			prsmt.setString(1, category);
			// 执行语句
			prsmt.execute();
			// 得到结果集
			ResultSet resultSet = prsmt.getResultSet();
			// 遍历结果集
			while(resultSet.next()) {
				form = new Form();
				form.setFormId(resultSet.getInt("formid"));
				form.setFormCategory(resultSet.getString("category"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return form;
	}

	@Override
	public Form findById(int id) {
		// 获得数据库连接
		Connection conn = DBHelper.getConnection();
		// 语句对象
		Form form = null;
		try {
			PreparedStatement prsmt = conn.prepareStatement("Select * from form where formid = ? ");
			// 设定参数
			prsmt.setInt(1, id);
			// 执行语句
			prsmt.execute();
			// 得到结果集
			ResultSet resultSet = prsmt.getResultSet();
			// 遍历结果集
			while(resultSet.next()) {
				form = new Form();
				form.setFormId(resultSet.getInt("formid"));
				form.setFormCategory(resultSet.getString("category"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return form;
	}

}
