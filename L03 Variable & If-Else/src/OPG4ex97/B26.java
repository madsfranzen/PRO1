package OPG4ex97;

import java.util.Scanner;

public class B26 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter an Integer between 0 and 1000");
        int integer = scan.nextInt();

        int sum = 0;

        while (integer > 0) {
            sum = sum + integer % 10;
            integer = integer / 10;
        }
        System.out.println(sum);
    }
}