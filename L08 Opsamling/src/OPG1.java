import java.util.Arrays;

public class OPG1 {
    public static void main(String[] args) {

        int[] tosses = new int[20];

        for (int i = 0; i < tosses.length; i++) {
            tosses[i] = throwDice();
        }


        boolean inRun = false;

        for (int i = 1; i < tosses.length - 1; i++) {

            if (inRun) {
                if (tosses[i] != tosses[i - 1]) {
                    System.out.print(") ");
                    inRun = false;
                }
            }
            if (!inRun) {
                if (tosses[i] != tosses[i - 1] && tosses[i] == tosses[i + 1]) {
                    System.out.print("( ");
                    inRun = true;
                }
            }
            System.out.print(tosses[i] + " ");
        }
        if (inRun) System.out.print(") ");
    }

    public static int throwDice() {
        int toss = (int) (6.0 * Math.random()) + 1;
        return toss;
    }
}
