package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Deltager;
import model.Hold;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class GUI extends Application {

    private final ListView lvwHold = new ListView();
    private final ListView lvwDeltagere = new ListView();
    private final ListView lvwTure = new ListView();
    private final TextField txfTurDato = new TextField();
    private final TextField txfTurMinutter = new TextField();
    private final TextField txfTurKm = new TextField();
    private final Button btnOpretTur = new Button("Opret tur");

    private final Label lblValgtDeltager = new Label("Valgt deltager: ");
    private final Label lblKmIAlt = new Label("Km i alt: ");
    private final Label lblMinutterIAlt = new Label("Minutter i alt: ");
    private final Label lblError = new Label("");

    public void start(Stage stage) {
        stage.setTitle("SEMESTERPRØVE Mads Franzen - Vi Cykler Til Sønderhøj");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblHold = new Label("Hold");
        Label lblDeltagere = new Label("Deltagere");
        Label lblTure = new Label("Ture");

        pane.add(lblHold, 0, 0);
        pane.add(lblDeltagere, 1, 0);
        pane.add(lblTure, 2, 0);

        pane.add(lvwHold, 0, 1);
        pane.add(lvwDeltagere, 1, 1);
        pane.add(lvwTure, 2, 1, 2, 1);
        lvwHold.setMaxHeight(250);
        lvwDeltagere.setMaxHeight(250);
        lvwTure.setMaxHeight(250);

        pane.add(lblValgtDeltager, 1, 2);
        pane.add(lblKmIAlt, 1, 3);
        pane.add(lblMinutterIAlt, 1, 4);

        Label lblTurDato = new Label("Tur dato: ");
        Label lblTurMinutter = new Label("Tur minutter: ");
        Label lblTurKm = new Label("Tur km: ");
        pane.add(lblTurDato, 2, 2);
        pane.add(lblTurMinutter, 2, 3);
        pane.add(lblTurKm, 2, 4);

        pane.add(txfTurDato, 3, 2);
        pane.add(txfTurMinutter, 3, 3);
        pane.add(txfTurKm, 3, 4);
        pane.add(btnOpretTur, 3, 5);

        pane.add(lblError, 1, 5);
        lblError.setTextFill(Color.RED);
        lblError.setMaxHeight(200);

        lvwTure.setMouseTransparent(true);
        lvwTure.setFocusTraversable(true);


        ChangeListener<Hold> HoldListener = (ov, o, n) -> this.selectedHoldChanged();
        lvwHold.getSelectionModel().selectedItemProperty().addListener(HoldListener);

        ChangeListener<Deltager> DeltagerListener = (ov, o, n) -> this.selectedDeltagerChanged();
        lvwDeltagere.getSelectionModel().selectedItemProperty().addListener(DeltagerListener);

        btnOpretTur.setOnAction(e -> btnOpretTurAction());

        initGUI();

    }

    private void selectedHoldChanged() {
        Hold hold = (Hold) lvwHold.getSelectionModel().getSelectedItem();
        if (hold != null) {
            lvwDeltagere.getItems().setAll(Controller.getDeltagerePåHold(hold));
        } else {
            lvwDeltagere.getItems().clear();
        }
    }

    private void selectedDeltagerChanged() {
        Deltager deltager = (Deltager) lvwDeltagere.getSelectionModel().getSelectedItem();
        if (deltager != null) {
            lvwTure.getItems().setAll(Controller.getTureForDeltager(deltager));
            opdaterLabels(deltager);
        } else {
            lvwTure.getItems().clear();
            resetLabels();
        }
    }

    private void opdaterLabels(Deltager deltager) {
        lblValgtDeltager.setText("Valgt deltager: " + deltager.getNavn());
        lblKmIAlt.setText("Km i alt: " + deltager.kmIAlt());
        lblMinutterIAlt.setText("Minutter i alt: " + deltager.minutterIAlt());
    }

    private void resetLabels() {
        lblValgtDeltager.setText("Valgt deltager: ");
        lblKmIAlt.setText("Km i alt: ");
        lblMinutterIAlt.setText("Minutter i alt:");
    }

    private void resetTextFields() {
        txfTurDato.clear();
        txfTurMinutter.clear();
        txfTurKm.clear();
    }

    private void clearError() {
        lblError.setText("");
        txfTurDato.setBorder(null);
        txfTurMinutter.setBorder(null);
        txfTurKm.setBorder(null);
    }

    private void btnOpretTurAction() {
        clearError();
        try {
            LocalDate dato = LocalDate.parse(txfTurDato.getText());
            int antalMinutter = Integer.parseInt(txfTurMinutter.getText());
            int antalKm = Integer.parseInt(txfTurKm.getText());
            Deltager deltager = (Deltager) lvwDeltagere.getSelectionModel().getSelectedItem();

            if (antalMinutter <= 0 || antalKm <= 0) {
                throw new NumberFormatException();
            }

            if (deltager == null) {
                throw new Exception();

            } else {
                Controller.opretTur(dato, antalMinutter, antalKm, deltager);
                lvwTure.getItems().setAll(deltager.getTure());
                opdaterLabels(deltager);
                resetTextFields();
            }
        } catch (DateTimeParseException e) {
            lblError.setText("Could not parse {Tur dato} \n Please check formatting");
            txfTurDato.setBorder(Border.stroke(Color.RED));
        } catch (NumberFormatException e) {
            lblError.setText("Missing or invalid input values for \n {Tur minutter} or {Tur km}");
            txfTurMinutter.setBorder(Border.stroke(Color.RED));
            txfTurKm.setBorder(Border.stroke(Color.RED));
        } catch (Exception e) {
            lblError.setText("Please select a Deltager");
        }
    }

    private void initGUI() {
        lvwHold.getItems().setAll(Controller.getAlleHold());

        setGUISomAnvistIOpgaven();
    }

    private void setGUISomAnvistIOpgaven() {
        lvwHold.getSelectionModel().select(0);
        lvwDeltagere.getSelectionModel().select(0);
        txfTurDato.setText("2024-05-20");
        txfTurMinutter.setText("75");
        txfTurKm.setText("20");
    }
}
