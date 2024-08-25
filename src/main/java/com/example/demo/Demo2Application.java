package com.example.demo;

import com.example.demo.lib_cache.Users;
import com.example.demo.lib_cache.UsersStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
@EnableCaching
public class Demo2Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Demo2Application.class, args);
        UsersStorage usersStorage = context.getBean("usersStorage", UsersStorage.class);

//        System.out.println(usersStorage.searchListUsers());
//        System.out.println(usersStorage.searchListUsers());
//        System.out.println(usersStorage.searchListUsers());
//
//        System.out.println(usersStorage.read(0));
//        System.out.println(usersStorage.read(0));
//
//        usersStorage.create(new Users(usersStorage.emit(), "Vanya"));
//        System.out.println(usersStorage.searchListUsers());
//        System.out.println(usersStorage.searchListUsers());
//
//        usersStorage.update(3, "Victor");
//        System.out.println(usersStorage.read(3));
//        System.out.println(usersStorage.read(3));
//
//        System.out.println(usersStorage.searchListUsers());
//        System.out.println(usersStorage.searchListUsers());
//
//        usersStorage.delete(3);
//        System.out.println(usersStorage.read(3));
//        System.out.println(usersStorage.searchListUsers());
//        System.out.println(usersStorage.searchListUsers());
    }

}
