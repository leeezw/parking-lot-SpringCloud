package com.parking.member.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("member")
@Slf4j
public class MemberController {

//    @Autowired
//    MemberService memberService;

    @RequestMapping("/list")
    public String list() {
//        List<Member> members = memberService.list();
        String str = "query member list HELLO WORLD";
        log.debug(str);
        return str;
    }

}