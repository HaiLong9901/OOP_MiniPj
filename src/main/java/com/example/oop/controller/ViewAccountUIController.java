package com.example.oop.controller;

import com.example.oop.State;
import com.example.oop.model.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewAccountUIController implements Initializable {
    @FXML
    private Label addressLabel;

    @FXML
    private Label balanceLable;

    @FXML
    private Label bankCodeLabel;

    @FXML
    private Label bankLabel;

    @FXML
    private Label cusLabel;

    @FXML
    private Label descLabel;

    @FXML
    private Label interestLabel;

    @FXML
    private Label numLabel;

    @FXML
    private Label stsLabel;

    @FXML
    private Label titLabel;

    @FXML
    private Label typeLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (State.searchAcc != null) {
            Account acc = State.searchAcc;
            numLabel.setText(acc.getNumber());
            titLabel.setText(acc.getAccount_title());
            stsLabel.setText(acc.getStatus());
            balanceLable.setText(String.valueOf(acc.getBalance()));
            descLabel.setText(acc.getDescription());
            if (acc instanceof SavingAccount) {
                SavingAccount savingAccount = (SavingAccount) acc;
                interestLabel.setText(String.valueOf(savingAccount.getInterest()));
                typeLabel.setText("Saving");
            } else {
                typeLabel.setText("Current");
            }

            for (Bank bank: AccountController.bankList) {
                if (bank.getCode() == acc.getBankCode()) {
                    bankLabel.setText(bank.getName());
                    addressLabel.setText(bank.getAddress());
                    bankCodeLabel.setText(String.valueOf(bank.getCode()));
                }
            }

            for (Customer customer: CustomerController.CustomerList) {
                if (customer.getId() == acc.getCustomerId()) {
                    cusLabel.setText(customer.getUsername());
                }
            }
        }
    }
}
