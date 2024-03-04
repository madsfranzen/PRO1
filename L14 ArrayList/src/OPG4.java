import java.util.ArrayList;

public class OPG4 {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(5);
        myList.add(4);
        myList.add(3);
        myList.add(9);
        System.out.println(myList);
        System.out.println(secondHighest(myList));
    }

    // A method that switches the first and last element in the ArrayList (assume size >= 1).
    public static ArrayList<Integer> switchFirstAndLast(ArrayList<Integer> list) {
        int temp1 = list.removeLast();
        list.addLast(list.removeFirst());
        list.addFirst(temp1);
        return list;
    }

    // A method that replaces all even numbers with 0 (zero).
    public static ArrayList<Integer> replaceWithZero(ArrayList<Integer> list) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.set(i, 0);
            }
        }
        return list;
    }

    // A method that returns the second highest element in the ArrayList (assume size >= 2).
    public static int secondHighest(ArrayList<Integer> list) {
        int highest = list.getFirst();
        int secondHighest = 0;
        for (int number : list) {
            if (number > highest) {
                secondHighest = highest;
                highest = number;
            } else if (number > secondHighest) {
                secondHighest = number;
            }
        }
        return secondHighest;
    }

    // A method that returns true if the elements in the ArrayList are sorted ascending.
    public static boolean isAscending(ArrayList<Integer> list) {
        int previousNumber = 0;
        boolean isAscending = true;
        for (int number : list) {
            if (number <= previousNumber) {
                isAscending = false;
            }
            previousNumber = number;
        }
        return isAscending;
    }

    // A method that shifts all elements in the array to the right (to an index one higher).
    // The last element is shifted to the first index in the ArrayList (assume size >= 1).
    // Example: {1, 4, 9, 16, 25} is changed to {25, 1, 4, 9, 16}
    public static ArrayList<Integer> shift(ArrayList<Integer> list) {
        int temp = list.removeLast();
        list.addFirst(temp);
        return list;
    }

    // A method that returns true if the ArrayList has doublets.
    // Example: true is returned for {2, 5, 8, 5}, false is returned for {2, 5, 8, 6}.
    public static boolean hasDuoblets(ArrayList<Integer> list) {
        boolean hasDoublets = false;
        for (int number : list) {
            if (list.indexOf(number) != list.lastIndexOf(number)) {
                hasDoublets = true;
            }
        }
        return hasDoublets;
    }
}
