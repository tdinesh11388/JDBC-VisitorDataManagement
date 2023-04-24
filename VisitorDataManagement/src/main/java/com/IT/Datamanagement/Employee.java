package com.IT.Datamanagement;

public class Employee
{
	private int id;
	private String FName;
	private String LName;
	private int deptid;
	//id, FName, LName, deptid
	public Employee(int id, String fName, String lName, int deptid) {
		super();
		this.id = id;
		FName = fName;
		LName = lName;
		this.deptid = deptid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFName() {
		return FName;
	}
	public void setFName(String fName) {
		FName = fName;
	}
	public String getLName() {
		return LName;
	}
	public void setLName(String lName) {
		LName = lName;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", FName=" + FName + ", LName=" + LName + ", deptid=" + deptid + "]";
	}
	
	
}
