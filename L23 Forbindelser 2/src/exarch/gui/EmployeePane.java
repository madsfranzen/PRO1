package exarch.gui;

import exarch.controller.Controller;
import exarch.model.Company;
import exarch.model.Employee;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Optional;

public class EmployeePane extends GridPane {

    private final ListView<Employee> lvwEmployees = new ListView<>();
    private TextField txfName = new TextField();
    private TextField txfCompany = new TextField();
    private TextField txfWage = new TextField();
    private TextField txfWeeklySalary = new TextField();
    private TextField txfEmploymentYear = new TextField();
    private Button btnCreate = new Button("Create");
    private Button btnUpdate = new Button("Update");
    private Button btnDelete = new Button("Delete");


    public EmployeePane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblEmp = new Label("Employees");
        this.add(lblEmp, 0, 0);


        Employee employee;

        Label lblName = new Label("Name");
        Label lblWage = new Label("Hourly Wage:");
        Label lblCompany = new Label("Company:");
        Label lblWeeklySalary = new Label("Weekly Salary");
        Label lblEmploymentYear = new Label("Employment Year:");
        VBox labelBox = new VBox(lblName, lblCompany, lblWage, lblWeeklySalary, lblEmploymentYear);
        labelBox.setSpacing(30);
        this.add(labelBox, 1, 1);

        VBox textVBox = new VBox(txfName, txfCompany, txfWage, txfWeeklySalary, txfEmploymentYear);
        textVBox.setSpacing(20);
        this.add(textVBox, 2, 1);

        HBox buttonBox = new HBox(btnCreate, btnUpdate, btnDelete);
        buttonBox.setSpacing(40);
        this.add(buttonBox, 0, 4, 3, 1);
        buttonBox.setPadding(new Insets(10, 0, 0, 0));
        buttonBox.setAlignment(Pos.BASELINE_CENTER);

        this.add(lvwEmployees, 0, 1, 1, 3);
        lvwEmployees.setPrefWidth(200);
        lvwEmployees.setPrefHeight(200);
        lvwEmployees.getItems().setAll(Controller.getEmployees());

        btnCreate.setOnAction(event -> createAction());
        btnDelete.setOnAction(event -> deleteAction());
        btnUpdate.setOnAction(event -> updateAction());
        btnDelete.setFocusTraversable(true);

        ChangeListener<Employee> listener = (ov, o, n) -> this.selectedEmployeeChanged();
        lvwEmployees.getSelectionModel().selectedItemProperty().addListener(listener);
    }

    private void selectedEmployeeChanged() {
        this.updateControls();
    }

    private void updateAction() {
        Employee employee = lvwEmployees.getSelectionModel().getSelectedItem();
        if (employee == null)
            return;

        EmployeeWindow dialog = new EmployeeWindow("Update Employee", employee);
        dialog.showAndWait();

        // Wait for the modal dialog to close

        int selectIndex = lvwEmployees.getSelectionModel().getSelectedIndex();
        lvwEmployees.getItems().setAll(Controller.getEmployees());
        lvwEmployees.getSelectionModel().select(selectIndex);
    }

    private void deleteAction() {
        Employee employee = lvwEmployees.getSelectionModel().getSelectedItem();


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(this.getScene().getWindow());
        alert.setTitle("Delete Employee");
        alert.setHeaderText("Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();

        // wait for the modal dialog to close

        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            Controller.deleteEmployee(employee);
            Controller.removeEmployeeFromCompany(employee, employee.getCompany());
            lvwEmployees.getItems().setAll(Controller.getEmployees());
            int index = lvwEmployees.getItems().size() - 1;
            lvwEmployees.getSelectionModel().select(index);
        }
    }

    private void createAction() {
        Employee employee = null;
        EmployeeWindow dialog = new EmployeeWindow("Create Employee", employee);
        dialog.showAndWait();


        lvwEmployees.getItems().setAll(Controller.getEmployees());
        int index = lvwEmployees.getItems().size() - 1;
        lvwEmployees.getSelectionModel().select(index);
    }

    private void updateControls() {
        Employee employee = lvwEmployees.getSelectionModel().getSelectedItem();

        if (employee == null) {
            return;
        }
        txfName.setText(employee.getName());
        txfWage.setText(String.valueOf(employee.getWage()));
        if (employee.getCompany() == null) {
            txfCompany.setText("");
            txfWeeklySalary.setText("");
            txfEmploymentYear.setText("");
        } else {
            txfCompany.setText(employee.getCompany().toString());
            txfWeeklySalary.setText(String.valueOf(employee.getWeeklySalary()));
            txfEmploymentYear.setText(String.valueOf(employee.getEmploymentYear()));
        }
    }
}
