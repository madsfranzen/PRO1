package opg4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class opg4 {
    public static void main(String[] args) {
        File file = new File("L33 Files and Exceptions/src/opg4/file.txt");
        try (PrintWriter printWriter = new PrintWriter(file)) {
            Scanner scanner = new Scanner(System.in);
            int num;
            try {
                do {
                    num = Integer.parseInt(scanner.nextLine());
                    if (num > 0) {
                        printWriter.println(num);
                    } else {
                        System.out.println("Input must be larger than 0");
                    }
                } while (num != -1);
            } catch (NumberFormatException e) {
                System.out.println("Input is NOT a number!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
