package com.tjwq.demo.controller;

import com.tjwq.demo.domain.JsonData;
import com.tjwq.demo.utils.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/redis")
public class RedisController {

//    @Autowired
//    private StringRedisTemplate redisTpl;

    @Autowired
    private RedisClient redis;

    @GetMapping(value="add")
    public Object add(String key, String value){
        //redisTpl.opsForValue().set("name",name);
        boolean res = redis.set(key, value);
        return JsonData.buildSuccess(res);
    }

    @GetMapping(value="get")
    public Object get(String key){
        // String value = redisTpl.opsForValue().get("name");
        return JsonData.buildSuccess(redis.get(key));
    }
}
