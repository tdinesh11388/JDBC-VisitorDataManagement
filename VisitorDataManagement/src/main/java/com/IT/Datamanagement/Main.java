package com.IT.Datamanagement;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException 
	{
		
//		Connection con = Database.getConnection();
//		if(con!=null)
//		{
//			System.out.println("database Connection successfully");
//		}
		
		//insert values......
		
//		EmployeeDAO emp=new EmployeeDAOImp();
//		
//		Employee employee=new Employee(3,"N","MON",5);
//		int res = emp.insert(employee);
//		System.out.println(res);
		
		//getting values.....
		
//		EmployeeDAO emp=new EmployeeDAOImp();
//		Employee e=emp.get(2);
//		System.out.println(e);
		
		//update Values.......
		
//		EmployeeDAO emp=new EmployeeDAOImp();
//		
//		Employee e=new Employee(2,"N","ThimmaNaidu",5);
//		emp.update(e);
//		System.out.println(e);
		
		EmployeeDAO emp1=new EmployeeDAOImp();
		Employee employee=new Employee(3,"N","MON",5);
		int del= emp1.delete(employee);
		
		System.out.println(del);
		
	}

}
