package com.IT.visitordatamanagement.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


import com.IT.visitordatamanagement.dao.VisitorDAO;
import com.IT.visitordatamanagement.dao.VisitorDAOImp;
import com.IT.visitordatamanagement.dto.Visitor;
import com.IT.visitordatamanagement.util.AES;
import com.IT.visitordatamanagement.util.AppConstant;
import com.IT.visitordatamanagement.util.ConnectionUtil;

public class VisitorServiceImp implements VisitorServic
{
	private static Connection con=ConnectionUtil.connectionGiver();
	VisitorDAO dao=new VisitorDAOImp();;
	
//	public VisitorServiceImp()
//	{
//		dao=new VisitorDAOImp();
//	}
	
	@Override
	public String saveVisitor(Visitor visitor) 
	{
		
		String encContact=AES.encrypt(visitor.getContact(),AppConstant.SECERET_KEY);
		String encEmail=AES.encrypt(visitor.getEmail(),AppConstant.SECERET_KEY);
		String encAddress=AES.encrypt(visitor.getAddress(), AppConstant.SECERET_KEY);
		
		visitor.setContact(encContact);
		visitor.setEmail(encEmail);
		visitor.setAddress(encAddress);
		
		return dao.saveVisitor(visitor);
	}

	@Override
	public String updateVisitor(Visitor visitor) {
		return dao.updateVisitor(visitor);
	}

	@Override
	public String deleteVisitor(Visitor visitor) throws SQLException {
		return dao.deleteVisitor(visitor);
	}

	@Override
	public Visitor deleteVisitorById(int id)
	{	
		return dao.deleteVisitorById(id);
	}

	@Override
	public Visitor getVisitorById(int id)
	{
	
		Visitor visitor=dao.getVisitorById(id);
		
		String decContact=AES.decrypt(visitor.getContact(), AppConstant.SECERET_KEY);
		String decEmail=AES.decrypt(visitor.getEmail(), AppConstant.SECERET_KEY);
		String decAddress=AES.decrypt(visitor.getAddress(), AppConstant.SECERET_KEY);
		
		visitor.setContact(decContact);
		visitor.setEmail(decEmail);
		visitor.setAddress(decAddress);
		return visitor;
		//org.apache.maven
		//option-webapp-1.4 next
		//groupid=com.dn
		//ServeletIntro
		//pack-com.It.ServletIntro-finish
		//
		//return dao.deleteVisitorById(id);
		
//		Visitor visitor=null;
//		String query="select * from visitor where id=?";
//		if(con!=null)
//		{
//			try {
//				 visitor=new Visitor();
//				PreparedStatement ps = con.prepareStatement(query);
//				ps.setInt(1, id);
//				ResultSet resultset = ps.executeQuery();
//				if(resultset.next())
//				{
//					visitor.setId(resultset.getInt(1));
//					visitor.setName(resultset.getString(2));
//				}
//				return visitor;
//				
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
	}

	@Override
	public Visitor getVisitorByContact(String contact)
	{
		String encContact=AES.encrypt(contact, AppConstant.SECERET_KEY);
		Visitor visitor=dao.getVisitorByContact(encContact);
		
		String decConstant=AES.decrypt(visitor.getContact(), AppConstant.SECERET_KEY);
		//String decEmail=AES.decrypt(visitor.getEmail(),AppConstant.SECERET_KEY);
		//String decAddress=AES.decrypt(visitor.getAddress(), AppConstant.SECERET_KEY);
		
		visitor.setContact(encContact);
		//visitor.setEmail(decEmail);
		//visitor.setAddress(decAddress);
		return visitor;
	}

	@Override
	public Visitor getVisitorByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Visitor> getAllVisitor()
	{
		String query="select * from visitor where id=?";
		if(con!=null)
		{
			try {
				 List<Visitor>list=new ArrayList();
				PreparedStatement ps = con.prepareStatement(query);
				
				ResultSet resultset = ps.executeQuery();
				while(resultset.next())
				{
					Visitor visitor=new Visitor();
					visitor.setId(resultset.getInt(1));
					visitor.setName(resultset.getString(2));
					list.add(visitor);
				}
				return list;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		List<Visitor> v=dao.getAllVisitor();
		
		return v.stream().map(e->{
			e.setName(e.getName().toUpperCase());
			e.setCourse(e.getCourse().toUpperCase());
			e.setDegree(e.getDegree().toUpperCase());
			e.setStream(e.getStream().toUpperCase());
			return e;
		}).collect(Collectors.toList());
	}

	@Override
	public List<Visitor> getVisitorDataSortedByName()
	{
		List<Visitor>visitor =getAllVisitor();
		return visitor.stream().sorted((e1,e2)->{
			return e1.getName().compareToIgnoreCase(e2.getName());
		}).collect(Collectors.toList());
	
	}

	@Override
	public List<Visitor> getDegree()
	{
		List<Visitor>visitor =getAllVisitor();
		return visitor.stream().sorted((e1,e2)->{
			return e1.getDegree().compareToIgnoreCase(e2.getDegree());
		}).collect(Collectors.toList());	}

}
