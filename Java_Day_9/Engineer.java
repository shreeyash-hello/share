package com.day9.pluto;

public class Engineer extends Employee {
	/**
	 * 
	 */
	private static final long serialVersionUID = -717488695966261219L;
	protected float overTime;

	public Engineer(String name, String address, int age, 
			boolean gender, float basicSalary, float overTime) {
		super(name, address, age, gender, basicSalary);
		

		setOverTime(overTime);
	}
	
	@Override
	public float calculateSal() {
		float grossSal = basicSalary + overTime*150;
		return grossSal;
	}

	public float getOverTime() {
		return overTime;
	}

	public void setOverTime(float overTime) {
		this.overTime = overTime;
	}
	
	
	
	
}
