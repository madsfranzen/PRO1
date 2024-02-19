public class OPG5 {
    public static void main(String[] args) {

        int[] array1 = {1, 4, 9, 16, 9, 7, 4, 9, 11};
        int[] array2 = {11, 11, 7, 9, 16, 4, 1};
        System.out.println(sameValues(array1, array2));
    }

    public static boolean equals(int[] a, int[] b) {
        boolean isEqual = true;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return isEqual;
    }

    public static boolean sameValues(int[] a, int[] b) {
        boolean sameValues = false;
        for (int i = 0; i < b.length; i++) {
            if (contains(a, b[i])) {
                sameValues = true;
            } else return false;
        }
        return sameValues;
    }

    public static boolean contains(int[] array, int value) {
        boolean contains = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) contains = true;
        }
        return contains;
    }
}
