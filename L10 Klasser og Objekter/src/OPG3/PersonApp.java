package OPG3;

public class PersonApp {

    public static void main(String[] args) {

        Person hanneSommer = new Person("Hanne Sommer", "EAAA");
        System.out.println(hanneSommer.toString());

        hanneSommer.setMonthlySalary(20000);

        hanneSommer.printPerson();
    }
}
