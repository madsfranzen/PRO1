import java.util.Scanner;

public class OPG3 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Input 2 integers");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int num3 = scan.nextInt();

        if (num1 <= num2 && num2 <=num3) {
            System.out.println(num1);
            System.out.println(num2);
            System.out.println(num3);
        }

        if (num1 >= num2 && num1 <=num3) {
            System.out.println(num2);
            System.out.println(num1);
            System.out.println(num3);
        }
    }
}
