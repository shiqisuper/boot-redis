package com.guotian.controller;


import com.guotian.entity.Member;
import com.guotian.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@Slf4j
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;



    @Cacheable(cacheNames = "member", key = "'findMemberAll'")
    @RequestMapping("/getListMember")
    public List<Member> getListMember(){
        List<Member> all = memberService.getAll();
        log.info("查询数据"+all);
        return all;
    }




}
