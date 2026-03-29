package com.day9.pluto;


public class Salesman extends Employee{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3139034583459159057L;
	protected float commission;

	public Salesman(String name, String address, int age, 
			boolean gender, float basicSalary, float commission) {
		super(name, address, age, gender, basicSalary);
		
		setCommission(commission);
	}
	
	@Override
	public float calculateSal() {
		float grossSal = basicSalary + commission;
		return grossSal;
	}

	public float getCommission() {
		return commission;
	}

	public void setCommission(float commission) {
		this.commission = commission;
	}
	
	
	
}
