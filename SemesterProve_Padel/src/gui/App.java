package gui;

import controller.Controller;
import model.Bane;
import model.Kategori;
import model.Spiller;

import java.time.LocalDate;
import java.time.LocalTime;

public class App {
    public static void main(String[] args) {

        initStorage();
        Controller.printAlleBookings("SemesterProve_Padel/src/storage/print.txt");
        PadelGUI.launch(PadelGUI.class);
    }

    public static void initStorage() {
        Kategori luksus = Controller.opretKategori("Luksus", 100, 200);
        Kategori mellem = Controller.opretKategori("Mellem", 50, 100);
        Kategori begynder = Controller.opretKategori("Begynder", 25, 50);

        Bane bane1 = Controller.opretBane(1, true, LocalTime.of(9, 0), LocalTime.of(17, 0), luksus);
        Bane bane2 = Controller.opretBane(2, true, LocalTime.of(9, 0), LocalTime.of(17, 0), luksus);
        Bane bane3 = Controller.opretBane(3, true, LocalTime.of(9, 0), LocalTime.of(17, 0), mellem);
        Bane bane4 = Controller.opretBane(4, false, LocalTime.of(9, 0), LocalTime.of(17, 0), mellem);
        Bane bane5 = Controller.opretBane(5, false, LocalTime.of(9, 0), LocalTime.of(17, 0), begynder);
        Bane bane6 = Controller.opretBane(6, false, LocalTime.of(9, 0), LocalTime.of(17, 0), begynder);

        Spiller andreas = Controller.opretSpiller("Andreas", "DMU");
        Spiller petra = Controller.opretSpiller("Petra", "DMU");
        Spiller henrik = Controller.opretSpiller("Henrik", "ITA");
        Spiller ulla = Controller.opretSpiller("Ulla", "ITA");

        Controller.opretBooking(LocalDate.of(2023, 06, 20), LocalTime.of(10, 00), true, andreas, bane3);
        Controller.opretBooking(LocalDate.of(2023, 06, 22), LocalTime.of(10, 00), false, andreas, bane2);
        Controller.opretBooking(LocalDate.of(2023, 06, 20), LocalTime.of(11, 00), false, henrik, bane3);
        Controller.opretBooking(LocalDate.of(2023, 06, 20), LocalTime.of(16, 00), false, ulla, bane3);
        Controller.opretBooking(LocalDate.of(2023, 06, 23), LocalTime.of(17, 00), true, ulla, bane5);

        System.out.println(bane3.tidLedig(LocalDate.of(2023, 06, 20), LocalTime.of(10, 00)));
        System.out.println(bane3.tidLedig(LocalDate.of(2023, 07, 20), LocalTime.of(10, 00)));
    }
}
