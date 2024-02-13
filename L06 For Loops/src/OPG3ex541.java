import java.util.Scanner;

public class OPG3ex541 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input Numbers:");

        int num = 1;
        int biggestNum = 0;
        int biggestNumCount = 0;
        do {
            num = scan.nextInt();
            if (num == biggestNum) {
                biggestNumCount++;
            } else if (num > biggestNum) {
                biggestNum = num;
                biggestNumCount = 1;
            }
        } while (num != 0);
        System.out.println("Biggest Number is: " + biggestNum);
        System.out.println("It occurs " + biggestNumCount + " times.");
    }
}
