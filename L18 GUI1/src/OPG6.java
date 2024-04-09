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

public class OPG6 extends Application {

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

        Button btn = new Button();
        btn.setDisable(false);
    }
}
