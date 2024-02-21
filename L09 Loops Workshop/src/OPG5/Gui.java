package OPG5;

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

        stage.setTitle("Loops"); // may be changed
        stage.setScene(scene);
        stage.show();
    }

    private Pane initContent() {
        Pane pane = new Pane();
        pane.setPrefSize(200, 200); // may be changed
        this.drawText(pane);
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawText(Pane pane) {
        int x = 10;
        int y = 20;
        String str = "Datamatiker";
        int stringLength = str.length();
        int substringCounter = 1;
        while (substringCounter <= stringLength) {
            Text text = new Text(x, y, str.substring(0, substringCounter));
            pane.getChildren().add(text);
            substringCounter++;
            y += 15;
        }
    }
}
