package com.IT.visitordatamanagement.controller;

import com.IT.visitordatamanagement.dao.AdminDAO;
import com.IT.visitordatamanagement.dao.AdminDAOImp;
import com.IT.visitordatamanagement.dto.Admin;

public class AdminTest {

	public static void main(String[] args) 
	{
		Admin a=new Admin();
		a.setUserName("tejam2244");
		a.setPassword("Teja@8899");
		AdminDAO admin = new AdminDAOImp();
		String sa = admin.saveAdmin(a);
		System.out.println(sa);
	}

}
