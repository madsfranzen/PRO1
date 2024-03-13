package OPG2;

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

    public double getAverageGrade() {
        int gradeSum = 0;
        int gradeCount = 0;
        for (Student student : students) {
            for (int i = 0; i < student.getGrades().length; i++) {
                gradeSum += student.getGrades()[i];
                gradeCount++;
            }
        }
        return gradeSum / gradeCount;
    }

    public Student[] getHighScoreStudents(double minAverage) {
        int studentCount = 0;
        for (Student student : students) {
            if (student.getAverageGrade() >= minAverage) {
                studentCount++;
            }
        }
        Student[] getHighScoreStudents = new Student[studentCount];
        int j = 0;
        for (int i = 0; i < students.size(); i++)
            if (students.get(i).getAverageGrade() >= minAverage) {
                getHighScoreStudents[j] = students.get(i);
                j++;
            }
        return getHighScoreStudents;
    }


    public int[] getTotalCorrectAnswerCount() {
        int[] correctAnswers = new int[students.size()];

        for (int i = 0; i < correctAnswers.length; i++) {
            correctAnswers[i] = students.get(i).getCorrectAnswerCount();
        }
        return correctAnswers;
    }

    public int getCorrectAnswerCount(int question) {
        int correctAnswersCount = 0;
        char correctAnswer = MultipleChoiceTest.correctAnswers[question];
        for (Student student : students) {
            if (student.getAnswers()[question] == correctAnswer) {
                correctAnswersCount++;
            }
        }
        return correctAnswersCount;
    }

    public void printTeam() {
        System.out.println("*********** " + name + " ***********");
        System.out.println("*      Name |    GA |  CA  *");
        System.out.println("* ------------------------ *");
        for (Student student : students) {
            System.out.printf("* %9s | %5.2f | %2d   *\n",
                    student.getName(),
                    student.getAverageGrade(),
                    student.getCorrectAnswerCount());
        }
        System.out.println("****************************\n");
    }
}
