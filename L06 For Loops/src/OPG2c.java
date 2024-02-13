import java.util.Scanner;

public class OPG2c {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("How many numbers? (1-99)");
        int count = scan.nextInt();
        System.out.println("Input " + count + " numbers.");

        int biggestNum = 0;
        int biggestNumCount = 0;
        for (int i = 0; i < count; i++) {
            
            System.out.println("Number " + (i + 1) + ":");
            int num = scan.nextInt();

            if (num > biggestNum) {
                biggestNum = num;
                biggestNumCount = 0;
            }
            if (num == biggestNum) biggestNumCount++;
        }
        System.out.println("Biggest Number Is: " + biggestNum);
        System.out.println("It occurs " + biggestNumCount + " times.");
    }
}
