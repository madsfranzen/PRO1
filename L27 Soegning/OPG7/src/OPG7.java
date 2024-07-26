public class OPG7 {
    public static void main(String[] args) {
        int[] t1 = new int[]{4, 3, 12, 5, 7, -4, 1, 8, 12};
        System.out.println(searchSum(t1, 9));
    }

    /* Write a linear search method, named searchSum(),with two parameters: an int array,
    and a positive integer representing a total. The method must find a number of adjacent integers,
    whose sum is equal to the total parameter, and return the index of the first of these integers.
    If t1=[4, 3, 12, 5, 7, -4, 1, 8, 12], then searchSum(t1,9) should return 3,
    because t1[3]+ t1[4]+ t1[5]+ t1[6] = 5 + 7 + (-4) + 1 = 9. */

    public static int searchSum(int[] arr, int total) {
        Boolean isFound = false;
        int i = 0;
        while (!isFound && i < arr.length) {
            int sum = 0;
            for (int y = i; y < arr.length; y++) {
                sum += arr[y];
                if (sum == total) isFound = true;
            }
            if (!isFound) i++;
        }
        return i;
    }
}
