package OPG4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class OPG4 {

    public static void main(String[] args) {

        Random r = new Random();
        int[] ints = r.ints(1000, 1, 10000).toArray();
        ArrayList<Integer> numbers1 = new ArrayList<>();
        ArrayList<Integer> numbers2 = new ArrayList<>();
        ArrayList<Integer> numbers3 = new ArrayList<>();
        ArrayList<Integer> numbers4 = new ArrayList<>();
        for (int e : ints) {
            numbers1.add(e);
            numbers2.add(e);
            numbers3.add(e);
            numbers4.add(e);
        }

        System.out.println("SORTING ALGORHITMS SPEED TEST:");
        bubbleSort(numbers1);
        selectionSort(numbers2);
        insertionSort(numbers3);
        long startTime = System.currentTimeMillis();
        Collections.sort(numbers4);
        System.out.println("JAVA SORT DONE: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    public static void bubbleSort(ArrayList<Integer> arr) {
        long startTime = System.currentTimeMillis();
        for (int i = arr.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
        System.out.println("BUBBLE DONE: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    public static void selectionSort(ArrayList<Integer> arr) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arr.size() - 1; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(j) < arr.get(indexOfMin)) {
                    indexOfMin = j;
                }
            }
            if (indexOfMin != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(indexOfMin));
                arr.set(indexOfMin, temp);
            }
        }
        System.out.println("SELECTION DONE: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    public static void insertionSort(ArrayList<Integer> arr) {
        long startTime = System.currentTimeMillis();

        for (int i = 1; i < arr.size(); i++) {
            int temp = arr.get(i);
            int j = i;
            while (j > 0 && temp < arr.get(j - 1)) {
                arr.set(j, arr.get(j - 1));
                j--;
            }
            arr.set(j, temp);
        }
        System.out.println("INSERTION DONE: " + (System.currentTimeMillis() - startTime) + "ms");
    }
}
