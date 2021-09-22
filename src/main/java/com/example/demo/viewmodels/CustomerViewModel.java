package com.example.demo.viewmodels;

import java.util.ArrayList;
import java.util.List;

public class CustomerViewModel {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private boolean isActive;
    private List<AccountViewModel> accounts = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<AccountViewModel> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountViewModel> accounts) {
        this.accounts = accounts;
    }
}
