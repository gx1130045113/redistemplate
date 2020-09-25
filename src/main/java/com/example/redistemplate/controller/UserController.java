package com.example.redistemplate.controller;

import com.example.redistemplate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description: TODO
 * @Author 有丶优秀的少年
 * @Date 2020/9/24
 * @Version V1.0
 **/
@RestController
public class UserController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/redis/user")
    public User user() {
        User user = new User();
        user.setId(1);
        user.setName("gaoxiang1");
        redisTemplate.opsForValue().set("2", user);

        //  stringRedisTemplate.opsForValue().set("1","gaoxiang");

        System.out.println("查询数据库数据");
        // return stringRedisTemplate.opsForValue().get("1");
        return (User) redisTemplate.opsForValue().get("2");
    }

    @GetMapping("/redisList")
    public String redisList() {
        String key="redis-list-key";
        String value= String.valueOf(System.currentTimeMillis()+1);
        stringRedisTemplate.opsForList().leftPush(key,value);
        stringRedisTemplate.opsForList().leftPush(key,value+1);
        stringRedisTemplate.opsForList().leftPush(key,value+2);
        return stringRedisTemplate.opsForList().leftPop(key);
    }

}
