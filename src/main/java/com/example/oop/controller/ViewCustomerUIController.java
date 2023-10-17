package com.example.oop.controller;

import com.example.oop.State;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewCustomerUIController implements Initializable {
    @FXML
    private Label addressLabel;

    @FXML
    private Label cardLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label idLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label phoneLabel;

    @FXML
    private Label usernameLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (State.searchCustomer != null) {
            nameLabel.setText(State.searchCustomer.getName());
            emailLabel.setText(State.searchCustomer.getEmail());
            phoneLabel.setText(State.searchCustomer.getPhoneNo());
            usernameLabel.setText(State.searchCustomer.getUsername());
            cardLabel.setText(State.searchCustomer.getCardNo());
            idLabel.setText(String.valueOf(State.searchCustomer.getId()));
            addressLabel.setText(State.searchCustomer.getAddress());
        }
    }
}
