package model;

import java.io.Serializable;

public class StudentBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String rollno;
	private String email;
	private String address;
	private String cgpa;
	private String attendance;
	
	public StudentBean() {
		super();
		this.id = id;
		this.name = name;
		this.rollno = rollno;
		this.email = email;
		this.address = address;
		this.cgpa = cgpa;
		this.attendance = attendance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCgpa() {
		return cgpa;
	}
	public void setCgpa(String cgpa) {
		this.cgpa = cgpa;
	}
	public String getattendance() {
		return attendance;
	}
	public void setattendance(String attendance) {
		this.attendance = attendance;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
	
	

	}
