package com.IT.Datamanagement;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO
{
	Employee get(int id) throws SQLException;
	
	List<Employee>getAll();
	
	int save(Employee e);
	
	int insert(Employee e) throws SQLException;
	
	int update(Employee e) throws SQLException;
	
	int delete(Employee e);
	
}
