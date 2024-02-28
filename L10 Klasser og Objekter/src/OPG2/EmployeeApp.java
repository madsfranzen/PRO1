package OPG2;

public class EmployeeApp {

    public static void main(String[] args) {
        Employee e1 = new Employee("Hanne Sommer", 25, true);
        System.out.println("Test: " + e1);
        System.out.println();

        e1.Birthday();
        e1.printEmployee();
        System.out.println();
    }
}
