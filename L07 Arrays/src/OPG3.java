import java.util.Arrays;

public class OPG3 {
    public static void main(String[] args) {

        // Arrays Equal
        int[] array1 = {4, 6, 7, 2, 3};
        int[] array2 = {4, 6, 8, 2, 6};
        int[] sum = sumArrays(array1, array2);


        System.out.println(Arrays.toString(sum));

        // Arrays Not Equal
        int[] array3 = {4, 6, 7, 2, 3, 8};
        int[] array4 = {4, 6, 7, 2, 3, 10, 5};
        System.out.println(Arrays.toString(sumArraysNotEqual(array3, array4)));
    }

    public static int[] sumArrays(int[] a, int[] b) {
        int[] sum = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            sum[i] = a[i] + b[i];
        }
        return sum;
    }

    public static int[] sumArraysNotEqual(int[] a, int[] b) {

        // Create temporary Storage-Array and Find Length
        // Create Array for Storing Sum
        int[] newArrayLong = new int[findLength(a, b)];
        int[] sumArray = newArrayLong;

        // If Array A is the longest
        if (a.length == newArrayLong.length) {
            for (int i = 0; i < b.length; i++) {
                newArrayLong[i] += b[i];
            }
            for (int i = 0; i < sumArray.length; i++) {
                sumArray[i] = newArrayLong[i] + a[i];
            }
        } else {
            // if Array B is the longest
            for (int i = 0; i < a.length; i++) {
                newArrayLong[i] += a[i];
            }
            for (int i = 0; i < sumArray.length; i++) {
                sumArray[i] = newArrayLong[i] + b[i];
            }
        }
        return sumArray;
    }

    public static int findLength(int[] a, int[] b) {
        if (a.length > b.length) return a.length;
        else return b.length;
    }
}
