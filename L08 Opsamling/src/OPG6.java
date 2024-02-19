import java.util.Arrays;

public class OPG6 {
    public static void main(String[] args) {
        boolean[] lockers = new boolean[100];

        S1(lockers);
        S2(lockers);
        studentChange(lockers);

        for (int i = 0; i < lockers.length; i++) {
            int lockernumber = i + 1;
            if (lockers[i] == true) {
                System.out.println("Locker " + lockernumber + " is open");
            }
        }
    }

    public static void studentChange(boolean[] lockers) {
        int studentnumber = 3;
        for (int i = 0; i <= 100; i++) {
            for (int y = studentnumber - 1; y < lockers.length; y += studentnumber) {
                if (lockers[y] == true) lockers[y] = false;
                else lockers[y] = true;
            }
        }
    }

    public static void S2(boolean[] lockers) {
        for (int i = 1; i < lockers.length; i += 2) {
            lockers[i] = false;
        }
    }

    public static void S1(boolean[] lockers) {
        for (int i = 0; i < lockers.length; i++) {
            lockers[i] = true;
        }
    }
}
