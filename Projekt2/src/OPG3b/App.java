package OPG3b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        ArrayList<Team> teams = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        boolean running = true;
        while (running) {
            printMenu();
            int input = scan.nextInt();
            switch (input) {
                case 1 -> teams.add(createTeam()); // Create Team
                case 2 -> createStudent(teams);    // Create Student
                case 3 -> printStudentInfo(teams); // Print Student
                case 4 -> printTeamInfo(teams);    // Print Team
                case 5 -> printAllTeamsInfo(teams);    // Print all Teams
                case 6 -> running = false;         // Exit
                default -> System.out.println("Please input a valid number.");
            }
        }
    }

    public static void printAllTeamsInfo(ArrayList<Team> teams) {
        for (Team t : teams) {
            t.printTeam();
        }
    }

    public static void printStudentInfo(ArrayList<Team> teams) {
        System.out.println("Team's name: ");
        Team team = findTeam(teams);
        // Print liste over alle navne
        System.out.println("Name of student: ");
        Student student = findStudent(team);
        System.out.println(student);
    }

    public static Student findStudent(Team teams) {
        Scanner scan = new Scanner(System.in);
        String studentName = null;
        Student student = null;
        boolean asking = true;
        while (asking) {
            studentName = scan.next();
            for (Student s : teams.getStudents()) {
                if (!s.getName().equals(studentName)) {
                    System.out.println("Please input valid Student Name.");
                } else {
                    student = s;
                    asking = false;
                }
            }
        }
        return student;
    }

    public static Team findTeam(ArrayList<Team> teams) {
        Scanner scan = new Scanner(System.in);
        String teamName = null;
        Team team = null;
        boolean asking = true;
        while (asking) {
            teamName = scan.next();
            for (Team t : teams) {
                if (!t.getName().equals(teamName)) {
                    System.out.println("Please input valid Team Name.");
                } else {
                    team = t;
                    asking = false;
                }
            }
        }
        return team;
    }

    public static void printTeamInfo(ArrayList<Team> teams) {
        System.out.println("Team's name: ");
        Team team = findTeam(teams);
        team.printTeam();
    }

    public static void createStudent(ArrayList<Team> teams) {
        System.out.println("Name of students team: ");
        Team team = findTeam(teams);
        System.out.println("Student's name and activity status: (true/false)");
        Scanner scan = new Scanner(System.in);
        String studentName = scan.next();
        boolean studentActivity = scan.nextBoolean();
        System.out.println("Student's number of grades: ");
        int numOfGrades = scan.nextInt();
        int[] grades = new int[numOfGrades];
        System.out.println("Students " + numOfGrades + " grades: ");
        for (int i = 0; i < numOfGrades; i++) {
            int grade = scan.nextInt();
            grades[i] = grade;
        }
        Student student = new Student(studentName, studentActivity, grades);
        team.addStudent(student);
        System.out.println("--> Student " + studentName
                + " with grades " + Arrays.toString(grades)
                + " created in team " + team.getName());
    }

    public static Team createTeam() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Team name and room:");
        String name = scan.next();
        String room = scan.next();
        Team team = new Team(name, room);
        System.out.println("--> Team created with name -> " + name + " and room -> " + room);
        return team;
    }

    public static void printMenu() {
        System.out.println("--------------------------------------");
        System.out.println("MENU");
        System.out.println("1: Create a team");
        System.out.println("2: Create a student");
        System.out.println("3: Show one student's info and results");
        System.out.println("4: Show one team's info and results");
        System.out.println("5: Show info and results for all teams");
        System.out.println("6: Exit program");
    }

}
