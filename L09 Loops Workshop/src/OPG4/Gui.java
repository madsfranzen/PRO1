package OPG4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("OPG 4"); // may be changed
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
        int x = 100; // center: (x,y)
        int y = 100;
        int r = 20; // radius: r
        while (r <= 100) {
            Circle circle = new Circle(x, y, r);
            circle.setStroke(Color.BLACK);
            circle.setFill(null);
            pane.getChildren().add(circle);
            r += 20;
        }
    }

    private void drawShapes2(Pane pane) {
        int x = 20; // center: (x,y)
        int y = 100;
        int r = 10; // radius: r
        while (r <= 80) {
            Circle circle = new Circle(x, y, r);
            circle.setStroke(Color.BLACK);
            circle.setFill(null);
            pane.getChildren().add(circle);
            r += 10;
            x += 10;
        }
    }

    private void drawShapes3(Pane pane) {
        int x = 100;
        int y = 100;
        int xRadius = 20;
        int yRadius = 40;
        while (xRadius <= 90) {
            Ellipse ellipse = new Ellipse(x, y, xRadius, yRadius);
            ellipse.setStroke(Color.BLACK);
            ellipse.setFill(null);
            pane.getChildren().add(ellipse);
            xRadius += 10;
        }
    }
}
