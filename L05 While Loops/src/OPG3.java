import java.util.Scanner;

public class OPG3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("INPUT A NUMBER TO CHECK IF PALINDROME: ");
        int userNum = scan.nextInt();
        System.out.println("Is Palindrome : " + isPalindrome(userNum));
    }

    public static int reverse(int number) {
        int reversedNumber = 0;
        while (number > 0) {
            reversedNumber += +number % 10;
            number /= 10;
            reversedNumber *= 10;
        }
        reversedNumber /= 10;
        return reversedNumber;
    }

    public static boolean isPalindrome(int userNum) {
        int reverseNum = reverse(userNum);
        if (userNum == reverseNum) return true;
        else return false;
    }
}
