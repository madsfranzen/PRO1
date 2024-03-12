package OPG3b;

import java.util.Random;

public class MultipleChoiceTest {

    static char[] correctAnswers = new char[]{'A', 'C', 'A', 'B', 'D', 'A', 'D', 'B', 'A', 'D'};

    public static char[] answerTest() {
        Random random = new Random();
        char randomChar = '#';
        char[] answers = new char[10];
        for (int i = 0; i < 10; i++) {
            int randomInt = random.nextInt(4);
            switch (randomInt) {
                case 0 -> randomChar = 'A';
                case 1 -> randomChar = 'B';
                case 2 -> randomChar = 'C';
                case 3 -> randomChar = 'D';
                default -> System.out.println("Wrong number generated.");
            }
            answers[i] = randomChar;
        }
        return answers;
    }
}
