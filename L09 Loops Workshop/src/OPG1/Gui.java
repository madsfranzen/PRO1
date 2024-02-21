package OPG1;

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

        stage.setTitle("Loops"); // may be changed
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

        int length = 20;
        int height = 8;
        // draw an arrowhead at (50,30)
        int x = 100;
        int y = 75;
        Line line1 = new Line(x, y, x + length, y - height);
        Line line2 = new Line(x, y, x + length, y + height);
        pane.getChildren().addAll(line1, line2);
        // draw an arrowhead at (25,140)
        x = 100;
        y = 125;
        Line line3 = new Line(x, y, x + length, y - height);
        Line line4 = new Line(x, y, x + length, y + height);
        pane.getChildren().addAll(line3, line4);
        // third arrowhead
        x = 20;
        y = 50;
        Line line5 = new Line(x, y, x + length, y - height);
        Line line6 = new Line(x, y, x + length, y + height);
        pane.getChildren().addAll(line5, line6);
    }

}
