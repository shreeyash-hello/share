import com.day2.*;

class Date {

	public static void main(String[] args) {
		
		int choice;
		GetDate obj = new GetDate();
		GetDate obj1 = new GetDate();
		
		do {
			System.out.println("Choose among the following options "
					+ "\n1. Set date"
					+ "\n2. Add Days"
					+ "\n3. Add month"
					+ "\n4. Add years"
					+ "\n5. Compare date"
					+ "\n6. Exit");
			System.out.println("Enter your choice: ");
			choice = GetInput.getInt();
			
			switch(choice) {
				case 1:
				{
				    obj.acceptDate();
				    System.out.println("Date is:");
				    obj.DisplayDate();
				    break;
				}
				
				case 2:
				{
					System.out.println("Enter number of days to add: ");
			        int day = GetInput.getInt();
			        obj.addDays(day);
			        obj.DisplayDate();
			        break;
				}
				
				case 3:
				{
					System.out.println("Enter number of months to add: ");
					int month = GetInput.getInt();
					obj.addMonths(month);
					obj.DisplayDate();
					break;
				}
				
				case 4:
				{
					System.out.println("Enter number of years to add: ");
					int years = GetInput.getInt();
					obj.addYears(years);
					obj.DisplayDate();
					break;
				}
				
				case 5:
				{
					obj1.acceptDate();

					if (obj.isEqual(obj1)) {
					    System.out.println("Both the dates are same");
					    break;
					} else {
					    System.out.println("The dates are not same");
					    break;
					}
				}
				
				case 6:
				{
					System.out.println("Program exit!!");
					break;
				}
				
				default:
				{
					System.out.println("Invalid choice entered!!");
					break;
				}
				
			}
			
		}while(choice != 6);
	}
}