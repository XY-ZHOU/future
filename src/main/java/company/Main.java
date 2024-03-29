package main.java.company;

import main.java.company.model.CreditInformation;
import main.java.company.model.User;
import main.java.company.service.BankService;
import main.java.company.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) throws Exception {
        User userOne = new User("1", "张三");
        User userTwo = new User("2", "李四");
        User userThree = new User("3", "王五");
        List<User> userList = new ArrayList<>();
        userList.add(userOne);
        userList.add(userTwo);
        userList.add(userThree);

        List<CreditInformation> bankMessageList = new ArrayList<>();
        bankMessageList.add(new CreditInformation(userOne, "123", "农行", 100.00));
        bankMessageList.add(new CreditInformation(userTwo, "234", "建行", 500.00));

        double moneyOne = getMoneyByUser(userList, bankMessageList, "1");
        double moneyTwo = getMoneyByUser(userList, bankMessageList, "2");
        System.out.println("李四和张三共有" + calculateMoney(moneyOne, moneyTwo) + "钱");

    }

    public static CompletableFuture<User> getUsersMessage(List<User> userList, String userId) {
        return CompletableFuture.supplyAsync(() -> {
            UserService userService = new UserService();
            return userService.getUserMessage(userList, userId);
        });
    }

    public static CompletableFuture<Double> getMoneyOfCredit(List<CreditInformation> bankMessageList, User user) {
        return CompletableFuture.supplyAsync(() -> {
            BankService bankService = new BankService();
            return bankService.getCreditMoney(bankMessageList, user);
        });
    }

    public static double getMoneyByUser(List<User> userList, List<CreditInformation> bankMessageList, String userId) {
        CompletableFuture<Double> result = getUsersMessage(userList, userId)
                .thenCompose(user -> getMoneyOfCredit(bankMessageList, user));
        return result.join().doubleValue();
    }

    public static double calculateMoney(double moneyOne, double moneyTwo) {
        return moneyOne + moneyTwo;
    }
}
