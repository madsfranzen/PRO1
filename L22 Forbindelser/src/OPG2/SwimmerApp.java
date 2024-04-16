package OPG2;

import java.util.ArrayList;
import java.util.List;

public class SwimmerApp {

    public static void main(String[] args) {
        ArrayList<TrainingPlan> trainingPlanList = new ArrayList<>();

        ArrayList<Double> lapTimesJan = new ArrayList<>();
        lapTimesJan.addAll(List.of(1.02, 1.01, 0.99, 0.98, 1.02, 1.04, 0.99));
        Swimmer jan = new Swimmer("Jan", lapTimesJan);

        ArrayList<Double> lapTimesBo = new ArrayList<>();
        lapTimesBo.addAll(List.of(1.05, 1.01, 1.04, 1.06, 1.08, 1.04, 1.02));
        Swimmer bo = new Swimmer("Bo", lapTimesBo);

        ArrayList<Double> lapTimesMikkel = new ArrayList<>();
        lapTimesMikkel.addAll(List.of(1.03, 1.01, 1.02, 1.05, 1.03, 1.06, 1.03));
        Swimmer mikkel = new Swimmer("Mikkel", lapTimesMikkel);

        TrainingPlan planA = new TrainingPlan('A', 16, 10);
        TrainingPlan planB = new TrainingPlan('B', 10, 6);

        trainingPlanList.add(planA);
        trainingPlanList.add(planB);

        planA.addSwimmer(jan);
        planA.addSwimmer(bo);
        planB.addSwimmer(mikkel);

        for (TrainingPlan tPlan : trainingPlanList) {
            System.out.println("Training Plan " + tPlan.getLevel() + ":");
            System.out.println("Weekly water hours: " + tPlan.getWeeklyWaterHours());
            System.out.println("Weekly strength hours: " + tPlan.getWeeklyStrengthHours());
            System.out.println("Swimmers on training plan:");
            for (Swimmer swimmer : tPlan.getSwimmers()) {
                System.out.println("Name: " + swimmer.getName());
                System.out.println("Best lap time: " + swimmer.bestLapTime());
            }
            System.out.println("--------");
        }
    }
}
