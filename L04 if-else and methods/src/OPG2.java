import java.util.Scanner;

public class OPG2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input 3 Numbers:");

        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int num3 = scan.nextInt();

        if (num1 < num2 && num2 < num3) {
            System.out.println("Stigende.");
        } else if (num1 > num2 && num2 > num3) {
            System.out.println("Aftagende.");
        } else {
            System.out.println("Hverken-Eller.");
        }
    }
}
