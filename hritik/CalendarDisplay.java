
import java.util.Scanner;

class CalendarDisplay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // for inputing month and year
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        // for displaying calendar
        displayCalendar(month, year);
    }

    // this is method for displaying calendar
    public static void displayCalendar(int month, int year) {
        
        String monthName = getMonthName(month);
        
        int daysInMonth = getDaysInMonth(month, year);
        
        int firstDay = getFirstDayOfMonth(month, year);

       
        System.out.println("\n" + monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

       
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    "); 
        }

       
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d ", day); 
            if ((day + firstDay) % 7 == 0) {
                System.out.println(); 
            }
        }
    }

    // this is method for getting month name
    public static String getMonthName(int month) {
        String[] monthNames = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        return monthNames[month - 1]; 
    }

    // this for getting days in month
    public static int getDaysInMonth(int month, int year) {
        if (month == 2) { // February
            return isLeapYear(year) ? 29 : 28; 
        }
       
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        return 31; // for remaining months
    }

    // this for leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // this for getting first day of month
    public static int getFirstDayOfMonth(int month, int year) {
        if (month < 3) {
            month += 12; 
            year--;
        } 
        // maths formula 
        int q = 1; 
        int m = month;
        int k = year % 100; 
        int j = year / 100; 

       
        int h = (q + (13 * (m + 1)) / 5 + k + (k / 4) + (j / 4) - (2 * j)) % 7;
        return (h + 6) % 7; 
    }
}