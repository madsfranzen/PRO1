package opg1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class opg1 {
    public static void main(String[] args) {
        File file = new File("L33 Files and Exceptions/src/opg1/file.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                int doubleNum = scanner.nextInt() * 2;
                System.out.println(doubleNum);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
