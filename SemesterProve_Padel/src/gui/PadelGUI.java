package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Bane;
import model.Booking;
import model.Spiller;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;

public class PadelGUI extends Application {

    private final ListView lvwBaner = new ListView();
    private final ListView lvwSpiller = new ListView();
    private final TextArea txaSpillerBookinger = new TextArea();
    private final TextArea txaAntalBookingerPåBane = new TextArea();
    private final DatePicker txfDato = new DatePicker();
    private final TextField txfTid = new TextField();
    private final CheckBox chbSingle = new CheckBox("Single");
    private final Button btnBook = new Button("Book bane til spiller");
    private final Label lblError = new Label();

    public void start(Stage stage) {
        stage.setTitle("XTREME PADEL");
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

        Label lblBaner = new Label("Baner");
        Label lblSpiller = new Label("Spillere");
        Label lblSpillerensBookinger = new Label("Spillerens Bookinger");

        pane.add(lblBaner, 0, 0);
        pane.add(lblSpiller, 2, 0);
        pane.add(lblSpillerensBookinger, 3, 0);

        pane.add(lvwBaner, 0, 1, 2, 1);
        pane.add(lvwSpiller, 2, 1, 1, 1);
        pane.add(txaSpillerBookinger, 3, 1, 2, 1);

        Label lblAntalBookinger = new Label("Antal bookinger på banen");
        Label lblOpretBooking = new Label("Opret booking:");
        pane.add(lblAntalBookinger, 0, 2);
        pane.add(lblOpretBooking, 3, 2);

        pane.add(txaAntalBookingerPåBane, 0, 3, 2, 5);
        txaSpillerBookinger.setEditable(false);
        txaAntalBookingerPåBane.setEditable(false);

        Label lblDato = new Label("Dato:");
        Label lblTid = new Label("Tid");
        pane.add(lblDato, 3, 3);
        pane.add(lblTid, 3, 4);
        pane.add(txfDato, 4, 3);
        pane.add(txfTid, 4, 4);
        pane.add(chbSingle, 4, 5);
        pane.add(btnBook, 3, 6);

        txfTid.setPromptText("00:00");
        txfTid.setMaxWidth(100);

        pane.add(lblError, 3, 7, 2, 1);

        ChangeListener<Bane> BaneListener = (ov, o, n) -> this.selectedBaneChanged();
        lvwBaner.getSelectionModel().selectedItemProperty().addListener(BaneListener);

        ChangeListener<Spiller> SpillerListener = (ov, o, n) -> this.selectedSpillerChanged();
        lvwSpiller.getSelectionModel().selectedItemProperty().addListener(SpillerListener);

        btnBook.setOnAction(e -> btnBookBaneAction());

        initGUI();
    }

    public void initGUI() {
        lvwBaner.getItems().setAll(Controller.getBaner());
        lvwSpiller.getItems().setAll(Controller.getSpillere());
    }

    public void selectedBaneChanged() {
        Bane bane = (Bane) lvwBaner.getSelectionModel().getSelectedItem();
        if (bane != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bane.antalBookingerPrTime().length; i++) {
                sb.append("Tid: " + (i + 9) + " antal: " + bane.antalBookingerPrTime()[i]);
                sb.append("\n");
            }
            txaAntalBookingerPåBane.setText(sb.toString());
        }
    }

    public void selectedSpillerChanged() {
        Spiller spiller = (Spiller) lvwSpiller.getSelectionModel().getSelectedItem();
        if (spiller != null) {
            StringBuilder sb = new StringBuilder();
            for (Booking booking : spiller.getBookinger()) {
                sb.append(booking.toString());
                sb.append("\n");
            }
            txaSpillerBookinger.setText(sb.toString());
        }
    }

    public void btnBookBaneAction() {
        lblError.setTextFill(Color.RED);

        LocalDate dato = txfDato.getValue();
        boolean single = chbSingle.isSelected();
        Spiller spiller = (Spiller) lvwSpiller.getSelectionModel().getSelectedItem();
        Bane bane = (Bane) lvwBaner.getSelectionModel().getSelectedItem();
        LocalTime tid = null;

        // Validerer inputs
        if (bane == null) {
            lblError.setText("Vælg venligst en bane");
        } else if (spiller == null) {
            lblError.setText("Vælg venligst en spiller");
        } else if (txfDato.getValue() == null) {
            lblError.setText("Vælg venligst en dato");
        } else if (txfTid.getText().isEmpty()) {
            lblError.setText("Vælg venligst et tidspunkt");
        } else {
            // Validerer tidspunkt
            try {
                tid = LocalTime.parse(txfTid.getText());
                if (tid.isBefore(bane.getFørsteTid()) || tid.isAfter(bane.getSidsteTid())) {
                    lblError.setText("Den ønskede tid ligger uden for den valgte banes åbningstider.");
                } else if (tid.equals(bane.getSidsteTid())) {
                    lblError.setText("Den valgte bane lukker kl. " + bane.getSidsteTid() + ". Flyt venligst din tid en time tilbage.");
                } else if (!bane.tidLedig(dato, tid)) {
                    lblError.setText("Den valgte bane er desværre ikke ledig på dette tidspunkt.");
                    // Såfremt korrekt input og banen er ledig ->
                } else {
                    opretBooking(dato, tid, single, spiller, bane);
                }
            } catch (DateTimeException e) {
                lblError.setText("Angiv venligst et tidspunkt i korrekt format (00:00)");
            }
        }
    }

    public void opretBooking(LocalDate dato, LocalTime tid, boolean single, Spiller spiller, Bane bane) {
        Controller.opretBooking(dato, tid, single, spiller, bane);
        lblError.setTextFill(Color.BLACK);
        lblError.setText("Booking oprettet.");
        txaAntalBookingerPåBane.clear();
        txaSpillerBookinger.clear();
        txfTid.clear();
        txfDato.setValue(null);
        initGUI();
    }
}
