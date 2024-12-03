package com.parking.member.client;

import com.parking.common.exception.BusinessException;
import com.parking.common.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "parking-card")
public interface MemberCardClient {

    @RequestMapping(value = "/card/addCard", method = RequestMethod.POST)
    public CommonResult<Integer> addCard(@RequestParam(value = "json") String json) throws BusinessException;

    @RequestMapping(value = "/card/updateCard", method = RequestMethod.POST)
    public CommonResult<Integer> updateCard(@RequestParam(value = "json") String json) throws BusinessException;
}
