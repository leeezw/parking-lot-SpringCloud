package com.parking.member.client.callBack;

import com.parking.common.exception.BusinessException;
import com.parking.common.result.CommonResult;
import com.parking.member.client.MemberCardClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Component
public class MemberCardServiceFallback implements MemberCardClient {
    private static final Logger log = LoggerFactory.getLogger(MemberCardServiceFallback.class);
    public static CommonResult<Integer> addCardFallback(String json) throws BusinessException {
        CommonResult<Integer> result = new CommonResult<>();
        log.warn("parking - card service not available! Exception: {}");
        return result;
    }
    public static CommonResult<Integer> updateCardFallback(String json) throws BusinessException {
        CommonResult<Integer> result = new CommonResult<>();
        log.warn("parking - card service not available! Exception: {}");
        return result;
    }

    @Override
    public CommonResult<Integer> addCard(String json) throws BusinessException {
        CommonResult<Integer> result = new CommonResult<>();
        log.warn("parking - card service not available! Exception: {}");
        return result;
    }

    @Override
    public CommonResult<Integer> updateCard(String json) throws BusinessException {
        CommonResult<Integer> result = new CommonResult<>();
        log.warn("parking - card service not available! Exception: {}");
        return result;
    }
}

