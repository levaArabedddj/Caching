package com.example.demo.redis;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class Controller {

    @Autowired
    private AuthService authService;

//    @Autowired
//    private RedisConnector redisConnector;

//    @PostMapping("/login")
//    public String login(@RequestBody User user){
//        boolean auth = authService.isAuth(user);
//        if(!auth)
//            throw new NotFoundUserException();
//
//        return redisConnector.put(user.getUsername());
//    }
//
//    @PostMapping("/logout")
//    public void logout(@RequestBody String sessionId){
//
//        redisConnector.remove(sessionId);
//    }
//
//    @GetMapping("/info")
//    public String info(@RequestHeader("auth") String sessionId){
//
//        boolean auth = redisConnector.isAuth(sessionId);
//        if(!auth)
//            throw new NotAuthException();
//
//         return "usefully packet";
//    }


}
