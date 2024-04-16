package OPG1;

import java.util.ArrayList;

public class Swimmer {
    private String name;
    private ArrayList<Double> lapTimes;
    private TrainingPlan trainingPlan;

    public Swimmer(String name, ArrayList<Double> lapTimes) {
        this.name = name;
        this.lapTimes = lapTimes;
    }

    public String getName() {
        return this.name;
    }

    public TrainingPlan getTrainingPlan() {
        return this.trainingPlan;
    }

    public void setTrainingPlan(TrainingPlan trainingPlan) {
        this.trainingPlan = trainingPlan;
    }

    public ArrayList<Double> getLapTimes() {
        return lapTimes;
    }

    /**
     * Return the fastest lap time.
     */
    public double bestLapTime() {
        // TODO: implement!
        return 0;
    }

    public int allTrainingHours() {
        return trainingPlan.getWeeklyStrengthHours() + trainingPlan.getWeeklyStrengthHours();
    }
}
