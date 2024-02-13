import java.util.Scanner;

public class EX35 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter todays date: (1-7)");
        int today = scan.nextInt();
        System.out.println("How many days ahead? ");
        int elapsedDays = scan.nextInt();

        String todayWeekday = getWeekDay(today);
        String elapsedWeekday = getElapsedWeekday(elapsedDays);

        System.out.println("Today is: " + todayWeekday);
        System.out.println("In " + elapsedDays + " days it will be " + elapsedWeekday);
    }

    public static String getWeekDay(int dayNumber) {
        if (dayNumber == 1) return "Monday";
        else if (dayNumber == 2) return "Tuesday";
        else if (dayNumber == 3) return "Wednesday";
        else if (dayNumber == 4) return "Thursday";
        else if (dayNumber == 5) return "Friday";
        else if (dayNumber == 6) return "Saturday";
        else if (dayNumber == 7) return "Sunday";
        else return "Invalid";
    }

    public static String getElapsedWeekday(int numberOfDays) {
        int weekdayNumber = numberOfDays % 7 + 1;
        String weekdayString = getWeekDay(weekdayNumber);
        return weekdayString;
    }
}

