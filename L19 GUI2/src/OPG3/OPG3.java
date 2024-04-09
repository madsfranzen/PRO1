package OPG3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class OPG3 extends Application {

    private final ListView<Person> lvwPersons = new ListView<>();
    private final ArrayList<Person> persons = new ArrayList<>();
    private PersonInfoWindow personInfoWindow;

    @Override
    public void start(Stage stage) {
        stage.setTitle("OPGAVE 3");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        personInfoWindow = new PersonInfoWindow("Person Information", stage);
    }

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setMinWidth(300);
        pane.setMinHeight(300);

        initPersons();

        Label lblPersons = new Label("Persons:");
        pane.add(lblPersons, 0, 0);

        pane.add(lvwPersons, 0, 1);
        lvwPersons.setPrefHeight(200);
        lvwPersons.setPrefWidth(200);
        lvwPersons.setEditable(false);
        lvwPersons.setMouseTransparent(true);
        lvwPersons.setFocusTraversable(false);

        Button btnAddPerson = new Button("Add Person");
        pane.add(btnAddPerson, 2, 1);
        btnAddPerson.setOnAction(event -> openPersonInfoWindow());
    }

    private void openPersonInfoWindow() {
        personInfoWindow.personCreated = false;
        personInfoWindow.tatsuroPlayer.play();
        personInfoWindow.setOnCloseRequest(event -> personInfoWindow.closeWindow());
        personInfoWindow.showAndWait();

        if (personInfoWindow.personCreated == true) {
            Person person = personInfoWindow.getPerson();
            persons.add(person);
            lvwPersons.getItems().setAll(persons);
        }
    }

    private void initPersons() {
        persons.add(new Person("Jan Petersen", "Doktor", true));
        persons.add(new Person("Hans Madsen", "Underviser", false));
        persons.add(new Person("Pia Madsen", "Mekaniker", true));
        lvwPersons.getItems().setAll(persons);
    }
}
