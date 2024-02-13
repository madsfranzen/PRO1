package ex2;

public class B110 {
    public static void main(String[] args) {
        int distanceKm = 15;
        double time = 50.5;
        double kmPerHour = time / distanceKm;
        double milesPerHour;

        System.out.println("Kilometers per hour = " + kmPerHour);
        System.out.println("Miles per hour = " + kmPerHour / 1.6);
    }
}
