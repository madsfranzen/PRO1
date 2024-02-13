public class OPG4ex67 {
    public static void main(String[] args) {

        double investmentAmount = 1000;
        double annualInterestRate = 0.09;
        int years = 1;
        double monthlyInterestRate = annualInterestRate / 12;

        System.out.printf("The Amount Invested: %.2f \n", investmentAmount);
        System.out.println("Annual Interest Rate: " + annualInterestRate);
        System.out.println("Years     Future Value");

        int i = 1;
        while (i <= 30) {
            investmentAmount = futureInvestmentValue(investmentAmount, monthlyInterestRate, years);
            System.out.printf(years + "       %.2f \n", investmentAmount);
            i++;
        }
    }

    public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years) {
        return investmentAmount * Math.pow((1 + monthlyInterestRate), years * 12);
    }
}