import java.util.Scanner;

public class Scribble {
    public static void main(String[] args) {

        System.out.println("Write 3 integers:");

        Scanner scan = new Scanner(System.in);

        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int num3 = scan.nextInt();
        double average = (num1 + num2 + num3) / 3.0;
        System.out.println("average = " + average);
    }
}
