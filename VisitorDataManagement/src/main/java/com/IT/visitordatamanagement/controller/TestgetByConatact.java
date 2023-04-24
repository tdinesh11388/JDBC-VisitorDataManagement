package com.IT.visitordatamanagement.controller;

import com.IT.visitordatamanagement.dao.VisitorDAO;
import com.IT.visitordatamanagement.dao.VisitorDAOImp;
import com.IT.visitordatamanagement.service.VisitorServic;
import com.IT.visitordatamanagement.service.VisitorServiceImp;

public class TestgetByConatact {

	public static void main(String[] args) 
	{
		VisitorServic dao=new VisitorServiceImp();
		System.out.println(dao.getVisitorByContact("9058847547"));
	}

}
