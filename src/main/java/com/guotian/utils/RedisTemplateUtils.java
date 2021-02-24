package com.guotian.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisTemplateUtils {

    @Resource
    public RedisTemplate<String ,Object> redisTemplate;

    public void setObject(String key ,Object value){
        setObject(key,value,null);
    }

    public void setObject(String key ,Object value,Long timeOut){
        redisTemplate.opsForValue().set(key,value);
        if (timeOut != null){
            redisTemplate.expire(key,timeOut, TimeUnit.SECONDS);
        }
    }

    public Object getObject(String key){
        return redisTemplate.opsForValue().get(key);
    }

}
