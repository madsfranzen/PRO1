import java.io.StringReader;
import java.util.Scanner;

public class OPG3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input an Integer: ");
        int num = scan.nextInt();

        String numberSign = sign(num);

        System.out.println(numberSign);
    }

    public static String sign(int num) {

        if (num == 0) {
            return "Number is 0.";
        } else if (num < 0) {
            return "Number is Negative.";
        } else {
            return "Number is Positive.";
        }
    }
}
