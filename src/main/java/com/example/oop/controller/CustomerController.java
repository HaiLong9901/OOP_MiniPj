package com.example.oop.controller;

import com.example.oop.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    public static List<Customer> CustomerList = new ArrayList<>();

    public void addCustomer(Customer customer) {
        CustomerList.add(customer);
    }
    public void editCustomer(Customer customer) {

    }
    public void removeCustomer(int id) {
        int idx = -1;
        for (int i = 0; i < CustomerList.size(); ++i) {
            if (CustomerList.get(i).getId() == id) {

            }
        }
        if (idx == -1) {
            return;
        }
        CustomerList.remove(idx);
    }
    public void searchCustomer(String phone) {

    }
}
