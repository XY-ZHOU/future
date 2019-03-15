package main.java.company.service;

import main.java.company.model.User;

import java.util.List;

public class UserService {
    public User getUserMessage(List<User> userList, String userId) {
        return userList.stream().filter(user -> user.getUserId().equals(userId)).findAny().orElse(null);
    }
}
