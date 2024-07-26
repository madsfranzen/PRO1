package EX3;

import java.util.Arrays;

public class TestApp {
    public static void main(String[] args) {
        Gift bold = new Gift(100);
        Person mikael = new Person("Mikael");
        Person jens = new Person("Jens");

        mikael.addRecievingGift(bold);
        bold.setGiver(jens);

        System.out.println(mikael.calculateTotalValueRecieving());
        System.out.println(mikael.getRecipientsGivers());
        System.out.println(mikael.getRecievingGift());
    }
}
