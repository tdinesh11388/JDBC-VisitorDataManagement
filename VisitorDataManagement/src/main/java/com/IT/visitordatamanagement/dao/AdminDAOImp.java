package com.IT.visitordatamanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.IT.visitordatamanagement.dto.Admin;
import com.IT.visitordatamanagement.util.ConnectionAdmin;
import com.IT.visitordatamanagement.util.ConnectionUtil;

public class AdminDAOImp implements AdminDAO
{
	private static Connection con=ConnectionAdmin.connectionProvide();
	@Override
	public String saveAdmin(Admin admin)
	{
		if(con!=null)
		{
			
			String query="insert into admin (username, password) values(?,?)";
			try {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, admin.getUserName());
				ps.setString(2, admin.getPassword());
				int res = ps.executeUpdate();
				return "updated rows="+res;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "denied insert values";
	}

	@Override
	public Admin adminLogin(String userName, String password)
	{
		AdminDAOImp a=new AdminDAOImp();
		String query="select ? from admin where username=?";
		//PreparedStatement ps = con.prepareStatement(query);
		//ps.setString(1,userName);
		return null;
	}

}
