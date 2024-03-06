package OPG5ex1113;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveDuplicate {
    public static void main(String[] args) {
        
        ArrayList<Integer> intArray = new ArrayList<>();
        intArray.addAll(List.of(1, 2, 3, 3, 4, 5, 6, 6, 7, 8, 6, 8, 8, 9));

        System.out.println(intArray);

        removeDuplicate(intArray);
        System.out.println(intArray);
    }

    public static void removeDuplicate(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            int number = list.remove(i);
            if (!list.contains(number)) {
                list.add(i, number);
            }
        }
    }
}
