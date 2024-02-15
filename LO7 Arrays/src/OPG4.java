public class OPG4 {
    public static void main(String[] args) {
        int[] uneven = {4, 6, 7, 2, 3};
        int[] even = {4, 6, 2, 8, 10};
        System.out.println(hasUneven(even));
    }

    public static boolean hasUneven(int[] t) {
        int check = 0;
        for (int i = 0; i < t.length; i++) {
            if (t[i] % 2 == 1) {
                check++;
            }
        }
        if (check == 0) return false;
        else return true;
    }
}
