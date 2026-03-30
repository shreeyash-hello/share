import java.util.Scanner;

public class Employee {

	int eID;
	String name;
	int salary;

	public int geteID() {
		return eID;
	}

	public void seteID(int eID) {
		this.eID = eID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public void acceptData(Scanner scanner) {
											
			System.out.println("Enter the employee id");
			int eid = scanner.nextInt();
			System.out.println("Enter the salary");
			int sal = scanner.nextInt();
			System.out.println("Enter the name");
			String name = scanner.next();
			
			setSalary(sal);
			setName(name);
			seteID(eid);
		
	}
	
}
