public class OPG6 {

    public static void main(String[] args) {
        System.out.println(repeatedChars("vnhstxxxaby", 3));
        System.out.println(repeatedChars("vnhstxxxaby", 4));
    }

    /* Write a search method, named repeatedChars(), with two parameters: a string s, and a positive int k.
    The method must return a boolean indicating whether the same character is found in k adjacent positions in the string.
    This is an advanced searching.
        Examples:
    repeatedChars("vnhstxxxaby",3) returns true, because the character x is found in 3 adjacent places in the string.
    repeatedChars("vnhstxxxaby",4) returns false. */

    public static boolean repeatedChars(String s, int k) {
        Boolean isFound = false;
        int i = 0;
        int count = 1;
        while (!isFound && i < s.length() - 1) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
                if (count == k) {
                    isFound = true;
                }
            } else count = 1;
            i++;
        }
        return isFound;
    }
}
