package OPG3;

import javax.naming.Name;

public class Person {
    private String name;
    private String address;
    private int monthlySalary;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public double calculateYearlySalary(int monthlySalary) {
        double bonus = 1.025;
        double yearlySalary = (monthlySalary * 12.0) * bonus;
        return yearlySalary;
    }

    public void printPerson() {
        System.out.println("*****************************");
        System.out.println("Name:           " + name);
        System.out.println("Address:        " + address);
        System.out.println("Monthly Salary: " + monthlySalary);
        System.out.println("Yearly Salary:  " + calculateYearlySalary(monthlySalary));
        System.out.println("*****************************");
    }

    public String toString() {
        return String.format("Person Test (%s, %s, %s)", name, address, monthlySalary);
    }
}
