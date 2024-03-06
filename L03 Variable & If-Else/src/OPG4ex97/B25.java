package OPG4ex97;

import java.util.Scanner;

public class B25 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Subtotal: $");
        double subtotal = scan.nextDouble();
        System.out.print("Enter Gratuity Rate: ");
        double gratuityRate = scan.nextDouble();

        double gratuity = subtotal * gratuityRate / 100;
        double total = subtotal + gratuity;

        System.out.println("Gratuity is: $" + gratuity);
        System.out.println("Total is: $" + total);


    }
}
