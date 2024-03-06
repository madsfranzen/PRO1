package OPG3;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class RentalApp {
    public static void main(String[] args) {


        Rental rental2 = new Rental(1,
                5,
                150,
                LocalDate.of(2025,
                        1,
                        6));

        Rental rental1 = new Rental(1,
                10,
                150,
                LocalDate.of(2024,
                        4,
                        1));


        System.out.println("Total price for Rental 1: " + rental1.getTotalPrice());


        System.out.println("Total price for Rental 2: " + rental2.getTotalPrice());

        System.out.println("Number of years, months and days between R1 and R2: " + Period.between(rental1.getEndDate(), rental2.getStartDate()));
        System.out.println("Number of years, months and days between R1 and R2: " + ChronoUnit.DAYS.between(rental1.getEndDate(), rental2.getStartDate()));
    }
}
