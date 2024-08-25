package com.example.demo.kafka;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Repository
public class UserStorage {
    private static final Map<Integer,User> users = new HashMap<>();

    static {
        for (int i = 0; i < 1_000; i++) {
            users.put(i, new User(i,"User_"+ i));
        }
    }

    public void notifyById(int id, String msg){
        if(users.containsKey(id))
            users.get(id).notify(msg);
    }

    public Set<Integer> getAllUsersIds(){
        return users.keySet();
    }
}
