package EX3ekstra.GUI;

import EX3ekstra.Controller;
import EX3ekstra.NewsFlash;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class NewsflashGUI extends Application {

    private final ListView<NewsFlash> lvwHeadings = new ListView<>();
    private final TextArea txaContent = new TextArea();
    private final Button btnAdd = new Button("Add");
    private final Button btnDelete = new Button("Delete");
    private final Button btnUpdate = new Button("Update");

    public void start(Stage stage) {
        stage.setTitle("Academy Xpress");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblTitle = new Label("The Academy Xpress");
        final double MAX_FONT_SIZE = 50.0;
        lblTitle.setFont(new Font(MAX_FONT_SIZE));
        HBox titleBox = new HBox();
        titleBox.getChildren().add(lblTitle);
        pane.add(titleBox, 0, 0, 2, 1);

        Label lblHeadings = new Label("Headings:");
        pane.add(lblHeadings, 0, 1);

        pane.add(lvwHeadings, 0, 2);
        lvwHeadings.setMaxSize(250, 400);

        ChangeListener<NewsFlash> listener = (ov, o, n) -> this.selectedHeadingChanged();
        lvwHeadings.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblContent = new Label("Content:");
        pane.add(lblContent, 1, 1);

        pane.add(txaContent, 1, 2);
        txaContent.setMinSize(400, 200);

        HBox btnBox = new HBox();
        btnBox.getChildren().addAll(btnAdd, btnDelete, btnUpdate);
        pane.add(btnBox, 0, 3, 2, 1);
        btnBox.setSpacing(75);
        btnBox.setAlignment(Pos.CENTER);
        btnBox.setPadding(new Insets(20));

        this.updateContent();
    }

    private void selectedHeadingChanged() {
        this.updateContent();
    }

    public void updateContent() {
        NewsFlash newsFlash = lvwHeadings.getSelectionModel().getSelectedItem();
        lvwHeadings.getItems().setAll(Controller.getAllHeadings());
    }

}