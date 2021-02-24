package com.guotian.mapper;

import com.guotian.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


import java.util.List;

@Mapper
public interface MemberMapper {

    List<Member> findMemberAll();

    int addMember(@Param("member") Member member);
}
