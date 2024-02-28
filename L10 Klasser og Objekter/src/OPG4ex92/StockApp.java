package OPG4ex92;

public class StockApp {
    public static void main(String[] args) {
        Stock oracle = new Stock("ORCL",
                "Oracle Corporation",
                34.5);

        oracle.setCurrentPrice(34.35);

        System.out.println("Percent change for ORCL: " + oracle.getPercentChange() + "%");
    }
}
