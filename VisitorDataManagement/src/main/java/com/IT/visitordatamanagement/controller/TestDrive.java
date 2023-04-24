package com.IT.visitordatamanagement.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.IT.visitordatamanagement.dao.VisitorDAO;
import com.IT.visitordatamanagement.dao.VisitorDAOImp;
import com.IT.visitordatamanagement.dto.Visitor;

public class TestDrive {

	public static void main(String[] args) 
	{
		System.out.println("select operations");
		for(;;)
		{
			System.out.println("Enter\n"
					+ "1.insert\n"
					+ "2.update\n"
					+ "3.delete\n");
			Scanner scn=new Scanner(System.in);
			System.out.println("choose operations");
			int option=scn.nextInt();
			if(option==1)
			{
				//id, name, contact, email, degree, stream, 
				//ThroughOutPercentage, YOP, Gender, Course, Address
				
				Visitor v=new Visitor();
				//insert into database......
				
				System.out.print("enter name =");
				v.setName(scn.next());
				
				System.out.print("enter contact =");
				v.setContact(scn.next());
				
				System.out.print("enter email= ");
				v.setEmail(scn.next());
				
				System.out.print("enter degree =");
				v.setDegree(scn.next());
				
				System.out.print("enter stream=");
				v.setStream(scn.next());
				
				System.out.print("enter Percentage=");
				v.setThroughtpercentage(scn.next());
				
				System.out.print("enter YOP=");
				v.setYearOfPassout(scn.nextInt());
				
				System.out.print("enter gender=");
				v.setGender(scn.next());
				
				System.out.print("enter course =");
				v.setCourse(scn.next());
				
				System.out.print("enter address =");
				v.setAddress(scn.next());
				
				VisitorDAO dao=new VisitorDAOImp();
				System.out.println(dao.saveVisitor(v));
			}
			if(option==2)
			{
				//update.....
				Visitor v=new Visitor();
				VisitorDAO dao=new VisitorDAOImp();
				v.setCourse(scn.next());
				v.setName(scn.next());
				System.out.println(dao.updateVisitor(v));
				
			}
			if(option==3)
			{
				//delete......
				Visitor v=new Visitor();
				VisitorDAO dao=new VisitorDAOImp();
				System.out.println("Enter");
				v.setCourse(scn.next());
				try {
					System.out.println(dao.deleteVisitor(v));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else {
				System.out.println("Invalid operation");
			}
			System.out.println("do you want to Continue press y/Y");
			char ch=scn.next().charAt(0);
			if(ch=='y'||ch=='Y')continue;
			else {
				System.out.println("thank you for using ");
				System.out.println("try Again..");
				break;
			}
			
		}
		
	}

}
