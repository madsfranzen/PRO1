package OPG3;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.io.File;

public class PersonInfoWindow extends Stage {

    private final TextField txfName = new TextField();
    private final TextField txfTitle = new TextField();
    private final CheckBox chkSenior = new CheckBox("Senior");
    private final Button btnCancel = new Button("Cancel");
    private final Button btnOK = new Button("OK");
    public boolean personCreated = false;
    Media tatsuro = new Media(new File("/Users/madsfranzen/Documents/PRO1/PRO1 IntelliJ/L19 GUI2/src/OPG3/tatsuro.mp3").toURI().toString());
    MediaPlayer tatsuroPlayer = new MediaPlayer(tatsuro);
    private Person person = null;

    public PersonInfoWindow(String title, Stage owner) {

        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);
        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblName = new Label("Name:");
        Label lblTitle = new Label("Title:");

        pane.add(lblName, 0, 0);
        pane.add(lblTitle, 0, 1);
        pane.add(txfName, 1, 0);
        pane.add(txfTitle, 1, 1);
        pane.add(chkSenior, 1, 2);
        btnCancel.setPrefWidth(75);
        btnOK.setPrefWidth(75);
        HBox btnBox = new HBox(25, btnCancel, btnOK);

        GridPane pane2 = new GridPane();
        pane2.add(btnBox, 0, 0);
        pane2.setAlignment(Pos.CENTER);
        pane.add(pane2, 0, 3, 3, 1);

        btnCancel.setOnAction(event -> cancelAction());
        btnOK.setOnAction(event -> okAction());
    }

    private void cancelAction() {
        tatsuroPlayer.stop();
        this.close();
        txfName.clear();
        txfTitle.clear();
        chkSenior.setSelected(false);
    }

    private void okAction() {
        if (txfName.getText().trim().length() > 0 && txfTitle.getText().trim().length() > 0) {
            String name = txfName.getText().trim();
            String title = txfTitle.getText().trim();
            Boolean isSenior = chkSenior.isSelected();
            person = new Person(name, title, isSenior);
            personCreated = true;
            closeWindow();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Missing Information");
            alert.setHeaderText("Information about Person is missing.");
            alert.setContentText("Please input information about Person.");
            alert.show();
            if (txfName.getText().trim().length() == 0) {
                txfName.requestFocus();
            } else txfTitle.requestFocus();
        }
    }

    public Person getPerson() {
        return person;
    }

    public void closeWindow() {
        cancelAction();
    }
}
