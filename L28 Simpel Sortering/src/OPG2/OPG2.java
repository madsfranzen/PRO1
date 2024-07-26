package OPG2;

import java.util.ArrayList;
import java.util.Arrays;

public class OPG2 {
    public static void main(String[] args) {

        String[] strArr = new String[]{"B", "C", "A"};
        System.out.println(Arrays.toString(strArr));
        selectionSort1(strArr);
        System.out.println(Arrays.toString(strArr));

        Customer customer1 = new Customer(1000);
        Customer customer2 = new Customer(32000);
        Customer customer3 = new Customer(550);
        ArrayList<Customer> cstmArr = new ArrayList<>();
        cstmArr.add(customer1);
        cstmArr.add(customer2);
        cstmArr.add(customer3);
        System.out.println(cstmArr);
        selectionSort2(cstmArr);
        System.out.println(cstmArr);


    }


    public static void selectionSort1(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[indexOfMin]) < 0) {
                    indexOfMin = j;
                }
            }
            if (indexOfMin != i) {
                String temp = arr[i];
                arr[i] = arr[indexOfMin];
                arr[indexOfMin] = temp;
            }
        }
    }

    public static void selectionSort2(ArrayList<Customer> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(j).compareTo(arr.get(indexOfMin)) < 0) {
                    indexOfMin = j;
                }
            }
            if (indexOfMin != i) {
                Customer temp = arr.get(i);
                arr.set(i, arr.get(indexOfMin));
                arr.set(indexOfMin, temp);
            }
        }
    }
}
