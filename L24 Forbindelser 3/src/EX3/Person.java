package EX3;

import java.util.ArrayList;

public class Person {
    private String name;
    private int age;
    private ArrayList<Gift> recievingGifts;

    public Person(String name) {
        this.name = name;
        recievingGifts = new ArrayList<>();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public ArrayList<Gift> getRecievingGift() {
        return recievingGifts;
    }

    public void addRecievingGift(Gift recievingGift) {
        this.recievingGifts.add(recievingGift);
    }

    public double calculateTotalValueRecieving() {
        double value = 0;
        for (Gift gift : recievingGifts) {
            value += gift.getPrice();
        }
        return value;
    }

    public ArrayList<Person> getRecipientsGivers() {
        ArrayList<Person> recipientsGivers = new ArrayList<>();
        for (Gift gift : recievingGifts) {
            recipientsGivers.add(gift.getGiver());
        }
        return recipientsGivers;
    }
}
