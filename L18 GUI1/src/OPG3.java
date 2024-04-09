import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class OPG3 extends Application {

    private final TextField txfInvestement = new TextField();
    private final TextField txfYears = new TextField();
    private final TextField txfInterest = new TextField();
    private final TextField txfFutureValue = new TextField();

    public void start(Stage stage) {
        stage.setTitle("OPG 3");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
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


        Label lblInvestement = new Label("Investment:");
        Label lblYears = new Label("Years:");
        Label lblInterest = new Label("Interest (%):");
        Label lblFutureValue = new Label("Future value:");

        pane.add(lblInvestement, 0, 0);
        pane.add(lblYears, 0, 1);
        pane.add(lblInterest, 0, 2);
        pane.add(lblFutureValue, 0, 4);

        Button btnCalculate = new Button("Calculate");
        pane.add(btnCalculate, 1, 3, 2, 1);
        GridPane.setHalignment(btnCalculate, HPos.CENTER);

        pane.add(txfInvestement, 1, 0, 1, 1);
        pane.add(txfYears, 1, 1, 1, 1);
        pane.add(txfInterest, 1, 2, 1, 1);
        pane.add(txfFutureValue, 1, 4, 1, 1);
        txfFutureValue.setFocusTraversable(false);
        txfFutureValue.setEditable(false);
        txfFutureValue.setMouseTransparent(true);
        btnCalculate.setOnAction(event -> calculate());
    }

    private void calculate() {
        int investement = Integer.parseInt(txfInvestement.getText());
        int years = Integer.parseInt(txfYears.getText());
        double interest = Double.parseDouble(txfInterest.getText());
        double futureValue = investement * Math.pow(1 + interest / 100, years);
        txfFutureValue.setText("" + futureValue);
    }
}
