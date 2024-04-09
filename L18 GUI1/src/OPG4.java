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

public class OPG4 extends Application {

    private final TextField txfFahrenheit = new TextField();
    private final TextField txfCelsius = new TextField();

    public void start(Stage stage) {
        stage.setTitle("TEMPERATURE CONVERTER");
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


        Label lblFahrenheit = new Label("Fahrenheit:");
        Label lblCelsius = new Label("Celsius:");
        pane.add(lblFahrenheit, 0, 0);
        pane.add(txfFahrenheit, 0, 1);
        Button btnCalculate = new Button("Convert");
        GridPane.setHalignment(btnCalculate, HPos.CENTER);
        pane.add(btnCalculate, 0, 2);
        pane.add(lblCelsius, 0, 3);
        pane.add(txfCelsius, 0, 4);
        btnCalculate.setDefaultButton(true);
        btnCalculate.setOnAction(event -> convert());
    }

    private void convert() {
        if (txfFahrenheit.isFocused()) {
            double fahrenheit = Double.parseDouble(txfFahrenheit.getText());
            double celsius = (fahrenheit - 32) * 5 / 9;
            txfCelsius.setText("" + celsius);
        } else if (txfCelsius.isFocused()) {
            double celsius = Double.parseDouble(txfCelsius.getText());
            double fahrenheit = 9.0 / 5 * celsius + 32;
            txfFahrenheit.setText("" + fahrenheit);
        }
    }
}
