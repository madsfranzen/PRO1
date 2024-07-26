package OPG2;

public class Customer implements Comparable<Customer> {

    private int salesAmount;
    private String name;

    public Customer(int salesAmount) {
        this.salesAmount = salesAmount;
    }

    @Override
    public int compareTo(Customer other) {
        return Integer.compare(this.salesAmount, other.salesAmount);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "salesAmount=" + salesAmount +
                '}';
    }
}
