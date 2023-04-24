   package com.IT.visitordatamanagement.controller;

import com.IT.visitordatamanagement.dao.VisitorDAO;
import com.IT.visitordatamanagement.dao.VisitorDAOImp;
import com.IT.visitordatamanagement.dto.Visitor;

public class TestConnection {

	public static void main(String[] args) 
	{
		VisitorDAO dao=new VisitorDAOImp();
		
	//	Visitor v=new Visitor(1,"aa","3245","a@13","mca","cs", "2020", 80, "m", "computer","ap");
		
		
		//System.out.println(dao.saveVisitor(new Visitor()));
	}

}
