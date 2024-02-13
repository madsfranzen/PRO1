import java.util.Scanner;

public class OPG7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Is it a boy?");
        boolean isBoy = scan.nextBoolean();

        System.out.println("Input Age: ");
        int age = scan.nextInt();

        String institution = institution(age);
        String team = team(isBoy, age);
        System.out.println(team);
        System.out.println(institution);
    }

    public static String institution(int age) {

        if (age == 0) {
            return "Home";
        } else if (age >= 1 && age <= 2) {
            return "Nursery";
        } else if (age >= 3 && age <= 5) {
            return "Kindergarten";
        } else if (age >= 6 && age <= 16) {
            return "School";
        } else return "Out of school";
    }

    public static String team(boolean isBoy, int age) {
        if (!isBoy) {
            if (age < 8) {
                return "Tumbling Girls";
            } else return "Springy Girls";
        } else {
            if (age < 8) {
                return "Young Cubs";
            } else return "Cool Boys";
        }
    }
}
