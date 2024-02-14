import java.util.Scanner;

public class OPG2d {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many numbers? (1-99)");
        int count = scan.nextInt();
        System.out.println("Input " + count + " numbers.");

        int previousNum = 0;
        int repeats = 0;
        for (int i = 0; i < count; i++) {
            System.out.println("Number " + (i + 1) + " of " + count + ":");
            int num = scan.nextInt();
            if (num == previousNum) {
                repeats += num;
                repeats *= 10;
            }
            previousNum = num;
        }

        // Clean up from multiplication in loop
        repeats /= 10;
        System.out.println(repeats);
    }
}
