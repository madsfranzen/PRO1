package gui;

import controller.Controller;
import model.Badge;
import model.Deltager;
import model.Hold;

import java.time.LocalDate;

public class Juni24App {
    public static void main(String[] args) {

        initStorage();
        // Controller.udskrivDeltagerOversigt("SemesterProve2024/src/print.txt");
        GUI.launch(GUI.class);
    }

    public static void initStorage() {

        Hold cyklisterne = Controller.opretHold("Cyklisterne");
        Hold optimisterne = Controller.opretHold("Optimisterne");

        Deltager ole = Controller.opretDeltager("Ole", "12345678", cyklisterne);
        Deltager ib = Controller.opretDeltager("Ib", "12341234", cyklisterne);
        Deltager pia = Controller.opretDeltager("Pia", "12344321", cyklisterne);

        Controller.opretTur(LocalDate.of(2024, 05, 15), 120, 30, ole);
        Controller.opretTur(LocalDate.of(2024, 05, 16), 60, 15, ole);
        Controller.opretTur(LocalDate.of(2024, 05, 16), 90, 25, ib);

        Badge badge25Km = Controller.opretBadge("25 km på én dag");
        Badge badge2dageITræk = Controller.opretBadge("2 dage i træk");
        Badge badgeHentEnKollega = Controller.opretBadge("Hent en kollega");

        Controller.tilføjBadgeTilDeltager(badge25Km, ole);
        Controller.tilføjBadgeTilDeltager(badge25Km, ib);
        Controller.tilføjBadgeTilDeltager(badge2dageITræk, ole);

    }
}
