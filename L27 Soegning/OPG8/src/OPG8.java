public class OPG8 {
    public static void main(String[] args) {

        int[] array = new int[]{6, 4, 8, 13, 7};

        System.out.println(findNumber(array, 13));

    }

    /* Write a linear search method that finds a number in an array. If the number does not exists the method returns -1.
    If the number is found, it should swap place with the number before, and return the new index of the number.
    In case the number is found on index 0, it should not swap place, but just return 0.
        Example:
        Array before searching for 13: {6, 4, 8, 13, 7}
        Array after searching 13:      {6, 4, 13, 8, 7}
        In this case the method returns 2.
    Repeat the exercise with an ArrayList instead of an array. */

    public static int findNumber(int[] arr, int num) {
        int index = 0;
        Boolean isFound = false;
        while (!isFound && index < arr.length) {
            if (arr[0] == num) {            // In case the number is found on index 0 -> just return 0.
                isFound = true;
            } else if (arr[index] == num) { //  If the number is found -> swap place with the number before
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                isFound = true;
                index--;                    //  + return the new index of the number.
            }
            if (!isFound) index++;
        }
        return index;
    }
}
