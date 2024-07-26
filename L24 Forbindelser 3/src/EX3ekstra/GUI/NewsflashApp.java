package EX3ekstra.GUI;

import EX3ekstra.Controller;
import EX3ekstra.NewsFlash;
import javafx.application.Application;

public class NewsflashApp {
    public static void main(String[] args) {

        Controller.createNewsFlash("Børsen Brænder", "Den historiske bygning Børsen i København stod tirsdag morgen i flammer. Brandvæsenet fik den første anmeldelse om branden kl. 7.36. På kort tid havde flammerne spredt sig og omkring kl. 8.30 styrtede bygningens ikoniske spir sammen.");
        Controller.createNewsFlash("AGF Vinder Trods Store Vanskeligheder", "\n" + "Nat og dag.\n" + "\n" + "Det udtryk beskriver ganske godt FC Københavns seneste fem kampe, hvor det er blevet til fremragende resultater i Champions League, men i den grad også panderynker i Superligaen.\n" + "\n" + "Søndag aften tabte FCK 1-2 hjemme mod AGF i en dramatisk affære og har derfor blot hentet ét point i de seneste tre ligakampe - mod Brøndby, Viborg og altså AGF.\n" + "\n" + "I en underholdende slagudveksling i Parken viste AGF skarphed på to hjørnespark, hvilket akkurat var nok til tre point trods en række store FCK-chancer.\n" + "\n" + "FCK sad tungt på spillet og sværmede i perioder om AGF-målet, mens gæsterne forsvarede sig dybt og satsede på omstillinger og dødbolde.\n" + "\n" + "Mulighederne var mange, men effektivitet var en mangelvare, så FCK overvintrer på 33 point, hvilket er ét færre end det aktuelle førerhold Brøndby.\n" + "\n" + "FC Midtjylland kan ramme 36 af slagsen ved at slå Viborg mandag.");

        Application.launch(NewsflashGUI.class);
    }
}
