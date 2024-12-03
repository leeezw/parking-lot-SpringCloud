package com.parking.member.controller;

import com.parking.common.exception.BusinessException;
import com.parking.common.result.CommonResult;
import com.parking.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("member")
@Slf4j
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/bindMobileUseRestTemplate", method = RequestMethod.POST)
    public CommonResult<Integer> bindMobileUseRestTemplate(String json) throws BusinessException {
        CommonResult<Integer> result = new CommonResult<>();
        log.info("bind mobile param = " + json);
        int rtn = memberService.bindMobileUseRestTemplate(json);
        result.setRespData(rtn);
        return result;
    }

    @RequestMapping(value = "/bindMobile", method = RequestMethod.POST)
    public CommonResult<Integer> bindMobile(String json) throws BusinessException{
        CommonResult<Integer> result = new CommonResult<>();
        log.info("bind mobile param = " + json);
        int rtn = memberService.bindMobile(json);
        result.setRespData(rtn);
        return result;
    }



}