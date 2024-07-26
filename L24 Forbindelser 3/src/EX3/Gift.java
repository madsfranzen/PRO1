package EX3;

public class Gift {
    private String description;
    private double price;
    private Person giver;

    public Gift(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Person getGiver() {
        return giver;
    }

    public void setGiver(Person giver) {
        this.giver = giver;
    }

    @Override
    public String toString() {
        return "Gift{" +
                "description='" + description + '\'' +
                ", price=" + price +
                ", giver=" + giver +
                '}';
    }
}
