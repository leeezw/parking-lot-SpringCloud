package com.parking.member.client;

import com.parking.common.exception.BusinessException;
import com.parking.common.result.CommonResult;
import com.parking.member.client.callBack.MemberCardServiceFallback;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "parking-card"
//        ,fallback = MemberCardServiceFallback.class
)
public interface MemberCardClient {

    @RequestMapping(value = "/card/addCard", method = RequestMethod.POST)
    @CircuitBreaker(name = "memberCardServiceCircuitBreaker", fallbackMethod = "MemberCardServiceFallback.addCard")
    public CommonResult<Integer> addCard(@RequestParam(value = "json") String json) throws BusinessException;

    @RequestMapping(value = "/card/updateCard", method = RequestMethod.POST)
    public CommonResult<Integer> updateCard(@RequestParam(value = "json") String json) throws BusinessException;
}
