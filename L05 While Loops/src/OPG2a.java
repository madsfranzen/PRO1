public class OPG2a {

    public static void main(String[] args) {
        printPowersOfTwo();
    }

    public static void printPowersOfTwo() {
        int power = 0;
        int i = 0;
        while (i <= 20) {
            power = 2 * i;
            System.out.println(power);
            i++;
        }
    }
}