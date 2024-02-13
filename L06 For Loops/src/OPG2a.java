import java.util.Scanner;

public class OPG2a {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("How many numbers? (1-99)");
        int count = scan.nextInt();
        System.out.println("Input " + count + " numbers.");

        int biggestNum = 0;
        int smallestNum = 100;
        int evenNums = 0;
        for (int i = 0; i < count; i++) {
            // input numbers in loop
            System.out.println("Number " + (i + 1) + ":");
            int num = scan.nextInt();
            // scan for biggest number
            if (num > biggestNum) {
                biggestNum = num;
            }
            // scan for smallest number
            if (num < smallestNum) {
                smallestNum = num;
            }
            // scan for even numbers
            if (num % 2 == 0) {
                evenNums++;
            }
        }

        // calculate odd numbers
        int oddNums = count - evenNums;

        System.out.println("Biggest Number: " + biggestNum);
        System.out.println("Smallest Number: " + smallestNum);
        System.out.println("Even Numbers: " + evenNums);
        System.out.println("Odd Numbbers: " + oddNums);
    }
}
