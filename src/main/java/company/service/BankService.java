package main.java.company.service;

import main.java.company.model.CreditInformation;
import main.java.company.model.User;

import java.util.List;

public class BankService {
    public double getCreditMoney(List<CreditInformation> bankMessageList, User user) {
        return bankMessageList.stream().filter(n -> n.getUser().equals(user)).findAny().orElse(null).getMoney();
    }
}
