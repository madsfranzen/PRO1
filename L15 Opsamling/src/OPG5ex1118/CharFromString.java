package OPG5ex1118;

import java.util.ArrayList;
import java.util.Collections;

public class CharFromString {
    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println(str);
        System.out.println(toCharacter(str));
    }

    public static ArrayList<Character> toCharacter(String s) {
        ArrayList charArray = new ArrayList<>();
        for (int i = 0; i < s.length(); i++)
            charArray.add(s.charAt(i));
        return charArray;
    }
}
