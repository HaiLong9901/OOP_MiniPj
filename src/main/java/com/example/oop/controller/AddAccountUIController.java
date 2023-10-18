package com.example.oop.controller;

import com.example.oop.AppController;
import com.example.oop.State;
import com.example.oop.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Function;
import java.util.stream.Stream;

public class AddAccountUIController implements Initializable {
    @FXML
    private Button addBtn;

    @FXML
    private TextField bankAddressInput;

    @FXML
    private TextField bankCodeInput;

    @FXML
    private TextField bankNameInput;

    @FXML
    private TextField descInput;

    @FXML
    private TextField numberInput;

    @FXML
    private TextField statusInput;

    @FXML
    private TextField titInput;

    @FXML
    private ComboBox<String> typeBox;

    @FXML
    private ComboBox<Customer> userIdBox;
    @FXML
    private TextField interestInput;

    private ObservableList<String> typeList = FXCollections.observableArrayList("saving", "current");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        typeBox.setItems(typeList);
        ObservableList<Customer> customerIds = FXCollections.observableArrayList(CustomerController.CustomerList);
        userIdBox.setItems(customerIds);
    }

    public void addAccount() {
        String number = numberInput.getText();
        String desc = descInput.getText();
        String type = typeBox.getValue();
        int userId = userIdBox.getValue().getId();
        String title = titInput.getText();
        String status = statusInput.getText();
        int bankCode = Integer.parseInt(bankCodeInput.getText());
        String bankName = bankNameInput.getText();
        String bankAddress = bankAddressInput.getText();
        if (type.equals("saving")) {
            Account savingAccount = new SavingAccount(number, desc, title, status, bankCode, userId, Float.valueOf(interestInput.getText()));
            AccountController.accountList.add(savingAccount);
        } else {
            Account currentAccount = new CurrentAccount(number, desc, title, status, bankCode, userId);
            AccountController.accountList.add(currentAccount);
        }
        Bank bank = new Bank(bankCode, bankName, bankAddress);
        AccountController.bankList.add(bank);
        System.out.println(AccountController.accountList.size());
        addBtn.getScene().getWindow().hide();
    }
}
