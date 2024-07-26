package exarch.controller;

import exarch.model.Company;
import exarch.model.Customer;
import exarch.model.Employee;
import exarch.storage.Storage;

import java.util.ArrayList;

public abstract class Controller {

    /**
     * Create a new Company.
     * Pre: name not empty, hours >= 0.
     */
    public static Company createCompany(String name, int hours) {
        Company company = new Company(name, hours);
        Storage.storeCompany(company);
        return company;
    }

    /**
     * Delete the company.
     * Pre: The company has no employees.
     */
    public static void deleteCompany(Company company) {
        Storage.deleteCompany(company);
    }

    public static void deleteEmployee(Employee employee) {
        Storage.deleteEmployee(employee);
    }

    /**
     * Update the company.
     * Pre: name not empty, hours >= 0.
     */
    public static void updateCompany(Company company, String name, int hours) {
        company.setName(name);
        company.setHours(hours);
    }

    public static void updateEmployee(Employee employee, String name, int wage) {
        employee.setName(name);
        employee.setWage(wage);
    }

    public static ArrayList<Company> getCompanies() {
        return Storage.getCompanies();
    }

    public static Employee createEmployee(String name, int wage, Company company, int employmentYear) {
        Employee employee = new Employee(name, wage, company, employmentYear);
        Storage.storeEmployee(employee);
        if (company != null) {
            addEmployeeToCompany(employee, company);
        }
        return employee;
    }

    public static ArrayList<Employee> getEmployees() {
        return Storage.getEmployees();
    }

    public static void addEmployeeToCompany(Employee employee, Company company) {
        if (employee.getCompany() != null) {
            removeEmployeeFromCompany(employee, employee.getCompany());
        }
        employee.setCompany(company);
        company.addEmployee(employee);
    }

    public static void removeEmployeeFromCompany(Employee employee, Company company) {
        company.removeEmployee(employee);
        employee.setCompany(null);
    }

    public static Customer createCustomer(String name) {
        Customer customer = new Customer(name);
        Storage.storeCustomer(customer);
        return customer;
    }

    public static void addCustomerToCompany(Company company, Customer customer) {
        company.addCustomer(customer);
        customer.setCompany(company);
    }

}
