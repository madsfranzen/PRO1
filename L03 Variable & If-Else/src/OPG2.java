import java.util.Scanner;

public class OPG2 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Input Loan Amount: ");
        double  loanAmount = scan.nextDouble();

        System.out.println("Input Annual Interest Rate: ");
        double  annualInterest = scan.nextDouble();


        System.out.println("Input Number of Years");
        int     numberOfYears = scan.nextInt();
        double  numberOfMonths = numberOfYears * 12.0;

        double monthlyInterest = annualInterest / 12.0 / 100;
        double denumerator = 1 - 1 / Math.pow(1 + monthlyInterest, numberOfMonths);
        double monthlyPayment = loanAmount * monthlyInterest / denumerator;


        System.out.printf("Monthly Payment: $ %.0f \n", monthlyPayment);
        System.out.println(denumerator);
        System.out.println(monthlyInterest);
    }
}
