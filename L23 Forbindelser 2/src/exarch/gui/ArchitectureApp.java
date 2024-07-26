package exarch.gui;

import exarch.controller.Controller;
import exarch.model.Company;
import exarch.model.Customer;
import exarch.model.Employee;
import exarch.storage.Storage;
import javafx.application.Application;

public class ArchitectureApp {

    public static void main(String[] args) {
        initStorage();
        Application.launch(ArchitectureGui.class);
    }

    public static void initStorage() {
        Company ibm = Controller.createCompany("IBM", 37);
        Company amd = Controller.createCompany("AMD", 40);
        Company sled = Controller.createCompany("SLED", 45);
        Controller.createCompany("Vector", 32);

        Employee martin = Controller.createEmployee("Martin", 500, ibm, 2000);
        Employee hanne = Controller.createEmployee("Hanne", 450, ibm, 1995);
        Employee john = Controller.createEmployee("John", 250, amd, 2012);
        Employee jenny = Controller.createEmployee("Jenny", 750, null, -1);

        Customer hannah = Controller.createCustomer("Hannah");
        Customer johnny = Controller.createCustomer("Johnny");
        Controller.addCustomerToCompany(ibm, johnny);
        Controller.addCustomerToCompany(amd, hannah);

    }
}
