package com.parking.member.service;

import com.parking.common.exception.BusinessException;
import com.parking.common.model.Member;
import com.parking.common.model.MemberCard;
import com.parking.common.result.CommonResult;
import com.parking.common.utils.GlobalIdGenerator;
import com.parking.common.utils.JsonUtils;
import com.parking.member.client.MemberCardClient;
import com.parking.member.mapper.MemberMapper;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.logging.Logger;

@Service
public class MemberServiceImpl implements MemberService {

    private static final Logger logger = Logger.getLogger(MemberServiceImpl.class.getName());

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private MemberCardClient memberCardClient;

    @Override
    public int bindMobileUseRestTemplate(String json) throws BusinessException {
        Member member = JsonUtils.fromJson(json, Member.class);
        member.setId(GlobalIdGenerator.generateSnowflakeId());
        member.setCreateDate(new Date());
        member.setUpdateDate(new Date());
        int rtn = memberMapper.insert(member);
        // invoke another service
        if (rtn > 0) {
            MemberCard card = new MemberCard();
            card.setId(GlobalIdGenerator.generateSnowflakeId());
            card.setCreateDate(new Date());
            card.setUpdateDate(new Date());
            card.setMemberId(member.getId());
            card.setCurQty("50");

            MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<String, String>();
            requestMap.add("json", JsonUtils.toJson(card));
            HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(
                    requestMap, null);

            String jsonResult = restTemplate.postForObject("http://localhost:8603/card/addCard", requestEntity,
                    String.class);

            logger.info("creata member card suc!" + jsonResult);
        }

        return rtn;
    }

    @Override
    public int bindMobile(String json) {
        Member member = JsonUtils.fromJson(json, Member.class);
        member.setId(GlobalIdGenerator.generateSnowflakeId());
        member.setCreateDate(new Date());
        member.setUpdateDate(new Date());
        int rtn = 1;
//        int rtn = memberMapper.insert(member);
        // invoke another service
        if (rtn > 0) {
            MemberCard card = new MemberCard();
            card.setId(GlobalIdGenerator.generateSnowflakeId());
            card.setCreateDate(new Date());
            card.setUpdateDate(new Date());
            card.setMemberId(member.getId());
            card.setCurQty("50");
            CommonResult<Integer> jsonResult = memberCardClient.addCard(JsonUtils.toJson(card));

            logger.info("creata member card suc!" + jsonResult);
        }

        return rtn;
    }


}
