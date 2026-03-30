import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class EmployeeMain {

	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in)){
			int choice = 0;
			
			ArrayList<Employee> arrEmp = new ArrayList<>();
			LinkedList<Employee> LLEmp = new LinkedList<>();
			
			do {
				System.out.println("Choose among the following");
				System.out.println("\n1. Add into Array List"
						+ "\n2. Add into LinkedList"
						+ "\n3. Push into LinkedList"
						+ "\n4. Display employee"
						+ "\n5. Sort by salary"
						+ "\n6. Sort by name"
						+ "\n7. Exit");
							
				System.out.println("Enter the choice");
				choice = scanner.nextInt();
							
				switch(choice) {
				case 1:
				{				
					System.out.println("Enter the number of employees to add");
					int num = scanner.nextInt();
					
					for(int i = 0; i < num; i++) {
						System.out.println("Enter the data for Employee " + i);
						Employee objEmployee = new Employee();
						objEmployee.acceptData(scanner);
						arrEmp.add(objEmployee);
					}					
				}
				break;
				
				case 2:
				{					
					System.out.println("Enter the number of employees to add");
					int num = scanner.nextInt();
					
					for(int i = 0; i < num; i++) {
						System.out.println("Enter the data for Employee " + i);
						Employee objEmployee = new Employee();
						objEmployee.acceptData(scanner);
						LLEmp.add(objEmployee);
					}
				}
				break;
				
				case 3:
				{
					LLEmp.addAll(arrEmp);
					System.out.println("Addition successfull!!");
				}
				break;
				
				case 4:
				{
					display(LLEmp);
				}
				break;
				
				case 5:
				{
					sortSal(LLEmp);
				}
				break;
				
				case 6:
				{
					sortName(LLEmp);
				}
				break;
				
				case 7:
					System.out.println("Program exit!!");
					break;
				
				default:
					System.out.println("Invalid choice!!");
				}
				
			}while(choice != 7);
		}

	}
	
	public static void display(LinkedList<Employee> arrList) {
		Iterator<Employee> iter = arrList.iterator();
		while(iter.hasNext()) {
			Employee data = iter.next();
			System.out.println("ID: " + data.geteID());
			System.out.println("Name: " + data.getName());
			System.out.println("Salary: " + data.getSalary());
		}
	}
	
	public static void sortSal(LinkedList<Employee> arrList) {
		
		ArrayList<Integer> tempArr = new ArrayList<>();
		
		Iterator<Employee> iter = arrList.iterator();
		
		while(iter.hasNext()) {
			Employee data = iter.next();
			tempArr.add(data.getSalary())  ;
		}	
		Collections.sort(tempArr);
		
		Iterator<Integer> iter1 = tempArr.iterator();
		while(iter1.hasNext()) {
			int data = iter1.next();
			System.out.println("Sorted data is: ");
			System.out.println(data);
		}		
	}
	
	public static void sortName(LinkedList<Employee> arrList) {
		ArrayList<String> tempArr = new ArrayList<>();
		
		Iterator<Employee> iter = arrList.iterator();
		
		while(iter.hasNext()) {
			Employee data = iter.next();
			tempArr.add(data.getName())  ;
		}	
		Collections.sort(tempArr);
		
		Iterator<String> iter1 = tempArr.iterator();
		while(iter1.hasNext()) {
			String data = iter1.next();
			System.out.println("Sorted name is: ");
			System.out.println(data);
		}	
	}
	
	

}
