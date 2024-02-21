package OPG3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("OPG 3"); // may be changed
        stage.setScene(scene);
        stage.show();
    }

    private Pane initContent() {
        Pane pane = new Pane();
        pane.setPrefSize(200, 200); // may be changed

        // CHOOSE FIGURE HERE (1, 2 or 3)
        this.drawShapes3(pane);
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes1(Pane pane) {
        int x = 20;
        int y1 = 10;
        int y2 = 180;
        while (x <= 180) {
            Line line = new Line(x, y1, x, y2);
            pane.getChildren().add(line);
            x += 40;
        }
    }

    private void drawShapes2(Pane pane) {
        int x1 = 20;
        int y = 20;
        int x2 = 180;
        while (y <= 180) {
            Line line = new Line(x1, y, x2, y);
            pane.getChildren().add(line);
            y += 40;
        }
    }

    private void drawShapes3(Pane pane) {
        int x1 = 90;
        int y = 20;
        int x2 = 110;
        while (y <= 180) {
            Line line = new Line(x1, y, x2, y);
            pane.getChildren().add(line);
            y += 40;
            x1 -= 20;
            x2 += 20;
        }
    }
}
