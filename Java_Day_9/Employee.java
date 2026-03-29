package com.day9.pluto;

import java.io.Serializable;

public abstract class Employee implements Serializable{

	private static final long serialVersionUID = 1L;
	protected String name;
	protected String address;
	protected int age;
	protected boolean gender;
	protected float basicSalary;
	public static int count = 0;
	
	public Employee(String name, String address, int age, boolean gender, float basicSalary) {
		super();
		
		if(validateFields(name)) {
			setName(name);
		}else {
			setName("No Name");
		}
		
		if(validateFields(address)) {
			setAddress(address);
		}else {
			setAddress("No address");
		}
		
		if(validateIntFields(age)) {
			setAge(age);
		}else {
			setAge(0);
		}
		
		if(validateGender(gender)) {
			setGender(gender);
		}else {
			gender = false;
		}
		
		if(validateSal(basicSalary)) {
			setBasicSalary(basicSalary);
		}else {
			basicSalary = 0f;
		}
		
	}
	
	public boolean validateFields(String field) {
		if(field == null || field.length() < 3 || field.equals("")) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean validateIntFields(int intField) {
		if(intField < 1 || intField > 100) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean validateSal(float sal) {
		if(sal < 1) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean validateGender(boolean gender) {
		if(gender != false || gender != true) {
			return false;
		}else {
			return true;
		}
	}
	
	
	public abstract float calculateSal();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public float getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}
	
}