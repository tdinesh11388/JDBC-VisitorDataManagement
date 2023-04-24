package com.IT.visitordatamanagement.service;

import java.sql.SQLException;
import java.util.List;

import com.IT.visitordatamanagement.dto.Visitor;

public interface VisitorServic
{
	public String saveVisitor(Visitor visitor);
	
	public String updateVisitor(Visitor visitor);
	
	public String deleteVisitor(Visitor visitor) throws SQLException;
	
	public Visitor deleteVisitorById(int id);
	
	public Visitor getVisitorById(int id);
	
	public Visitor getVisitorByContact(String contact);
	
	public Visitor getVisitorByEmail(String email);
	
	public List<Visitor> getAllVisitor();
	
	public List<Visitor> getVisitorDataSortedByName();
	
	public List<Visitor> getDegree();
	
	
}
