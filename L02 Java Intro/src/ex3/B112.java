package ex3;

public class B112 {
    public static void main(String[] args) {
        int distanceMiles = 24;
        double timeMinutes = 100;
        double seconds = 35;
        timeMinutes = timeMinutes + seconds / 60;
        double timeHour = timeMinutes / 60;
        double milesPerHour =  distanceMiles / timeHour;
        double kilometersPerHour = milesPerHour * 1.6;

        System.out.println(kilometersPerHour);
    }
}
