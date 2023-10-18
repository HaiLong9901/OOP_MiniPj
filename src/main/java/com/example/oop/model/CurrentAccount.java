package com.example.oop.model;

public class CurrentAccount extends Account{
    public CurrentAccount() {
    }

    public CurrentAccount(String number, String description, String account_title, String status, int bankCode, int customerId) {
        super(number, description, account_title, status, bankCode, customerId);
    }

    @Override
    public void viewAccount() {

    }
}
