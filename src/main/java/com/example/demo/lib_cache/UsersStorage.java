package com.example.demo.lib_cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersStorage {
    private List<Users> usersList = new ArrayList<>();
    private static int idCount = 0;

    {
        usersList.add(new Users(idCount++, "Petro"));
        usersList.add(new Users(idCount++, "Vlad"));
        usersList.add(new Users(idCount++, "Anatoliy"));
    }

    @CacheEvict(value = "users", key="'userList'")
    @CachePut(value = "users", key = "#user.id")
    public Users create(Users user){
        System.out.println("create");
        usersList.add(user);
        return user;
    }

    public int emit(){
        return idCount++;
    }

    @CacheEvict(value = "users", key="'userList'")
    @CachePut(value = "users", key = "#id")
    public Users update(int id, String name){
        System.out.println("update");
        Users updateUser = usersList.stream()
                .filter(users -> users.getId() == id)
                .findFirst().orElseThrow();
        updateUser.setName(name);
        return updateUser;
    }

    @Caching(evict = {
            @CacheEvict(value = "users", key="'userList'"),
            @CacheEvict(value = "users", key="#id")
    })
    public void delete(int id){
        System.out.println("delete");
        Users deleteUser = usersList.stream()
                .filter(users -> users.getId() == id)
                .findFirst().orElseThrow();
        usersList.remove(deleteUser);
    }

    @Cacheable(value = "users", key = "#id")
    public Users read(int id){
        System.out.println("read");
        return usersList.stream()
                .filter(users -> users.getId() == id)
                .findFirst().orElseThrow();
    }

    @Cacheable(value = "users", key="'userList'")
    public List<Users> searchListUsers(){
        System.out.println("readList");
        return usersList;
    }
}
