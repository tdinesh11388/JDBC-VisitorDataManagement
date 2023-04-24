package com.IT.visitordatamanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.IT.visitordatamanagement.dto.*;
import com.IT.visitordatamanagement.util.AES;
import com.IT.visitordatamanagement.util.AppConstant;
import com.IT.visitordatamanagement.util.ConnectionUtil;

public class VisitorDAOImp implements VisitorDAO
{
	private static Connection con=ConnectionUtil.connectionGiver();
	
	public String saveVisitor(Visitor visitor)
	{
		//Connection con=ConnectionUtil.connectionGiver();
		if(con!=null)
		{
			String query="insert into visitor (`name`, `contact`, `email`, `degree`, `stream`, `ThroughOutPercentage`, `YOP`, `Gender`, `Course`, `Address`)"
					+ "values(?,?,?,?,?,?,?,?,?,?)";
			
			try {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, visitor.getName());
				ps.setString(2, visitor.getContact());
				ps.setString(3, visitor.getEmail());
				ps.setString(4, visitor.getDegree());
				ps.setString(5, visitor.getStream());
				ps.setString(6, visitor.getThroughtpercentage());
				ps.setInt(7, visitor.getYearOfPassout());
				ps.setString(8, visitor.getGender());
				ps.setString(9, visitor.getCourse());
				ps.setString(10,visitor.getAddress());
				
				int res = ps.executeUpdate();
				return "no.of  rows added ="+res;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "connected sucessfully";
		}
		return "Something went wrong";
	}

	public String updateVisitor(Visitor visitor)
	{
		
		try {
			String query="update visitor set course=? where name=?";
			PreparedStatement ps = con.prepareStatement(query);
			System.out.println("enter");
			ps.setString(1, visitor.getCourse());
			ps.setString(2, visitor.getName());
			int ex = ps.executeUpdate();
			return "no.of  rows added ="+ex;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String deleteVisitor(Visitor visitor) 
	{
		String query="delete from visitor where course=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, visitor.getCourse());
			int res = ps.executeUpdate();
			con.close();
			return "no.of rows added ="+res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Visitor deleteVisitorById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Visitor getVisitorById(int id)
	{
		Visitor visitor=new Visitor();
		String decContact=AES.decrypt(visitor.getContact(), AppConstant.SECERET_KEY);
		String decEmail=AES.decrypt(visitor.getEmail(), AppConstant.SECERET_KEY);
		String decAddress=AES.decrypt(visitor.getAddress(), AppConstant.SECERET_KEY);
		
		visitor.setContact(decContact);
		visitor.setEmail(decEmail);
		visitor.setAddress(decAddress);
		return visitor;
	}

	@Override
	public Visitor getVisitorByContact(String contact) 
	{
		return null;
	}

	@Override
	public Visitor getVisitorByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Visitor> getAllVisitor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Visitor> getVisitorDataSortedByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Visitor> getDegree() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
