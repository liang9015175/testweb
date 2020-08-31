package com.panghusong.spider.web.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author panghusong
 * @date 2020/8/27
 * @description
 */
@Controller
@RequestMapping("/api/spider")
public class LoginController {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @ResponseBody
    @PostMapping("/login")
    public ResponseEntity login(String username, String password) throws InterruptedException {
        //mock 成功
        Thread.sleep(1000);
        //放入到redis中
        String token = UUID.randomUUID().toString().replace("-", "");
        //redis
        redisTemplate.opsForValue().set(token, JSON.toJSONString(new SpiderUser(1000L,"panghusong","1234")));
        redisTemplate.expire(token,24, TimeUnit.HOURS);
        return ResponseEntity.<String>ok(token);
    }
    @RequestMapping("/loginPage")
    public String loginPage(){
        return "login";
    }
    @ResponseBody
    @GetMapping("/auth/getUser")
    public String getUser(){
        return "songliang";
    }
}
