package OPG1;

public class Student {

    private String name;
    private boolean active;
    private int[] grades;

    public Student(String name, int[] grades) {
        this.name = name;
        active = true;
        this.grades = grades;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return String.format("OPG2.Student (%s, Active: %b)", name, active);
    }

    public String getName() {
        return name;
    }

}

