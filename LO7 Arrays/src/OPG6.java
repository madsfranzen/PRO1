import java.util.Arrays;

public class OPG6 {
    public static void main(String[] args) {

        int[] testArray = {1, 2, 3, 4, 5};
        System.out.println("Has Dublets " + hasDublets(testArray));
    }

    // A method that switches the first and last element in the array.
    public static int[] switchFirstAndLast(int[] a) {
        int[] switchedArray = a;

        int first = switchedArray[0];
        int last = switchedArray[switchedArray.length - 1];
        switchedArray[0] = last;
        switchedArray[switchedArray.length - 1] = first;

        return switchedArray;
    }

    // A method that replaces all even numbers with 0 (zero).
    public static int[] replaceWithZero(int[] a) {
        int[] replacedArray = a;

        for (int i = 0; i < replacedArray.length; i++) {
            if (replacedArray[i] % 2 == 0) {
                replacedArray[i] = 0;
            }
        }
        return replacedArray;
    }

    // A method that returns the second highest element in the array.
    public static int secondHighest(int[] a) {
        int highest = 0;
        int secondHighest = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > highest) {
                secondHighest = highest;
                highest = a[i];
            }
        }
        return secondHighest;
    }

    //A method that returns true if the elements in the array are sorted ascending.

    public static boolean isAscending(int[] a) {
        boolean isAscending = false;

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] < a[i + 1]) {
                isAscending = true;
            } else isAscending = false;
        }
        return isAscending;
    }


    // A method that shifts all elements in the array to the right (to an index one higher).
    // The last element is shifted to the first index in the array.
    public static int[] shiftArray(int[] a) {
        int[] shiftedArray = a;

        int last = shiftedArray[shiftedArray.length - 1];

        for (int i = shiftedArray.length - 1; i > 0; i--) {
            shiftedArray[i] = shiftedArray[i - 1];
        }
        shiftedArray[0] = last;
        return shiftedArray;
    }

// A method that returns true if the array has doublets.
// Example: true is returned for {2, 5, 8, 5}, false is returned for {2, 5, 8, 6}.

    public static boolean hasDublets(int[] a) {
        boolean hasDublets = false;
        int[] checkArray = new int[a.length];
        int currentNumber = 0;

        for (int i = 0; i < checkArray.length; i++) {
            currentNumber = a[i] - 1;
            checkArray[currentNumber]++;
        }

        for (int i = 0; i < checkArray.length; i++) {
            if (checkArray[i] > 1) {
                hasDublets = true;
            }
        }
        return hasDublets;
    }
}
