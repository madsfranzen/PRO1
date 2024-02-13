public class Stars {
    public static void main(String[] args) {
//        exA(10);
//        System.out.println();

        exD(10);
        System.out.println();
    }

    public static void exA(int rowCount) {
        for (int row = 1; row <= rowCount; row++) {

            // print row number
            System.out.printf("%2d: ", row);

            // print stars
            int starCount = rowCount - row + 1;
            for (int i = 1; i <= starCount; i++) {
                System.out.print('*');
            }
            // print dashes
            int dashCount = rowCount - starCount;
            for (int i = 1; i <= dashCount; i++) {
                System.out.print('-');
            }
            // go to next line
            System.out.println();
        }
    }

    public static void exB(int rowCount) {
        for (int row = 1; row <= rowCount; row++) {

            // print row number
            System.out.printf("%2d: ", row);

            int starCount = row;

            // print dashes
            int dashCount = rowCount - starCount;
            for (int i = 1; i <= dashCount; i++) {
                System.out.print('-');
            }

            // print stars
            for (int i = 1; i <= starCount; i++) {
                System.out.print('*');
            }


            // go to next line
            System.out.println();
        }
    }

    public static void exC(int rowCount) {
        for (int row = 1; row <= rowCount; row++) {

            // print row number
            System.out.printf("%2d: ", row);
            // print dashes
            int starCount = rowCount - row + 1;
            int dashCount = rowCount - starCount;
            for (int i = 1; i <= dashCount; i++) {
                System.out.print('-');
            }
            // print stars
            for (int i = 1; i <= starCount; i++) {
                System.out.print('*');
            }
            // go to next line
            System.out.println();
        }
    }

    public static void exD(int rowCount) {

        int cap = 0;
        for (int row = 1; row <= rowCount; row++) {
            cap++;
            // print row number
            System.out.printf("%2d: ", row);
            // print stars
            if (rowCount - row > 5 && cap < 6) {
                int starCount = (row * 2 - 1);
                for (int i = 1; i <= starCount && rowCount - row > 5; i++) {
                    System.out.print("*");
                }
            } else if (rowCount - row < 5) {
                int starCount = (rowCount - row) * 2 + 1;
                for (int i = 1; i <= starCount; i++) {
                    System.out.print("*");
                }
            } else System.out.print("*********");

            System.out.println();
        }
    }
}
