import java.util.Arrays;
import java.util.Scanner;

public class OPG5ex75 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Input 10 numbers.");

        int[] array = new int[10];

        for (int i = 0; i < 10; i++) {
            array[i] += scan.nextInt();
        }

        System.out.println(Arrays.toString(array));

    }
}
