package OPG5;

import java.util.ArrayList;
import java.util.Collections;

public class OPG5 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        String str1 = "Jajaja";
        String str2 = "Hello World";
        String str3 = "Bob";
        list.add(str1);
        list.add(str2);
        list.add(str3);
        System.out.println(list); // print the list before sorting
        Collections.sort(list);
        System.out.println(list); // print the list after sorting
    }
}
