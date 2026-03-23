import com.day2.*;

class GetDate {
	
	private int d;
	private int m;
	private int y;
	
	private int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	private int getD() {
		return d;
	}

	private void setD(int d) {
		this.d = d;
	}

	private int getM() {
		return m;
	}

	private void setM(int m) {
		this.m = m;
	}

	private int getY() {
		return y;
	}

	private void setY(int y) {
		this.y = y;
	}
	
	public void acceptDate() {
		int day, month, year;
	    while(true) {
	        System.out.println("Enter day: ");
	        day = GetInput.getInt();

	        System.out.println("Enter month: ");
	        month = GetInput.getInt();

	        System.out.println("Enter year: ");
	        year = GetInput.getInt();

	        if (validateDate(day, month, year)) {
	            setD(day);
	            setM(month);
	            setY(year);
	            break;
	        }else {
	            System.out.println("Invalid date, try again.\n");
	        }   
	    }
	}
	
	public void DisplayDate() {
		System.out.println("The date is: " + d + " / "+ m + " / " + y);
	}

	public boolean validateDate(int d, int m, int y) {

	    if (m < 1 || m > 12) {
	    	return false;
	    }
	    if (d <= 0) {
	    	return false;
	    }
	    if (y < 1900 || y > 3000) {
	    	return false;
	    }

	    if (validateLeapYear(y)) {
	        daysInMonth[1] = 29;
	    }

	    if (d > daysInMonth[m - 1]) {
	        return false;
	    }

	    return true;
	}
	
	public boolean validateLeapYear(int year) {
		if((this.y % 100 != 0 && this.y % 4 == 0) || 
				(this.y % 100 == 0 && this.y % 400 == 0)) {
			return true;
		}else {
			return false;
		}
	}
	
	public void addDays(int days) {
        this.d += days;
        while (true) {
            if (validateLeapYear(this.y)) {
                daysInMonth[1] = 29;
            } else {
                daysInMonth[1] = 28;
            }

            if (this.d <= daysInMonth[this.m - 1]) {
                break;
            }

            this.d -= daysInMonth[this.m - 1];
            this.m++;

            if (this.m > 12) {
                this.m = 1;
                this.y++;
            }
        }
    }

	public void addMonths(int months) {
	    int originalDay = this.d;
	    for (int i = 0; i < months; i++) {
	        if (validateLeapYear(this.y)) {
	            daysInMonth[1] = 29;
	        } else {
	            daysInMonth[1] = 28;
	        }

	        int currentMonthDays = daysInMonth[this.m - 1];

	        int remainingDays = currentMonthDays - this.d;
	        addDays(remainingDays);

	        addDays(1);

	        if (validateLeapYear(this.y)) {
	            daysInMonth[1] = 29;
	        } else {
	            daysInMonth[1] = 28;
	        }

	        int nextMonthDays = daysInMonth[this.m - 1];

	        if (originalDay > nextMonthDays) {
	            this.d = nextMonthDays;
	        } else {
	            this.d = originalDay;
	        }
	    }
	}
	
	public void addYears(int years) {
        this.y += years;

        if (this.m == 2 && this.d == 29 && !validateLeapYear(this.y)) {
            this.d = 28;
        }
    }
	
	public boolean isEqual(GetDate date2) {

	    if (this.d == date2.d &&
	        this.m == date2.m &&
	        this.y == date2.y) {
	        return true;
	    }

	    return false;
	}
}