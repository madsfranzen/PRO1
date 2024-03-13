package OPG3b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Team> teams = new ArrayList<>();
        boolean running = true;
        while (running) {
            printMenu();
            int input = getUserInputInteger();
            switch (input) {
                case 1 -> teams.add(createTeam(teams));  // Create Team
                case 2 -> createStudent(teams);          // Create Student
                case 3 -> removeStudent(teams);          // Remove Student
                case 4 -> printStudentInfo(teams);       // Print Student
                case 5 -> printTeamInfo(teams);          // Print Team
                case 6 -> printAllTeamsInfo(teams);      // Print all Teams
                case 7 -> running = false;               // Exit
                default -> System.out.println("Please input a valid number.");
            }
        }
    }

    public static int getUserInputInteger() {
        int input = 0;
        Scanner scan = new Scanner(System.in);
        boolean isNumber = false;
        while (!isNumber) {
            try {
                input = scan.nextInt();
                isNumber = true;
            } catch (InputMismatchException e) {
                System.out.println("Please input a valid number.");
                scan.nextLine();
            }
        }
        return input;
    }

    public static void removeStudent(ArrayList<Team> teams) {
        if (teams.size() == 0) {
            System.out.println("No Teams created. Please create a team.");
        } else {
            printTeams(teams);
            System.out.println("Name of students team: ");
            Team team = findTeam(teams);
            printStudents(team);
            System.out.println("Name of Student:");
            Student student = findStudent(team);
            team.removeStudent(student.getName());
            System.out.println(student.getName() + " has been removed from " + team.getName());
        }
    }

    public static void printAllTeamsInfo(ArrayList<Team> teams) {
        if (teams.size() == 0) {
            System.out.println("No teams. Please create a team.");
        } else {
            for (Team team : teams) {
                team.printTeam();
            }
        }
    }

    public static void printStudentInfo(ArrayList<Team> teams) {
        if (teams.size() == 0) {
            System.out.println("No teams. Please create a team.");
        } else {
            printTeams(teams);
            System.out.println("Team's name: ");
            Team team = findTeam(teams);
            if (team.getStudents().size() == 0) {
                System.out.println("No students in Team.");
            }
            printStudents(team);
            System.out.println("Name of student: ");
            Student student = findStudent(team);
            System.out.println(student);
        }
    }

    public static void printStudents(Team team) {
        System.out.println("Students in " + team.getName() + ":");
        for (Student student : team.getStudents()) {
            System.out.print("| " + student.getName());
        }
        System.out.print(" |");
        System.out.println("");

    }

    public static void printTeams(ArrayList<Team> teams) {
        if (teams.size() == 0) {
            System.out.println("No teams. Please create a team.");
        } else {
            System.out.println("Available teams: ");
            for (Team team : teams) {
                System.out.print("| " + team.getName());
            }
            System.out.print(" |");
            System.out.println("");
        }
    }

    public static Student findStudent(Team teams) {
        Scanner scan = new Scanner(System.in);
        String studentName = null;
        Student student = null;
        boolean asking = true;
        while (asking) {
            studentName = scan.next();
            for (Student s : teams.getStudents()) {
                if (!s.getName().equalsIgnoreCase(studentName)) {
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
        boolean errorMessagePrinted = false;
        while (asking) {
            errorMessagePrinted = true;
            teamName = scan.nextLine();
            for (Team t : teams) {
                if (!t.getName().equalsIgnoreCase(teamName)) {
                    if (!errorMessagePrinted) {
                        System.out.println("Please input valid Team Name.");
                    }
                } else {
                    team = t;
                    asking = false;
                }
            }
        }
        return team;
    }

    public static void printTeamInfo(ArrayList<Team> teams) {
        if (teams.size() == 0) {
            System.out.println("No teams. Please create a team.");
        } else {
            printTeams(teams);
            System.out.println("Team's name: ");
            Team team = findTeam(teams);
            team.printTeam();
        }
    }

    public static void createStudent(ArrayList<Team> teams) {
        if (teams.size() == 0) {
            System.out.println("No Teams created. Please create a team.");
        } else {
            printTeams(teams);
            Scanner scan = new Scanner(System.in);
            System.out.println("Name of students team: ");
            Team team = findTeam(teams);
            System.out.println("Student's name and activity status: (true/false)");
            String studentName = scan.next();
            boolean isBoolean = false;
            boolean studentActivity = false;
            while (!isBoolean) {
                try {
                    studentActivity = scan.nextBoolean();
                    isBoolean = true;
                } catch (InputMismatchException e) {
                    System.out.println("Please input either 'true' or 'false' for student activity.");
                    scan.nextLine();
                }
            }
            System.out.println("Student's number of grades: ");
            int numOfGrades = getUserInputInteger();
            int[] grades = new int[numOfGrades];
            for (int i = 0; i < numOfGrades; i++) {
                System.out.println("Input students grade " + (i + 1) + ":");
                int grade = getUserInputInteger();
                grades[i] = grade;
            }
            Student student = new Student(studentName, studentActivity, grades);
            team.addStudent(student);
            System.out.println("--> Student " + studentName
                    + " with grades " + Arrays.toString(grades)
                    + " created in team " + team.getName());
        }
    }

    public static Team createTeam(ArrayList<Team> teams) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Team name and room:");
        String name = scan.next();
        String room = scan.next();
        if (teams.size() > 0) {
            boolean uniqueTeam = false;
            while (!uniqueTeam) {
                for (Team team : teams) {
                    if (team.getName().equalsIgnoreCase(name)) {
                        System.out.println("Team already exists. Please input valid Team Name.");
                        name = scan.next();
                    } else {
                        uniqueTeam = true;
                    }
                }
            }
        }
        Team team = new Team(name, room);
        System.out.println("--> Team created with name -> " + name + " and room -> " + room);
        return team;
    }

    public static void printMenu() {
        System.out.println("--------------------------------------");
        System.out.println("MENU");
        System.out.println("1: Create a team");
        System.out.println("2: Create a student");
        System.out.println("3: Remove a student");
        System.out.println("4: Show one student's info and results");
        System.out.println("5: Show one team's info and results");
        System.out.println("6: Show info and results for all teams");
        System.out.println("7: Exit program");
    }
}