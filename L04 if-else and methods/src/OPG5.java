import java.util.Scanner;

public class OPG5 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int lotteryNumber = (int) (Math.random() * 90) + 10;
        System.out.println("Lottery number is: " + lotteryNumber);
        System.out.println("Guess the number:");
        int guess = scan.nextInt();

        int lotteryDigit1 = lotteryNumber / 10;
        int lotteryDigit2 = lotteryNumber % 10;
        int guessDigit1 = guess / 10;
        int guessDigit2 = guess % 10;

        if (guess == lotteryNumber) {
            System.out.println("YOU WIN $10.000");
        } else if (guessDigit1 == lotteryDigit2 && guessDigit2 == lotteryDigit1) {
            System.out.println("YOU WIN $3.000");
        } else if (guessDigit1 == lotteryDigit1 ||
                guessDigit2 == lotteryDigit2 ||
                guessDigit1 == lotteryDigit2 ||
                guessDigit2 == lotteryDigit1) {
            System.out.println("YOU WIN $1000");
        } else {
            System.out.println("Sorry, you lose.");
        }
    }
}
