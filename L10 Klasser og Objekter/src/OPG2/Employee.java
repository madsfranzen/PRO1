package OPG2;

public class Employee {
    String name;
    boolean trainee;
    int age;


    public Employee(String name, int age, boolean trainee) {
        this.name = name;
        this.age = age;
        this.trainee = true;
    }

    public void Birthday() {
        age++;
    }

    @Override
    public String toString() {
        return String.format("Employee(%s, %s, %s)", name, age, trainee);
    }


    public void printEmployee() {
        int lastNameIndex = name.lastIndexOf(" ");

        System.out.println("*******************");
        System.out.println("First Name: " + name.substring(0, lastNameIndex));
        System.out.println("Last Name: " + name.substring(lastNameIndex + 1));
        System.out.println("Trainee: " + trainee);
        System.out.println("Age: " + age);
        System.out.println("*******************");
    }
}
