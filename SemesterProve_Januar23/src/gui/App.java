package gui;

import controller.Controller;

public class App {
    public static void main(String[] args) {
        Controller.initStorage();
        Controller.salgTilFil("SemesterProve_Januar23/src/print.txt");
        GUI.launch(GUI.class);
    }
}
