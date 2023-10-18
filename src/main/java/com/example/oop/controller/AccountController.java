package com.example.oop.controller;

import com.example.oop.model.Account;
import com.example.oop.model.Bank;

import java.util.ArrayList;
import java.util.List;

public class AccountController {
    public static List<Account> accountList= new ArrayList<Account>();
    public static List<Bank> bankList = new ArrayList<Bank>();

    public void addAccount(Account account) {
        accountList.add(account);
    }
    public void removeAccount(String number) {
        int idx = -1;
        for (int i = 0; i < accountList.size(); ++i) {
            if (accountList.get(i).getNumber().equals(number)) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            return;
        }
        accountList.remove(idx);
    }

    public int deposit(String num, float amount) {
        int idx = -1;
        for (int i = 0; i < accountList.size(); ++i) {
            if (accountList.get(i).getNumber().equals(num)) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            return -1;
        }
        Account account = accountList.get(idx);
        account.setBalance(account.getBalance() + amount);
        accountList.remove(idx);
        accountList.add(account);
        return 1;
    }

    public int withdraw(String num, float amount) {
        int idx = -1;
        for (int i = 0; i < accountList.size(); ++i) {
            if (accountList.get(i).getNumber().equals(num)) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            return -1;
        }
        Account account = accountList.get(idx);
        if (account.getBalance() < amount) {
            return 0;
        }
        account.setBalance(account.getBalance() - amount);
        accountList.remove(idx);
        accountList.add(account);
        return 1;
    }
}
