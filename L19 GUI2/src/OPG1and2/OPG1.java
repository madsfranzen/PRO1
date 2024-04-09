package OPG1and2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class OPG1 extends Application {

    private final TextField txfName = new TextField();
    private final TextField txfTitle = new TextField();
    private final ListView<Person> lvwPersons = new ListView<>();
    private final ArrayList<Person> persons = new ArrayList<>();
    private final CheckBox ckbSenior = new CheckBox();

    @Override
    public void start(Stage stage) {
        stage.setTitle("ListView Demo4");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane) {

        this.initPersons();

        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);
        Label lblTitle = new Label("Title:");
        pane.add(lblTitle, 0, 1);
        pane.add(txfName, 1, 0, 2, 1);
        pane.add(txfTitle, 1, 1, 2, 1);
        pane.add(ckbSenior, 1, 2);
        Button btnAddPerson = new Button("Add person");
        pane.add(btnAddPerson, 4, 2);
        Label lblPerson = new Label("Persons:");
        pane.add(lblPerson, 0, 3);
        pane.add(lvwPersons, 1, 3);
        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(200);
        lvwPersons.getItems().setAll(persons);
        GridPane.setValignment(lblPerson, VPos.TOP);
        btnAddPerson.setOnAction(event -> addPersonAction());
    }

    private void addPersonAction() {

        if (txfName.getText().trim().length() == 0 || txfTitle.getText().trim().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Add Person");
            alert.setHeaderText("Information missing");
            alert.setContentText("Please provide Name and Title");
            alert.show();
        } else {
            Person person = new Person(txfName.getText(), txfTitle.getText(), ckbSenior.isSelected());
            persons.add(person);
            lvwPersons.getItems().setAll(persons);
            txfName.clear();
            txfTitle.clear();
            ckbSenior.setSelected(false);
        }
    }

    private void initPersons() {
        persons.add(new Person("Jan Petersen", "Doktor", true));
        persons.add(new Person("Hans Madsen", "Underviser", false));
        persons.add(new Person("Pia Madsen", "Mekaniker", true));
    }
}
