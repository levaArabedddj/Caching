package com.example.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class KafkaConsumer {
    @Autowired
    private UserStorage userStorage;

    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    @KafkaListener(topics = KafkaCfg.CLIENT_NOTIFICATIONS)
    public void listen(String msg){
        String [] split = msg.split("\\^");
        String userId = split[0];
        String userMsg= split[1];

        executorService.submit(()->{userStorage.notifyById(Integer.parseInt(userId),userMsg);});
    }
}
