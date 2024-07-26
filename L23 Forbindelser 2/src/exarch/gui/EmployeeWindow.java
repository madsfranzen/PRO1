package exarch.gui;

import exarch.controller.Controller;
import exarch.model.Company;
import exarch.model.Employee;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class EmployeeWindow extends Stage {

    private final Label lblError = new Label();
    Employee employee;
    private TextField txfName = new TextField();
    private TextField txfWage = new TextField();
    private TextField txfEmploymentYear = new TextField();
    private CheckBox chbCompany = new CheckBox("Company");
    private ComboBox drpCompany = new ComboBox<Company>();

    public EmployeeWindow(String title, Employee employee) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);
        this.employee = employee;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);

    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);

        pane.add(txfName, 0, 1);
        txfName.setPrefWidth(200);

        Label lblHours = new Label("Hourly Wage:");
        pane.add(lblHours, 0, 2);

        pane.add(txfWage, 0, 3);

        Label lblEmploymentYear = new Label("Employment Year:");
        pane.add(lblEmploymentYear, 0, 6);
        pane.add(txfEmploymentYear, 0, 7);
        txfEmploymentYear.setDisable(true);

        pane.add(chbCompany, 0, 4);
        pane.add(drpCompany, 0, 5);
        drpCompany.getItems().addAll(Controller.getCompanies());
        drpCompany.setPromptText("Select Company");
        drpCompany.setDisable(true);

        chbCompany.setOnAction(event -> checkBoxAction());

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 8);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 8);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());

        pane.add(lblError, 0, 9);
        lblError.setStyle("-fx-text-fill: red");

        if (employee != null) {
            txfName.setText(employee.getName());
            txfWage.setText(String.valueOf(employee.getWage()));
            if (employee.getCompany() != null) {
                chbCompany.setSelected(true);
                drpCompany.getSelectionModel().select(employee.getCompany());
                drpCompany.setDisable(false);
                txfEmploymentYear.setDisable(false);
            } else chbCompany.setSelected(false);
        }
    }
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------

    private void checkBoxAction() {
        if (chbCompany.isSelected()) {
            drpCompany.setDisable(false);
            txfEmploymentYear.setDisable(false);
        } else if (!chbCompany.isSelected()) {
            drpCompany.setDisable(true);
            txfEmploymentYear.setDisable(true);
        }
    }

    private void cancelAction() {
        this.hide();
    }


    private void okAction() {
        String name = txfName.getText().trim();
        if (name.length() == 0) {
            lblError.setText("Name is empty");
            return;
        }

        int wage = -1;
        try {
            wage = Integer.parseInt(txfWage.getText().trim());
        } catch (NumberFormatException ex) {
            // do nothing
        }
        if (wage < 0) {
            lblError.setText("Wage is not a positive number");
            return;

        }
        if (employee != null) {
            Company company = Controller.getCompanies().get(drpCompany.getSelectionModel().getSelectedIndex());
            Controller.updateEmployee(employee, txfName.getText(), Integer.parseInt(txfWage.getText()));
            if (chbCompany.isSelected()) {
                Controller.removeEmployeeFromCompany(employee, employee.getCompany());
                Controller.addEmployeeToCompany(employee, company);
            } else Controller.removeEmployeeFromCompany(employee, employee.getCompany());
        } else
            // create new employee
            if (chbCompany.isSelected()) {
                Company company = Controller.getCompanies().get(drpCompany.getSelectionModel().getSelectedIndex());
                Controller.createEmployee(name, wage, company, Integer.parseInt(txfEmploymentYear.getText()));
            } else Controller.createEmployee(name, wage, null, -1);

        this.hide();
    }
}
