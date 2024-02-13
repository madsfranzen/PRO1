public class OPG1b {
    public static void main(String[] args) {

        int limit = 100;
        int sum = 0;
        int i = 1;
        int kvadrat = 0;

        while (kvadrat <= limit) {
            sum = sum + kvadrat;
            kvadrat = i * i;
            i++;
        }

        System.out.println(sum);
    }
}
