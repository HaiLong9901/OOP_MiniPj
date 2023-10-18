package com.example.oop.controller;

import com.example.oop.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    public static List<Customer> CustomerList = new ArrayList<>();

    public void addCustomer(Customer customer) {
        CustomerList.add(customer);
    }
    public void editCustomer(int id, String name, String email, String address, String phone, String username, String card) {
        this.removeCustomer(id);
        Customer customer = new Customer(id, name, email, phone, username, address, card);
        CustomerList.add(customer);
    }
    public void removeCustomer(int id) {
        int idx = -1;
        for (int i = 0; i < CustomerList.size(); ++i) {
            if (CustomerList.get(i).getId() == id) {
                idx = i;
                break;
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
