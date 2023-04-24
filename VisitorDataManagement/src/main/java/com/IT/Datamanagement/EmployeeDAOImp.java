package com.IT.Datamanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class EmployeeDAOImp implements EmployeeDAO
{

	@Override
	public Employee get(int id) throws SQLException
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection con = Database.getConnection();
		Employee emp=null;
		
		String query="select * from emp where id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			int id1= rs.getInt(1);
			String fname = rs.getString(2);
			String lname = rs.getString(3);
			int deptid = rs.getInt(4);
			
			emp=new Employee(id1,fname,lname,deptid);
		}
		return emp;
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Employee e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Employee e) throws SQLException {
		Connection con=Database.getConnection();
		String query="insert into emp (id, FName, LName, deptid) values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, e.getId());
		ps.setString(2, e.getFName());
		ps.setString(3, e.getLName());
		ps.setInt(4, e.getDeptid());
		int res = ps.executeUpdate();
		con.close();
		return res;
	}

	@Override
	public int update(Employee e) throws SQLException
	{
		Connection con = Database.getConnection();
		String query="update emp set LName=? where id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, e.getLName());
		ps.setInt(2, e.getId());
		int res = ps.executeUpdate();
		con.close();
		return res;
	}

	@Override
	public int delete(Employee e)
	{
		int res=0;
		try {
			Connection con = Database.getConnection();
			String query="delete from emp where LName=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, e.getLName());
			res= ps.executeUpdate();
			con.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return res;
	}
	
}
