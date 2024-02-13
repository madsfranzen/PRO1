public class OPG3ex539 {
    public static void main(String[] args) {

        double salesAmount = 0;
        double commission = 0.00;
        double commissionRate = 0.06;
        System.out.println("SALES AMOUNT    SALARY");

        do {
            if (salesAmount <= 5000) {
                commissionRate = 0.06;
                commission = salesAmount * commissionRate;
            } else if (salesAmount > 5000 && salesAmount < 10000) {
                commission = (salesAmount - 5000) * 0.08 + (5000 * 0.06);
            } else if (salesAmount > 10000) {
                commissionRate = 0.10;
                commission = (salesAmount - 10000) * 0.10 + (5000 * 0.08) + (5000 * 0.06);
            }
            System.out.println(salesAmount + "       " + commission);
            salesAmount += 1000;
        } while (commission <= 30000);
    }
}
