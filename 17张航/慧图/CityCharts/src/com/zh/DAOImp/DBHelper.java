package com.zh.DAOImp;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {

		static String url = null;

		static Properties info = new Properties();

		static String username = null;

		static String password = null;

		static {
			try (InputStream in = DBHelper.class.getClassLoader()
					.getResourceAsStream("com/zh/DAOImp/data.properties");) {
				info.load(in);
				// 得到url，密码，用户名
				url = info.getProperty("url");
				username = info.getProperty("username");
				password = info.getProperty("password");
				// 注册驱动
				String driver = info.getProperty("driver");
				Class.forName(driver);

			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}

		}

		public static Connection getConnection() {
			try {
				return DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				System.out.println("数据库连接失败");
				e.printStackTrace();
			}
			return null;

		}
	
}
