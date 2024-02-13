package ex3;

public class B111 {
    public static void main(String[] args) {

        double population = 312032486;
        int daysInYear = 365;

        double secondsPerDay = 86400.00;
        double dailyBirth = secondsPerDay / 7.00;
        double dailyDeath = secondsPerDay / 13.00;
        double dailyImmigration = secondsPerDay / 45.00;
        double dailyGrowth = dailyBirth - dailyDeath + dailyImmigration;

        double yearlyGrowth = dailyGrowth * daysInYear;

        System.out.println(yearlyGrowth);
        System.out.printf("Current Poulation: %.0f \n", population);
        System.out.printf("          Year 1 : %.0f \n", population + yearlyGrowth);
        System.out.printf("          Year 2 : %.0f \n", population + yearlyGrowth * 2);
        System.out.printf("          Year 3 : %.0f \n", population + yearlyGrowth * 3);
        System.out.printf("          Year 4 : %.0f \n", population + yearlyGrowth * 4);
        System.out.printf("          Year 5 : %.0f \n", population + yearlyGrowth * 5);

    }
}
