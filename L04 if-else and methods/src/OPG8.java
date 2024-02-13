import java.util.Scanner;

public class OPG8 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter day number:");
        int day = scan.nextInt();
        System.out.println("Enter month number:");
        int month = scan.nextInt();

        String season = monthDay(month, day);
        System.out.println("Season is: " + season);
    }

    public static String monthDay(int month, int day) {

        String season;

        if (month == 12 || month == 1 || month == 2) season = "Winter";
        else if (month == 3 || month == 4 || month == 5) season = "Spring";
        else if (month == 6 || month == 7 || month == 8) season = "Summer";
        else season = "Fall";

        if ((month == 2 || month == 5 || month == 8 || month == 11) && day >= 21)
            if (season.equals("Winter")) season = "Spring";
            else if (season.equals("Spring")) season = "Summer";
            else if (season.equals("Summer")) season = "Fall";
            else season = "Winter";

        return season;
    }
}
