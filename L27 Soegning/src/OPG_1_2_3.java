import java.util.List;

public class OPG_1_2_3 {
    public static void main(String[] args) {


    }


    /* Write a linear search method that returns, whether an uneven number exists in an array.
    The method must return true or false, and take an array of integer numbers as parameter. */
    private boolean hasUneven(int[] arr) {
        boolean found = false;
        int i = 0;
        while (!found && i < arr.length) {
            if (arr[i] % 2 != 0) {
                found = true;
            } else i++;
        }
        return found;
    }

    /* Exercise 2
    Write a linear search method that finds the first number belonging to the interval [10;15].
    The method must return the number found in the interval, and take an array of integer numbers as parameter.
    If a number in the interval is not found, the method must return -1.
    If the array is [7, 56, 34, 3, 7, 14, 13, 4], the method should return 14.
 */
    int[] interval = new int[]{10, 11, 12, 13, 14, 15};
    int[] arrayToSearch = new int[]{7, 56, 34, 3, 7, 14, 13, 4};

    private int intervalBelonging(int[] arrToSearch, int[] targetArr) {
        int num = -1;
        int i = 0;
        while (num == -1 && i < arrToSearch.length) {
            if (List.of(targetArr).contains(arrToSearch[i])) {
                num = arrToSearch[i];
            } else i++;
        }
        return num;
    }

    /* Exercise 3
    Write a linear search method that returns true, if two adjacent numbers are the same.
    The method must take an array of integer numbers as parameter.
    If the array is [7, 9, 13, 7, 9, 13], the method must return false.
    If the array is [7, 9, 13, 13, 9, 7], the method must returns true.
    Write another method that returns true, if the same number exists in n adjacent places.
    The method must take an array of integer numbers and the number n as parameters. */

    private boolean adjacentNumbers(int[] arrToSearch) {
        boolean found = false;
        int i = 1;
        while (!found && i < arrToSearch.length) {
            if (arrToSearch[i] == arrToSearch[i - 1]) {
                found = true;
            } else i++;
        }
        return found;
    }

    private boolean adjacentNumbersMAXX(int[] arrToSearch, int n) {
        boolean nFound = false;
        int nCount = 1;
        int i = 1;
        while (!nFound && i < arrToSearch.length) {
            if (arrToSearch[i] == arrToSearch[i - 1]) {
                nCount++;
            } else nCount = 1;

            if (nCount == n) {
                nFound = true;
            } else i++;
        }
        return nFound;
    }
}