public class OPG2b {
    public static void main(String[] args) {
        int lower = 7;
        int upper = 25;
        System.out.println(sumEventInts(lower, upper));
    }

    public static int sumEventInts(int lower, int upper) {
        int i = lower;
        int sum = 0;
        while (i < upper) {
            if (i % 2 == 0) {
                sum += i;
            }
            i++;
        }
        return sum;
    }
}
