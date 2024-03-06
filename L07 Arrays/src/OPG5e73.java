import java.util.Arrays;
import java.util.Scanner;

public class OPG5e73 {
    public static void main(String[] args) {

        int[] array = new int[50];
        Scanner scan = new Scanner(System.in);
        int currentnumber = 0;

        do {
            currentnumber = scan.nextInt();
            if (currentnumber > 49) {
                System.out.println("Number must be between 0 - 49");
            } else array[currentnumber]++;
        } while (currentnumber != 0);

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                System.out.println("Number " + i + " occured " + array[i] + " times");
            }
        }
    }
}
