package com.IT.visitordatamanagement.controller;

import java.sql.SQLException;

import com.IT.visitordatamanagement.controller.*;
import com.IT.visitordatamanagement.dao.VisitorDAO;
import com.IT.visitordatamanagement.dao.VisitorDAOImp;
import com.IT.visitordatamanagement.dto.Visitor;
import com.IT.visitordatamanagement.service.VisitorServiceImp;
public class TestSave {

	public static void main(String[] args) 
	{
		Visitor v=new Visitor();
		
		
		//insert into database......
//		
		v.setName("john");
		v.setAddress("ap");
		v.setContact("98453456546");
		v.setCourse("btech");
		v.setDegree("masters");
		v.setEmail("john@2378");
		v.setGender("male");
		v.setStream("cricket");
		v.setThroughtpercentage("115.0");
		v.setYearOfPassout(2000);
	
		VisitorServiceImp dao=new VisitorServiceImp();
		System.out.println(dao.saveVisitor(v));
		//id, name, contact, email, degree, stream, ThroughOutPercentage, YOP, Gender, Course, Address
		
		// update the Values......
		
//		VisitorDAO dao=new VisitorDAOImp();
//		v.setCourse("History");
//		v.setName("CBN");
//		System.out.println(dao.updateVisitor(v));
		
		//delete the values..........
		
		//VisitorDAO dao=new VisitorDAOImp();
//		v.setCourse("MA");
//		try {
//			System.out.println(dao.deleteVisitor(v));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}

}
