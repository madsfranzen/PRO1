import java.util.Scanner;

public class OPG4 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Input 3 Numbers:");

        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int num3 = scan.nextInt();

        String numOrder = order(num1, num2, num3);
        System.out.println(numOrder);
    }

    public static String order(int num1, int num2, int num3) {
        if (num1 < num2 && num2 < num3) {
            return "Stigende.";
        } else if (num1 > num2 && num2 > num3) {
            return "Aftagende.";
        } else {
            return "Hverken-Eller.";
        }
    }
}
