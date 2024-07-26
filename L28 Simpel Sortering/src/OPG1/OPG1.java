package OPG1;

import java.util.ArrayList;
import java.util.Arrays;

public class OPG1 {
    public static void main(String[] args) {

        ArrayList<String> strArr = new ArrayList<>();

        String str1 = "B";
        String str2 = "C";
        String str3 = "A";
        strArr.add(str1);
        strArr.add(str2);
        strArr.add(str3);

        System.out.println("Unsorted: " + strArr);
        bubbleSort(strArr);
        System.out.println("Sorted: " + strArr);
    }

    public static void bubbleSort(ArrayList<String> arr) {
        for (int i = arr.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr.get(j).compareTo(arr.get(j + 1)) > 0) {
                    String temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
    }
}
