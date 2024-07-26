public class OPG9 {
    public static void main(String[] args) {
        System.out.println(findWholeNumberRootBinary(111));
    }

    /* Skriv en metode, der (uden brug af operationen for kvadratrod: Math.sqrt) kan beregne heltalskvadratroden af et heltal n >= 0.
       Metoden skal altså returnere det største heltal r, der opfylder: r2 <= n < (r+1)2.
            Her er nogle eksempler:
                    n   0   2   3   4   7   8   9   10  111
                    r   0   1   1   2   2   2   3   3   10

                    101
                    1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22
        Skriv en metode der anvender lineær søgning
        Skriv en metode der anvender binær søgning
        Hint: Der skal hverken anvendes array eller ArrayList, der skal blot søges blandt tallene 0 til n. */

    public static int findWholeNumberRootLinear(int n) {
        int r = 0;
        Boolean isFound = false;
        int i = 0;
        while (!isFound && i < n) {
            int root = i * i;
            if (root == n) {
                r = i;
                isFound = true;
            } else {
                if (root < n) {
                    r = i;
                    i++;
                }
                if (root > n) {
                    isFound = true;
                }
            }
        }
        return r;
    }

    public static int findWholeNumberRootBinary(int n) {
        Boolean isFound = false;
        int r = 0;
        int left = 0;
        int right = n;
        int i = 0;
        while (!isFound) {
            int middle = (left + right) / 2;
            int root = middle * middle;
            if (root == n) {
                r = middle;
                isFound = true;
            } else {
                if (root > n) {
                    right = middle;
                } else if (root < n) {
                    r = middle;
                    left = middle;
                }
            }
        }
        return r;
    }

}
