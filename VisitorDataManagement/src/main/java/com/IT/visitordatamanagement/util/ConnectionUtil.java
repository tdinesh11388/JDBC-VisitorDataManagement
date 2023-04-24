package com.IT.visitordatamanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil
{
	public static Connection connectionGiver()
	{
		try {
			Class.forName(AppConstant.Driver);
			return DriverManager.getConnection(AppConstant.url,AppConstant.user,
					AppConstant.password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
