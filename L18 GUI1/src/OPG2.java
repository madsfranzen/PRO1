import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class OPG2 extends Application {

    private final TextField txfNumber = new TextField();

    public void start(Stage stage) {
        stage.setTitle("OPG 2");
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

        Label lblNumber = new Label("Number:");
        pane.add(lblNumber, 0, 0, 1, 2);
        pane.add(txfNumber, 1, 0, 1, 2);
        txfNumber.setText("0");
        txfNumber.setPrefWidth(50);
        txfNumber.setEditable(false);
        txfNumber.setMouseTransparent(true);
        txfNumber.setFocusTraversable(false);

        Button btnInc = new Button("Inc");
        Button btnDec = new Button("Dec");
        pane.add(btnInc, 2, 0);
        pane.add(btnDec, 2, 1);

        btnInc.setOnAction(event -> incrementAction());
        btnDec.setOnAction(event -> decrementAction());
    }

    private void incrementAction() {
        int num = Integer.parseInt(txfNumber.getText());
        num++;
        txfNumber.setText("" + num);
    }

    private void decrementAction() {
        int num = Integer.parseInt(txfNumber.getText());
        num--;
        txfNumber.setText("" + num);
    }
}
