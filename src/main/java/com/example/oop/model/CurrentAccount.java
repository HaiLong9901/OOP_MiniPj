package com.example.oop.model;

public class CurrentAccount extends Account{
    public CurrentAccount() {
    }

    public CurrentAccount(String number, float balance, String description, String account_title, String status, int bankCode) {
        super(number, balance, description, account_title, status, bankCode);
    }

    @Override
    public void viewAccount() {

    }
}
