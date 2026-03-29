package com.day9.pluto;

public class Manager extends Employee {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8170531134392012544L;
	protected float hra;

	public Manager(String name, String address, int age, 
			boolean gender, float basicSalary, float hra) {
		super(name, address, age, gender, basicSalary);
		

		setHra(hra);
	}
	
	@Override
	public float calculateSal() {
		float grossSal = basicSalary + hra;
		return grossSal;
	}
	
	public float getHra() {
		return hra;
	}

	public void setHra(float hra) {
		this.hra = hra;
	}

}