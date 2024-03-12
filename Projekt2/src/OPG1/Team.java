package OPG1;

import java.util.ArrayList;

public class Team {
    private String name;
    private String room;
    private ArrayList<Student> students;

    public Team(String name, String room) {
        students = new ArrayList<>();
        this.name = name;
        this.room = room;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(String name) {
        int i = 0;
        while (i < students.size()) {
            String sName = students.get(i).getName();
            if (sName.equals(name)) {
                students.remove(i);
            }
            i++;
        }
    }

    public ArrayList<Student> getActiveStudents() {
        ArrayList<Student> activeStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.isActive()) {
                activeStudents.add(student);
            }
        }
        return activeStudents;
    }


}
