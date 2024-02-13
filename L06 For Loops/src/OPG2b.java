import java.util.Scanner;

public class OPG2b {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("How many numbers? (1-99)");
        int count = scan.nextInt();
        System.out.println("Input " + count + " numbers.");

        int sum = 0;
        for (int i = 0; i < count; i++) {
            // input numbers in loop
            System.out.println("Number " + (i + 1) + ":");
            int num = scan.nextInt();
            // sum numbers in loop
            sum += num;
            System.out.println("SUM: " + sum);

        }
    }
}
