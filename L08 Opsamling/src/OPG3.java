import java.util.Arrays;
import java.util.Scanner;

public class OPG3 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("How many values would you like to input?");

        int numberOfValues = scan.nextInt();

        int[] valuesArray = new int[numberOfValues];
        String[] namesArray = new String[numberOfValues];

        for (int i = 1; i <= numberOfValues; i++) {
            System.out.println("Input name for VAL" + i);
            namesArray[i - 1] = scan.next();
            System.out.println("Input value for VAL" + i);
            valuesArray[i - 1] = scan.nextInt();
        }

        int max = Arrays.stream(valuesArray).max().getAsInt();

        double denominator = 40.0 / max;

        for (int i = 0; i < valuesArray.length; i++) {

            int valueCounter = i + 1;
            System.out.println(namesArray[i] + ":");

            int starCount = (int) (valuesArray[i] * denominator);
            for (int x = 1; x <= starCount; x++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
