package model;

import java.io.Serializable;

public class AddStaffBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String pass;
	
	public AddStaffBean() {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		
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
	
	public void setpassword(String pass) {
		this.pass = pass;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getpassword() {
		return pass;
	}

		
	
	

	}
