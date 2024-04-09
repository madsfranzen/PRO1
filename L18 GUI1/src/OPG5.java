import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class OPG5 extends Application {

    private final TextField txfInput = new TextField();
    private final TextArea txaNames = new TextArea();
    private ArrayList<String> names = new ArrayList<>();

    public void start(Stage stage) {
        stage.setTitle("TEMPERATURE CONVERTER");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane, 250, 350);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setAlignment(Pos.CENTER);

        Label lblName = new Label("Name");
        Button btnAdd = new Button("Add");
        btnAdd.setDefaultButton(true);

        pane.add(lblName, 0, 0);
        pane.add(txfInput, 0, 1, 1, 1);
        pane.add(btnAdd, 0, 2, 1, 1);
        GridPane.setHalignment(btnAdd, HPos.CENTER);
        pane.add(txaNames, 0, 3, 1, 2);
        btnAdd.setOnAction(event -> addName());
        txaNames.setEditable(false);
        txaNames.setMouseTransparent(true);
        txaNames.setFocusTraversable(false);
    }

    private void addName() {
        names.add(txfInput.getText());
        String namesString = "";
        for (int i = 0; i < names.size(); i++) {
            namesString = namesString.concat(names.get(i) + "\n");
        }
        txaNames.setText(namesString);
        txfInput.clear();
    }
}
