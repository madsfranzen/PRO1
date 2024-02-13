import java.util.Scanner;

public class OPG1 {
    public static void main(String[] args) {
        // Input purchased amount
        System.out.print("Input orginal purchase amount: $");
        Scanner scan = new Scanner(System.in);
        double purchaseAmount = scan.nextDouble();

        // Calculate sales tax
        double salesTax = purchaseAmount * 1.06 - purchaseAmount;
        double total = purchaseAmount + salesTax;

        // Print sales tax
        System.out.println("Purchase Amount: $" + purchaseAmount);
        System.out.println("Purchase Including Tax: $" + total);
        System.out.println("Tax Amount: $" + salesTax);

    }
}
