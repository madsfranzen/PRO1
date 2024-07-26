package opg2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class opg2 {
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();

        File file = new File("L33 Files and Exceptions/src/opg1/file.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                arr.add(scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        System.out.println(arr.reversed().toString());
    }
}
