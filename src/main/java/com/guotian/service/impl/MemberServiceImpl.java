package com.guotian.service.impl;

import com.guotian.entity.Member;
import com.guotian.mapper.MemberMapper;
import com.guotian.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberMapper memberMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<Member> getAll() {
        return memberMapper.findMemberAll();
    }

    @Override
    public boolean getHash() {
        BoundHashOperations shiqi = redisTemplate.boundHashOps("shiqi");
        shiqi.put("age",24);
        shiqi.put("hight",183);
        System.out.println(shiqi.getKey()+"=========="+shiqi.get("age"));
        return true;
    }


}
