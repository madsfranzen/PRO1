package OPG3;

import OPG2.Customer;

import java.util.ArrayList;
import java.util.Arrays;

public class OPG3 {
    public static void main(String[] args) {


        String[] strArr = new String[]{"B", "C", "A"};
        System.out.println(Arrays.toString(strArr));
        insertionSort1(strArr);
        System.out.println(Arrays.toString(strArr));

        OPG2.Customer customer1 = new OPG2.Customer(1000);
        OPG2.Customer customer2 = new OPG2.Customer(32000);
        OPG2.Customer customer3 = new OPG2.Customer(550);
        ArrayList<Customer> cstmArr = new ArrayList<>();
        cstmArr.add(customer1);
        cstmArr.add(customer2);
        cstmArr.add(customer3);
        System.out.println(cstmArr);
        insertionSort2(cstmArr);
        System.out.println(cstmArr);


    }

    public static void insertionSort1(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            String temp = arr[i];
            int j = i;
            while (j > 0 && temp.compareTo(arr[j - 1]) < 0) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static void insertionSort2(ArrayList<Customer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            Customer temp = arr.get(i);
            int j = i;
            while (j > 0 && temp.compareTo(arr.get(j - 1)) < 0) {
                arr.set(j, arr.get(j - 1));
                j--;
            }
            arr.set(j, temp);
        }
    }
}
