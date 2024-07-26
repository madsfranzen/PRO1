package EX1;

public class Customer implements Comparable<Customer> {

    private String firstName;
    private String lastName;


    public int compareTo(Customer other) {
        if (this.lastName.equals(other.getLastName())) {
            return this.firstName.compareTo(other.getFirstName());
        } else return this.lastName.compareTo(other.getLastName());
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
