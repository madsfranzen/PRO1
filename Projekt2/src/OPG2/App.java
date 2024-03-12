package OPG2;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Team team1 = new Team("PRO1", "A1.32");
        Student student1 = new Student("Mads", new int[]{7, 4, 02, 12});
        Student student2 = new Student("Rasmus", new int[]{7, 7, 12});
        Student student3 = new Student("Philip", new int[]{10, 10, 10, 10, 10});
        team1.addStudent(student1);
        team1.addStudent(student2);
        team1.addStudent(student3);

        Team team2 = new Team("FIT1", "A1.28");
        Student student4 = new Student("Jens", new int[]{12, 12, 12, 12,});
        Student student5 = new Student("Mark", new int[]{02, 02});
        Student student6 = new Student("Mikkel", new int[]{7, 7});
        team2.addStudent(student4);
        team2.addStudent(student5);
        team2.addStudent(student6);

        System.out.println(team1.getActiveStudents());
        team1.removeStudent("Mads");
        System.out.println(team1.getActiveStudents());

        System.out.println(team2.getActiveStudents());
        team2.removeStudent("Mark");
        System.out.println(team2.getActiveStudents());

        System.out.println(student1.getHighestGrade());

        System.out.println(student1.getAverageGrade());
        System.out.println(team1.getAverageGrade());

        System.out.println(Arrays.toString(team1.getHighScoreStudents(7)));

        student1.answerTest();
        System.out.println(student1.getAnswers());
        System.out.println(student1.getCorrectAnswerCount());

        System.out.println(Arrays.toString(team1.getTotalCorrectAnswerCount()));

        team1.printTeam();
        team2.printTeam();

        System.out.println(team1.getCorrectAnswerCount(2));
    }
}
