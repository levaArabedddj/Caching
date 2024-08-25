package com.example.demo.redis;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {
    private final List<User> userList = new ArrayList<>();
    {
        userList.add(new User("user", "user"));
        userList.add(new User("users", "users"));
        userList.add(new User("admin", "admin"));
    }

    public boolean isAuth(User user){
        return userList.contains(user);
    }
}
