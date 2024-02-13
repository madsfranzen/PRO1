import java.util.Scanner;

public class OPG1 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Input an Integer: ");
        int num = scan.nextInt();

        if (num < 0) {
            System.out.println("Negative number.");
        }
        if (num == 0) {
            System.out.println("Number is 0");
        }
        if (num > 0) {
            System.out.println("Positive number.");
        }
    }
}
