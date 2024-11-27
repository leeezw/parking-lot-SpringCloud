package com.parking.member.service;

public interface MemberService {

    /**
     * 绑定手机号送积分
     * @param json
     * @return
     */
    int bindMobileUseRestTemplate(String json);
}
