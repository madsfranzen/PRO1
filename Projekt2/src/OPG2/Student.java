package OPG2;

public class Student {

    private String name;
    private boolean active;
    private int[] grades;
    private char[] answers;

    public Student(String name, int[] grades) {
        this.name = name;
        active = true;
        this.grades = grades;
        answers = MultipleChoiceTest.answerTest();
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return String.format("Student (%s, Active: %b)", name, active);
    }

    public String getName() {
        return name;
    }

    public int getHighestGrade() {
        int max = 0;
        for (int i = 0; i < grades.length; i++) {
            max = Math.max(grades[i], max);
        }
        return max;
    }

    public double getAverageGrade() {
        double gradeSum = 0;
        for (int i = 0; i < grades.length; i++) {
            gradeSum += grades[i];
        }
        return gradeSum / grades.length;
    }

    public void answerTest() {
        answers = MultipleChoiceTest.answerTest();
    }

    public int getCorrectAnswerCount() {
        int correctAnswers = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == MultipleChoiceTest.correctAnswers[i]) {
                correctAnswers++;
            }
        }
        return correctAnswers;
    }

    public char[] getAnswers() {
        return answers;
    }

    public int[] getGrades() {
        return grades;
    }
}
