package OPG6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("OPG 6"); // may be changed
        stage.setScene(scene);
        stage.show();
    }

    private Pane initContent() {
        Pane pane = new Pane();
        pane.setPrefSize(200, 200); // may be changed
        this.drawShapes(pane);
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(Pane pane) {
        Line line = new Line(10, 180, 196, 180);
        pane.getChildren().add(line);

        int x = 20;
        int y1 = 184;
        int y2 = 176;
        for (int i = 0; i < 11; i++) {

            if (i % 5 == 0) {
                Line xLine = new Line(x, y1 + 3, x, y2 - 3);
                pane.getChildren().add(xLine);

                Text text = new Text(x, 200, Integer.toString(i));
                pane.getChildren().add(text);

            } else {
                Line xLine = new Line(x, y1, x, y2);
                pane.getChildren().add(xLine);
            }
            x += 16;
        }
        Line line1 = new Line(x, 180, x - 6, 180 - 4);
        Line line2 = new Line(x, 180, x - 6, 180 + 4);
        pane.getChildren().addAll(line1, line2);


    }
}
