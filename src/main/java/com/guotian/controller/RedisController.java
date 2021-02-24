package com.guotian.controller;


import com.alibaba.fastjson.JSONObject;
import com.guotian.entity.UserEntity;
import com.guotian.service.MemberService;
import com.guotian.utils.RedisTemplateUtils;
import com.guotian.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RedisController {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private MemberService service;

    @Autowired
    private RedisTemplateUtils redisTemplateUtils;

//    @GetMapping("/addUser")
//    public  String addUser(UserEntity userEntity){
//        // 将对象转换为json
//        String json = JSONObject.toJSONString(userEntity);
//        redisUtils.setString("userEntity",json);
//        log.info("向redis中插入值"+json);
//
//        return "存储成功~";
//    }
//
//    @RequestMapping("/getUser")
//    public  UserEntity getUser(String key){
//        String string = redisUtils.getString(key);
//        UserEntity userEntity = JSONObject.parseObject(string, UserEntity.class);
//        log.info("redis中获取值");
//        return userEntity;
//
//    }
        @GetMapping("/addUser")
        public  String addUser(UserEntity userEntity){
            redisTemplateUtils.setObject("userEntity",userEntity);
            return "存储成功~";
        }

        @RequestMapping("/getUser")
        public  UserEntity getUser(String key){

            return (UserEntity) redisTemplateUtils.getObject(key);
        }

        @RequestMapping("/getHash")
        public  boolean add(String key){

            return service.getHash();
        }
}
