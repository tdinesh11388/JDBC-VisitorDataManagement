package com.IT.visitordatamanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionAdmin 
{
	public static Connection connectionProvide()
	{
		try {
			Class.forName(AppConstant.Driver);
			Connection con = DriverManager.getConnection(AppConstant.url,AppConstant.user,AppConstant.password);
			return con;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
