public class OPG4ex611 {
    public static void main(String[] args) {

        System.out.println("Sales Amount     Commission");

        double salesAmount = 1000;

        while (salesAmount <= 20000) {
            double commission = computeCommisiom(salesAmount) - salesAmount;
            System.out.println(salesAmount + "           " + commission);
            salesAmount += 1000;
        }
    }

    public static double computeCommisiom(double salesAmount) {
        return salesAmount * 1.09;
    }
}
