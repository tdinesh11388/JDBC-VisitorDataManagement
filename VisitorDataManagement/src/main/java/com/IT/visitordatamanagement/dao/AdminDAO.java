package com.IT.visitordatamanagement.dao;

import com.IT.visitordatamanagement.dto.Admin;

public interface AdminDAO {
	
	public String saveAdmin(Admin admin);
	
	public Admin adminLogin(String userName,String password);
	
}
