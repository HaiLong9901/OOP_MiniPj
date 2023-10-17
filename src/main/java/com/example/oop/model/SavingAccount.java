package com.example.oop.model;

public class SavingAccount extends Account{
    private float interest;

    public SavingAccount() {
        super();
    }

    public SavingAccount(String number, float balance, String description, String account_title, String status, int bankCode, float interest) {
        super(number, balance, description, account_title, status, bankCode);
        this.interest = interest;
    }

    @Override
    public void viewAccount() {

    }

    public float calculateInterest() {
        return 0.5F;
    }
}
