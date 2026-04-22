import java.util.Scanner;

public class MenuMain {

	public static void main(String [] args) {
		
		try (Scanner scanner = new Scanner(System.in)) {

			LinkedList objList = new LinkedList();
			
			int choice = 0;
			
			do {
				System.out.println("1. Add menu item"
						+ "\n2. Delete menu item"
						+ "\n3. Display menu"
						+ "\n4. Modify menu"
						+ "\n5. Exit");
				
				System.out.println("Enter your choice");
				choice = scanner.nextInt();
				
				switch (choice) {
					case 1:
					{
						objList.addItem(scanner);
					}
					break;
					
					case 2:
					{
						objList.deleteItem(scanner);
					}
					break;
					
					case 3:
					{
						objList.display();
					}
					break;
					
					case 4:
					{
						objList.modifyItem(scanner);
					}
					break;
					
					case 5:
					{
						System.out.println("Program exit");
					}
					break;

				default:
				{
					System.out.println("Invalid input");
				}
					break;
				}
				
				
			} while (choice != 5);
		
		
		}
	}
	
}