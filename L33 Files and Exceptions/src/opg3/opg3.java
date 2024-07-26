package opg3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class opg3 {
    public static void main(String[] args) {
        File file = new File("L33 Files and Exceptions/src/opg3/file.txt");
        try (PrintWriter writer = new PrintWriter(file)) {
            for (int i = 1; i < 100; i += 2) {
                writer.println(i);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
