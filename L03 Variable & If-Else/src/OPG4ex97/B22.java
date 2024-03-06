package OPG4ex97;

import java.util.Scanner;

public class B22 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Enter Balance and Annual Interest Rate
        System.out.println("Enter current Balance: $");
        double balance = scan.nextDouble();
        System.out.println("Enter Annual Interest Rate: ");
        double annualInterestRate = scan.nextDouble();

        double interest = balance * (annualInterestRate / 1200);

        System.out.println("Interest for next month is: $" + interest);


    }
}
