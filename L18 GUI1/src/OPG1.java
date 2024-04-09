import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;


public class OPG1 extends Application {

    private final TextField txfFirstName = new TextField();
    private final TextField txfLastName = new TextField();
    private final TextField txfFullName = new TextField();

    public void start(Stage stage) {
        stage.setTitle("OPG 1");
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

        Label lblFirstName = new Label("First name:");
        pane.add(lblFirstName, 0, 0);
        pane.add(txfFirstName, 0, 1, 1, 1);

        Label lblLastName = new Label("Last name:");
        pane.add(lblLastName, 1, 0);
        pane.add(txfLastName, 1, 1, 1, 1);

        Label lblFullName = new Label("Full name:");
        pane.add(lblFullName, 0, 3);
        pane.add(txfFullName, 0, 4, 2, 1);
        txfFullName.setEditable(false);
        txfFullName.setMouseTransparent(true);
        txfFullName.setFocusTraversable(false);

        Button btnCombine = new Button("Combine");
        pane.add(btnCombine, 1, 5);
        btnCombine.setDefaultButton(true);


        btnCombine.setOnAction(even -> this.combineAction());

    }

    private void combineAction() {
        String firstName = txfFirstName.getText().trim();
        String lastName = txfLastName.getText().trim();
        String Fullname = firstName + " " + lastName;
        txfFullName.setText(Fullname);

    }


}
