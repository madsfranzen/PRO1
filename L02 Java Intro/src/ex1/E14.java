package ex1;

public class E14 {
    public static void main(String[] args) {

        double factor = 1.05;

        System.out.println("Initial Balance = $1,000");
        System.out.println("Balance after 1 year = $" + 1000 * factor);
        System.out.println("              2 years = $" + 1000 * factor * factor);
        System.out.println("              3 years = $" + 1000 * factor * factor * factor);
        System.out.println("              4 years = $" + 1000 * factor * factor * factor * factor);
        System.out.println("              5 years = $" + 1000 * factor * factor * factor * factor * factor);
    }
}
