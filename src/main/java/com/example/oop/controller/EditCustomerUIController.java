package com.example.oop.controller;

import com.example.oop.State;
import com.example.oop.model.Customer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EditCustomerUIController implements Initializable {
    @FXML
    private Button updateBtn;

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

    private CustomerController customerController = new CustomerController();

    public void editCustomer() {
        String name = nameInput.getText();
        String phone = phoneInput.getText();
        String email = emailInput.getText();
        String cardNo = cardInput.getText();
        String address = addressInput.getText();
        String userName = userNameInput.getText();
        customerController.editCustomer(State.searchCustomer.getId(), name, email, address, phone, userName, cardNo);
        updateBtn.getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (State.searchCustomer != null) {
            nameInput.setText(State.searchCustomer.getName());
            emailInput.setText(State.searchCustomer.getEmail());
            phoneInput.setText(State.searchCustomer.getPhoneNo());
            userNameInput.setText(State.searchCustomer.getUsername());
            cardInput.setText(State.searchCustomer.getCardNo());
            addressInput.setText(State.searchCustomer.getAddress());
        }
    }
}
