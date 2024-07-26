package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Salgsannonce;
import model.Vare;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class GUI extends Application {

    private ListView lvwAktiveAnnoncer = new ListView();
    private ListView lvwVarer = new ListView();
    private TextField txfKøber = new TextField();
    private TextField txfAftaltPris = new TextField();
    private Button btnOpretSalg = new Button("Opret Salg");
    private TextField txfFilnavn = new TextField();
    private Button btnSalgsfil = new Button("Salgsfil");

    public void start(Stage stage) throws FileNotFoundException {
        stage.setTitle("SEMESTERPRØVE");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblAktiveAnnoncer = new Label("Aktive Annoncer");
        Label lblVarer = new Label("Varer");
        pane.add(lblAktiveAnnoncer, 0, 0);
        pane.add(lblVarer, 1, 0);
        pane.add(lvwAktiveAnnoncer, 0, 1, 1, 5);
        pane.add(lvwVarer, 1, 1, 1, 5);
        lvwAktiveAnnoncer.setMaxHeight(300);
        lvwVarer.setMaxHeight(300);

        Label lblKøber = new Label("Køber");
        Label lblAftaltPris = new Label("Aftalt Pris");
        pane.add(lblKøber, 3, 1);
        pane.add(txfKøber, 4, 1);
        pane.add(lblAftaltPris, 3, 2);
        pane.add(txfAftaltPris, 4, 2);
        pane.add(btnOpretSalg, 3, 3);

        Label lblFilNavn = new Label("Filnavn");
        pane.add(lblFilNavn, 3, 6);
        pane.add(txfFilnavn, 4, 6);
        pane.add(btnSalgsfil, 3, 7);

        updateGUI();

        btnOpretSalg.setOnAction(e -> opretSalgAction());


        ChangeListener<Salgsannonce> AnnonceListener = (ov, o, n) -> this.selectedAnnonceChanged();
        lvwAktiveAnnoncer.getSelectionModel().selectedItemProperty().addListener(AnnonceListener);

    }

    private void selectedAnnonceChanged() {
        Salgsannonce salgsannonce = (Salgsannonce) lvwAktiveAnnoncer.getSelectionModel().getSelectedItem();
        if (salgsannonce != null) {
            lvwVarer.getItems().setAll(salgsannonce.getVarer());
        }
    }

    private void updateGUI() {
        lvwAktiveAnnoncer.getItems().setAll(Controller.getAnnoncer());
        lvwVarer.getItems().clear();
        txfAftaltPris.clear();
        txfFilnavn.clear();
        txfKøber.clear();
    }

    private void opretSalgAction() {
        String navn = txfKøber.getText();
        int aftaltPris = Integer.parseInt(txfAftaltPris.getText());
        ArrayList<Vare> varer = new ArrayList<>(lvwVarer.getSelectionModel().getSelectedItems());
        if (!navn.isEmpty() && aftaltPris > 0 && varer.size() > 0) {
            Controller.opretSalg(navn, aftaltPris, varer.toArray(new Vare[0]));
            updateGUI();
            for (Vare vare : varer) {
                System.out.println(vare.getNavn());
            }
        }

    }
}
