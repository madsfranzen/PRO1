public class OPG2c {
    public static void main(String[] args) {
        System.out.println(sumOddDigits(1234567));
    }

    public static int sumOddDigits(int number) {
        int sum = 0;
        while (number != 0) {
            int digit = number % 10;
            if (digit % 2 != 0) {
                sum = sum + digit;
            }
            number = number / 10;
        }
        return sum;
    }
}
