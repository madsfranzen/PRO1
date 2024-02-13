public class OPG1a {
    public static void main(String[] args) {


        // 1a
        int sum = 0;
        for (int i = 2; i <= 100; i += 2) {
            sum = sum + i;
        }
        System.out.println(sum);


        // 2a
        printPowersOfTwo();

        // 2b
        int lower = 7;
        int upper = 25;
        System.out.println(sumEventInts(lower, upper));
    }

    // 2a
    public static void printPowersOfTwo() {
        int power = 0;
        for (int i = 0; i <= 20; i++) {
            power = 2 * i;
            System.out.println(power);
            i++;
        }
    }

    // 2b
    public static int sumEventInts(int lower, int upper) {
        int sum = 0;
        for (int i = lower; i < upper; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
