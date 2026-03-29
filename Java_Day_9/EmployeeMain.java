package com.day9.pluto;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.day2.GetInput;

public class EmployeeMain {

	public static void main(String[] args) {
		
		int choice = 0;
		
		final int MENU_ADD = 1;
		final int MENU_DISPLAY = 2;
		final int MENU_SORT = 3;
		final int MENU_SAVE = 4;
		final int MENU_LOAD = 5;
		final int MENU_EXIT = 6;
		
		LinkedList<Employee> objEmployee = new LinkedList<>();
		
		do {
				
			System.out.println("\nChoose among the following");
			System.out.println("1. Add");
			System.out.println("2. Display");
			System.out.println("3. Sort");
			System.out.println("4. Save to file");
			System.out.println("5. Load from file");
			System.out.println("6. Exit");
			
			choice = GetInput.getInt();
			
			switch(choice) {

				case MENU_ADD:
				{
					Employee emp = acceptEmpData();
				    if(emp != null)
				        objEmployee.add(emp);
				    
				}
				break;
				
				case MENU_DISPLAY:
				{
					int disMenuChoice = 0;
					do {
						System.out.print("\n1. Display all Employees");
						System.out.print("\n2. Display first Employee");
						System.out.print("\n3. Display next Employee");
						System.out.print("\n4. Display previous Employee");
						System.out.print("\n5. Display last Employee");
						System.out.print("\n6. Exit : ");
						System.out.print("\nEnter your choice: ");
						
						disMenuChoice = GetInput.getInt();
						
						final int DISPLAY_ALL = 1;
						final int DISPLAY_FIRST = 2;
						final int DISPLAY_NEXT = 3;
						final int DISPLAY_PREV = 4;
						final int DISPLAY_LAST = 5;
						final int EXIT_DISPLAY = 6;
						
						int disMethod = 0;
						
						switch(disMenuChoice) {
							case DISPLAY_ALL:
							{
								disMethod = 1;
								displayEmp(disMethod, objEmployee);
							}
							break;
							
							case DISPLAY_FIRST:
							{
								disMethod = 2;
								displayEmp(disMethod, objEmployee);
							}
							break;
							
							case DISPLAY_NEXT:
							{
//								disMethod = 3;
//								displayEmp(disMethod, objEmployee);
							}
							break;
							
							case DISPLAY_PREV:
							{
								disMethod = 4;
								displayEmp(disMethod, objEmployee);
							}
							break;
							
							case DISPLAY_LAST:
							{
								disMethod = 5;
								displayEmp(disMethod, objEmployee);
							}
							break;
							
							case EXIT_DISPLAY:
							break;
							
							default:
							{
								System.out.println("Invalid choice!!");
							}
							break;
						}
						
					}while(disMenuChoice != 6);
					
				}
				break;
				
				case MENU_SORT:
				{
					int sort_choice = 0;
					do {
					
						System.out.print("\n1. Sort Manager by Salary");
						System.out.print("\n2. Sort Engineer by Salary");
						System.out.print("\n3. Sort Salesman by Salary");
						System.out.print("\n4. Sort all Employees by name in ascending order");
						System.out.print("\n5. Sort all Employees by name in descending order");
						System.out.print("\n6. Exit : ");
						System.out.print("\nEnter your choice: ");
						
						final int SORT_MANAGER = 1;
						final int SORT_ENGINEER = 2;
						final int SORT_SALESMAN = 3;
						final int SORT_NAME_ASC = 4;
						final int SORT_NAME_DESC = 5;
						final int EXIT_SORT = 6;
						
						
						sort_choice = GetInput.getInt();
						
						switch(sort_choice) {
							case SORT_MANAGER:
							{
								int post = 1;
								System.out.println("Sorted Manager salaries are");
								sortEmpSal(post, objEmployee);							
							}
							break;
							
							case SORT_ENGINEER:
							{
								int post = 2;
								System.out.println("Sorted Engineer salaries are");
								sortEmpSal(post, objEmployee);
							}
							break;
							
							case SORT_SALESMAN:
							{
								int post = 3;
								System.out.println("Sorted Salesman salaries are");
								sortEmpSal(post, objEmployee);
							}
							break;
							
							case SORT_NAME_ASC:
							{
								int sort = 1;
								System.out.println("Sorted Employee names in ascending order");
								sortByName(sort, objEmployee);
							}
							break;
							
							case SORT_NAME_DESC:
							{
								int sort = 2;
								System.out.println("Sorted Employee names in descending order");
								sortByName(sort, objEmployee);
							}
							break;
							
							case EXIT_SORT:
							{
								System.out.println("Program exit!!");								
							}
							break;
							
							default:
							{
								System.out.println("Invalid choice!!");						
							}
							break;
						}
					}while(sort_choice != 6);					
				}
				break;
				
				case MENU_SAVE: 
				{
					loadToFile(objEmployee);
				}
				break;
				
				case MENU_LOAD:
				{
					readFromFile(objEmployee);
				}
				break;
				
				case MENU_EXIT:
				{
					System.out.print("Program exit!!");					
				}
				break;
				
				default:
				{
					System.out.println("Invalid choice!!");					
				}
				break;
			}
			
		}while(choice != 6);

	}
	
	public static void sortEmpSal(int pos, LinkedList<Employee> list) {
	    Node<Employee> temp = list.getStart();
	    int count = 0;
	    
	    while(temp != null) {
	        Employee emp = (Employee) list.getData();
	        if( (pos == 1 && emp instanceof Manager) ||
	            (pos == 2 && emp instanceof Engineer) ||
	            (pos == 3 && emp instanceof Salesman) ) 
	        {
	            count++;
	        }
	        temp = list.getNext();
	    }
	
	    float[] salaries = new float[count];
	    
	    temp = list.getStart();
	    int index = 0;
	
	    while(temp != null) {
	        Employee emp = list.getData();
	        if( (pos == 1 && emp instanceof Manager) ||
	            (pos == 2 && emp instanceof Engineer) ||
	            (pos == 3 && emp instanceof Salesman) )
	        {
	            salaries[index] = emp.calculateSal();
	            index++;
	        }
	        temp = list.getNext();
	    }
	
	    for(int i = 0; i < count - 1; i++) {
	        for(int j = 0; j < count - 1 - i; j++) {
	            if(salaries[j] > salaries[j + 1]) {
	                float tempVal = salaries[j];
	                salaries[j] = salaries[j + 1];
	                salaries[j + 1] = tempVal;
	            }
	        }
	    }
	
	    for(int i = 0; i < count; i++) {
	        System.out.println(salaries[i]);
	    }
	}
	
	public static void sortByName(int order, LinkedList<Employee> list) {
	    Node<Employee> temp = list.getStart();
	    int count = 0;
	    while(temp != null) {
	        count++;
	        temp = list.getNext();
	    }

	    String[] names = new String[count];
	
	    temp = list.getStart();
	    int index = 0;
	
	    while(temp != null) {
	        Employee emp = list.getData();
	        names[index] = emp.getName();
	        index++;
	        temp = list.getNext();
	    }

	    for(int i = 0; i < count - 1; i++) {
	        for(int j = 0; j < count - 1 - i; j++) {
	            int result = names[j].compareTo(names[j + 1]);
	            if( (order == 1 && result > 0) || 
	                (order == 2 && result < 0) ) 
	            {
	                String tempName = names[j];
	                names[j] = names[j + 1];
	                names[j + 1] = tempName;
	            }
	        }
	    }

	    for(int i = 0; i < count; i++) {
	        System.out.println(names[i]);
	    }
	}
	
	public static void displayEmp(int disMethod, LinkedList<Employee> list) {

	    Node<Employee> temp = list.getStart();
	    Employee emp = list.getData();

	    if(temp == null) {
	        System.out.println("List is empty");
	        return;
	    }
	    
	    Node<Employee> startTemp = list.getCurr();
	    
	    if(disMethod == 4) {
	    	if(list.getStart() == list.getLast()) {
		    	System.out.println("Only one entry present");
		    	System.out.println("Employee name is: " + emp.getName());
		    }else {
		    	startTemp = list.getPrev();
		    	System.out.println("The previous employee is: " + emp.getName());
		    }
	    }
	    
	    
	    
	    if(disMethod == 5) {
	        Node<Employee> endTemp = list.getLast();
	        if(endTemp == null) {
	            System.out.println("List is empty");
	            return;
	        }
	        Employee emplast = endTemp.getData();
	        System.out.println("Last Employee: " + emplast.getName());
	        return;
	    }

	    while(temp != null) {

	        

	        System.out.println("\nName: " + emp.getName());
	        System.out.println("Address: " + emp.getAddress());
	        System.out.println("Age: " + emp.getAge());
	        System.out.println("Gender: " + emp.isGender());
	        System.out.println("Basic Salary: " + emp.getBasicSalary());

	        if(emp instanceof Manager) {
	            Manager m = (Manager) emp;
	            System.out.println("HRA: " + m.getHra());
	            System.out.println("Total Salary: " + m.calculateSal());

	        } else if(emp instanceof Engineer) {
	            Engineer e = (Engineer) emp;
	            System.out.println("OverTime: " + e.getOverTime());
	            System.out.println("Total Salary: " + e.calculateSal());

	        } else if(emp instanceof Salesman) {
	            Salesman s = (Salesman) emp;
	            System.out.println("Commission: " + s.getCommission());
	            System.out.println("Total Salary: " + s.calculateSal());
	        }
	        
	        if(disMethod == 2) {
	        	break;
	        }
	        temp = list.getNext();
	    }
	}
	
	public static Employee acceptEmpData() {
		System.out.print("Enter name: ");
	    String name = GetInput.inputString();

	    System.out.print("Enter address: ");
	    String address = GetInput.inputString();
	    	    
    	int age = 0;
    	
    	boolean check = true;
    	
    	do {
		    try {
		    	System.out.print("Enter age: ");
		    	age = GetInput.getInt();
		    	if(age < 0 || age > 100) {
		    		check = true;
		    		throw new Exception("Invalid age entered!!");		    		
		    	}else {
		    		check = false;
		    	}
		    }
		    catch(Exception e)
		    {
		    	System.out.println("Invalid");
		    }
    	}while(check);
	    
	    System.out.print("Enter gender (true/false): ");
	    boolean gender = Boolean.parseBoolean(GetInput.inputString());

	    System.out.print("Enter basic salary: ");
	    float salary = GetInput.getInt();

	    System.out.println("1. Manager"
	    		+ "\n2. Engineer"
	    		+ "\n3. Salesman");
	    int choice = GetInput.getInt();

	    switch(choice) {
	        case 1:
	            System.out.print("Enter HRA: ");
	            int hra = GetInput.getInt();
	            Manager objManager = new Manager(name, address, age, gender, salary, hra);
	            return objManager;

	        case 2:	        
	            int ot = 0;
	        	do {
	    		    try {
	    		    	System.out.print("Enter Over Time: ");
	    		    	ot = GetInput.getInt();
	    		    	if(ot > 4) {
	    		    		check = true;
	    		    		throw new Exception("Invalid Over Time entered!!");		    		
	    		    	}else {
	    		    		check = false;
	    		    	}
	    		    }
	    		    catch(Exception e)
	    		    {
	    		    	System.out.println("Invalid");
	    		    }
	        	}while(check);
	            Engineer objEngineer = new Engineer(name, address, age, gender, salary, ot);
	            return objEngineer;

	        case 3:
	            System.out.print("Enter Commission: ");
	            float commission = GetInput.getFloat();
	            Salesman objSalesman = new Salesman(name, address, age, gender, salary, commission);
	            return objSalesman;
	    }

	    return null;
	}
	
	public static void loadToFile(LinkedList<Employee> list) {
		try (FileOutputStream filestream = new FileOutputStream("D:\\java_b2\\Employee.txt");
				ObjectOutputStream objectStream = new ObjectOutputStream(filestream)) 
		{
			Node<Employee> temp = list.getStart();
			if(temp == null) {
		        System.out.println("List is empty");
		        return;
		    }
		    while(temp != null) {

		        Employee emp = (Employee) list.getData();
		        objectStream.writeObject(emp);
		        System.out.println(emp.getAge());
		        temp = list.getNext();
		    }
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void readFromFile(LinkedList<Employee> list) {
		try (FileInputStream filestream = new FileInputStream("D:\\java_b2\\Employee.txt");
				ObjectInputStream objectStream = new ObjectInputStream(filestream)) 
		{
			while(true) {
				try {
					Employee emp = (Employee) objectStream.readObject();
					System.out.println("Age is: " + emp.getAge());
					System.out.println("Basic Salary is: " + emp.getBasicSalary());
					if(emp instanceof Manager) {
			            Manager m = (Manager) emp;
			            System.out.println("HRA: " + m.getHra());
			            System.out.println("Total Salary: " + m.calculateSal());

			        } else if(emp instanceof Engineer) {
			            Engineer e = (Engineer) emp;
			            System.out.println("OverTime: " + e.getOverTime());
			            System.out.println("Total Salary: " + e.calculateSal());

			        } else if(emp instanceof Salesman) {
			            Salesman s = (Salesman) emp;
			            System.out.println("Commission: " + s.getCommission());
			            System.out.println("Total Salary: " + s.calculateSal());
			        }
					
				}
				catch(EOFException e) {
					break;
				}
			}
		} 
		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
}



