package com.parking.card.controller;

import com.parking.card.mapper.MemberCardMapper;
import com.parking.card.service.MemberCardService;
import com.parking.common.exception.BusinessException;
import com.parking.common.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("card")
@Slf4j
public class MemberCardController {

    @Autowired
    private MemberCardService cardService;

    @RequestMapping(value = "/addCard", method = RequestMethod.POST)
    public CommonResult<Integer> addCard(String json) throws BusinessException {
        log.info("eclise service example: begin add member card = " + json);
        //log.info("jar service example: begin add member card = " + json);
        CommonResult<Integer> result = new CommonResult<>();
        int rtn = cardService.addMemberCard(json);
        result.setRespData(rtn);
        return result;
    }
}