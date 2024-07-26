package exarch.model;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Company> customerCompanies;

    public Customer(String name) {
        this.name = name;
        customerCompanies = new ArrayList<>();
    }

    public void setCompany(Company company) {
        customerCompanies.add(company);
    }

    public String getName() {
        return name;
    }
}
