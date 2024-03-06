package OPG4ex107;

import java.util.Scanner;

public class AccountApp {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Account[] accounts = new Account[10];
        for (int i = 0; i < 10; i++) {
            accounts[i] = new Account(i, 2000);
        }

        while (true) {
            System.out.println("Enter Account ID: (enter)");
            int userInputID = scan.nextInt();
            if (userInputID > accounts.length) {
                System.out.println("Account not found.");
            } else {
                System.out.println("---- MAIN MENU ----");
                System.out.println("1.     View Balance");
                System.out.println("2.         Withdraw");
                System.out.println("3.          Deposit");
                System.out.println("4.     EXIT        ");
            }

            int userInputMenu = scan.nextInt();
            if (userInputMenu == 1) {
                System.out.println("Balance: " + accounts[userInputID].getBalance());
            } else if (userInputMenu == 2) {
                System.out.println("Current Balance: " + accounts[userInputID].getBalance());
                System.out.println("How much do you want to Withdraw?");
                double withdrawAmount = scan.nextDouble();
                accounts[userInputID].withdraw(withdrawAmount);
                System.out.println("New Balance: " + accounts[userInputID].getBalance());
            } else if (userInputMenu == 3) {
                System.out.println("Current Balance: " + accounts[userInputID].getBalance());
                System.out.println("How much do you want to Deposit?");
                double depositAmount = scan.nextDouble();
                accounts[userInputID].withdraw(depositAmount);
                System.out.println("New Balance: " + accounts[userInputID].getBalance());
            }
        }
    }
}
