package OPG2;

import java.util.ArrayList;

public class TrainingPlan {
    private ArrayList<Swimmer> swimmers = new ArrayList<>();
    private char level;
    private int weeklyWaterHours;
    private int weeklyStrengthHours;

    public TrainingPlan(char level, int weeklyWaterHours, int weeklyStrengthHours) {
        this.level = level;
        this.weeklyWaterHours = weeklyWaterHours;
        this.weeklyStrengthHours = weeklyStrengthHours;
    }

    public char getLevel() {
        return level;
    }

    public int getWeeklyStrengthHours() {
        return weeklyStrengthHours;
    }

    public int getWeeklyWaterHours() {
        return weeklyWaterHours;
    }

    public void addSwimmer(Swimmer swimmer) {
        swimmers.add(swimmer);
    }

    public ArrayList<Swimmer> getSwimmers() {
        return swimmers;
    }
}
