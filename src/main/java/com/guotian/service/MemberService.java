package com.guotian.service;

import com.guotian.entity.Member;

import java.util.List;


public interface MemberService {

    List<Member> getAll();

    boolean getHash();

}
