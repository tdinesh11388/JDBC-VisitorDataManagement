package com.IT.visitordatamanagement.controller;

import java.util.Vector;
import java.util.concurrent.ExecutorService;

import com.IT.visitordatamanagement.dao.VisitorDAO;
import com.IT.visitordatamanagement.dao.VisitorDAOImp;
import com.IT.visitordatamanagement.dto.Visitor;
import com.IT.visitordatamanagement.service.VisitorServiceImp;

public class TestGetById {

	public static void main(String[] args) 
	{
		Visitor v=new Visitor();
		VisitorServiceImp dao=new VisitorServiceImp();
		//VisitorDAO dao=new VisitorDAOImp();
		System.out.println(dao.getVisitorById(10));

	}

}
