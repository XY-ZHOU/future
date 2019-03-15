package main.java.company;

import main.java.company.model.CreditInformation;
import main.java.company.model.User;

import java.util.ArrayList;
import java.util.List;

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


    }
}
