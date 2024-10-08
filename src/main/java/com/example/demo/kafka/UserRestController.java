package com.example.demo.kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class UserRestController {


    @Autowired
    private KafkaTemplate<String, String>kafkaTemplate;
    @Autowired
    private  UserStorage userStorage;

    @GetMapping("/notify")
    public void notifyUsers(@RequestParam("msg") String msg){
        Set<Integer> allUserIds = userStorage.getAllUsersIds();
        allUserIds.forEach(id->
            kafkaTemplate.send(KafkaCfg.CLIENT_NOTIFICATIONS,id +"^"+msg));
    }
}
