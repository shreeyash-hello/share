package com.uselessme.stillalive;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Function;

public class ProductsMain {

	public static void main(String[] args) {
		
		ArrayList<SaleRecord> arrProducts = readFromFile();
		
		try (Scanner scanner = new Scanner(System.in)) {
			int choice = 0;
			do {
				System.out.println("Enter from the below choices"
						+ "\n1. Add product"
						+ "\n2. Display all sales for specific product"
						+ "\n3. Display all sales by category"
						+ "\n4. Display total and average sales amount by product"
						+ "\n5. Display all sales where the sale amount is greater than 2500/-"
						+ "\n6. Exit");
				
				choice = scanner.nextInt();
				switch (choice) {
					case 1:
					{
						int sub_choice = 0;
						do {
							
							System.out.println("Enter the category" + "\n1. Electronics" + "\n2. Fashion"
									+ "\n3. Grocery" + "\n4. Home Appliances" + "\n5. End");
							
							System.out.println("Enter your choice");
							sub_choice = scanner.nextInt();
							
							Category category = null;
							
							switch (sub_choice) {
								case 1: 
									{
										category = Category.ELECTRONICS;
										acceptData(arrProducts, category, scanner);
									}
								break;
								
								case 2: 
									{
										category = Category.FASHION;
										acceptData(arrProducts, category, scanner);
									}
								break;
								
								case 3: 
									{
										category = Category.GROCERY;
										acceptData(arrProducts, category, scanner);
									}
								break;
								
								case 4: 
									{
										category = Category.HOME_APPLIANCES;
										acceptData(arrProducts, category, scanner);
									}
								break;
								
								case 5:
									break;
	
								default:
									System.out.println("Invalid choice");
									break;
								}
							
						} while (sub_choice != 5);
					
						writeToFile(arrProducts);
					}
					break;
						
					case 2:
					{
						System.out.println("Enter the name of product");
						String searchName = scanner.next();
						
						boolean found = false;
						
						for(SaleRecord s : arrProducts) {
							if(s.getProductName().equals(searchName)) {
								System.out.println(s);
								found = true;
							}
						}
						
						if(!found) {
							System.out.println("Item not found");
						}
						
					}
					break;
					
					case 3:
					{
						System.out.println("Enter the category to filter" + "\n1. Electronics" + "\n2. Fashion"
								+ "\n3. Grocery" + "\n4. Home Appliances" + "\n5. End");
						int categoryChoice = scanner.nextInt();
						filterSalesCategory(arrProducts, categoryChoice);
					}
					break;
					
					case 4:
					{
						System.out.println("Enter the name of the product");
						String prod = scanner.next();
						totalAvgSales(arrProducts, prod);
					}
					break;
					
					case 5:
					{
						filterSales(arrProducts);
					}
					break;
					
					case 6:
						System.out.println("Program exit");
						break;
	
					default:
						break;
				}
			} while (choice != 6);
		}
		
	}

	public static void writeToFile(ArrayList<SaleRecord> arrRecord) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("G:\\clg stuff\\sales_data.txt"));
			oos.writeObject(arrRecord);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<SaleRecord> readFromFile() {
		ArrayList<SaleRecord> arrRecords = new ArrayList<>();
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("G:\\clg stuff\\sales_data.txt"));
			arrRecords = (ArrayList<SaleRecord>) ois.readObject();
			ois.close();
			
	        if (!arrRecords.isEmpty()) {
	            int lastId = arrRecords.get(arrRecords.size() - 1).getSaleId();
	            SaleRecord.setCount(lastId + 1);
	        }
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println("File is empty, starting fresh");
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return arrRecords;
	}
	
	public static void acceptData(ArrayList<SaleRecord> arrRecord, Category category, Scanner scanner) {
		System.out.println("Enter product name");
		String name = scanner.next();
		
		System.out.println("Enter quantity");
		int qty = scanner.nextInt();
		
		System.out.println("Enter amount");
		double amt = scanner.nextDouble();
		
		try {
			SaleRecord objRecords = new SaleRecord(name, category, qty, amt);
			arrRecord.add(objRecords);
		} catch (InvalidInputException | EmptyFieldException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
	}
	
	public static void filterSales(ArrayList<SaleRecord> arrRecords) {
		Predicate<SaleRecord> filterSales = a -> a.getAmount() > 2500; 
		boolean found = false;
		
		for(SaleRecord s : arrRecords) {
			if(filterSales.test(s)) {
				System.out.println(s);
				found = true;
			}
		}
		
		if(!found) {
			System.out.println("No records found");
		}
	}
	
	public static void filterSalesCategory(ArrayList<SaleRecord> arrRecords, int category) {
		Predicate<SaleRecord> filter = a ->{
			if(category == 1 && a.getCategory() == Category.ELECTRONICS) {
				return true;
			}else if(category == 2 && a.getCategory() == Category.FASHION) {
				return true;
			}else if(category == 3 && a.getCategory() == Category.GROCERY) {
				return true;
			}else if(category == 4 && a.getCategory() == Category.HOME_APPLIANCES) {
				return true;
			}else {
				return false;
			}
		};
		
		boolean found = false;
		
		for(SaleRecord s : arrRecords) {
			if(filter.test(s)) {
				System.out.println(s);
				found = true;
			}
		}
		
		if(!found) {
			System.out.println("No product of this category exists");
		}
		
	}
	
	public static void totalAvgSales(ArrayList<SaleRecord> arrRecords, String product) {
		
		double totalSales = arrRecords.stream()
							.filter(a -> a.getProductName().equals(product))
							.mapToDouble(SaleRecord::getAmount)
							.sum();
		
		long count = arrRecords.stream()
				.filter(a -> a.getProductName().equals(product))
				.count();
		
		System.out.println("Total Sales of " + product + " is " + totalSales);
		System.out.println("Average Sales of " + product + " is " + totalSales/count);
		
	}

}
