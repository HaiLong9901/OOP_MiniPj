package com.example.oop.controller;

import com.example.oop.model.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddCustomerUIController {
    @FXML
    private Button addBtn;

    @FXML
    private TextField addressInput;

    @FXML
    private TextField cardInput;

    @FXML
    private TextField emailInput;

    @FXML
    private TextField nameInput;

    @FXML
    private TextField phoneInput;

    @FXML
    private TextField userNameInput;

    public void addCustomerToList() {
        String name = nameInput.getText();
        String phone = phoneInput.getText();
        String email = emailInput.getText();
        String cardNo = cardInput.getText();
        String address = addressInput.getText();
        String userName = userNameInput.getText();
        Customer customer = new Customer(name, email, phone, userName, address, cardNo);
        CustomerController.CustomerList.add(customer);
        addBtn.getScene().getWindow().hide();
    }
}
