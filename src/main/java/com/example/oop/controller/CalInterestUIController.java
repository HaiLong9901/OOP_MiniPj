package com.example.oop.controller;

import com.example.oop.State;
import com.example.oop.model.SavingAccount;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CalInterestUIController implements Initializable {
    @FXML
    private Label text;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (State.searchAcc instanceof SavingAccount) {
            SavingAccount acc = (SavingAccount) State.searchAcc;
            float rs = acc.getInterest() / 100 * acc.getBalance();
            text.setText("Account interest is: " + String.valueOf(rs));
        } else {
            text.setText("This account is not saving account");
        }
    }
}
