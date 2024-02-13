import java.util.Scanner;

public class OPG6 {
    public static void main(String[] args) {

        System.out.println("Input Age: ");
        Scanner scan = new Scanner(System.in);

        int age = scan.nextInt();

        String institution = institution(age);
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
}
