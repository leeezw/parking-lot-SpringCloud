package com.parking.card.service;

import com.parking.card.mapper.MemberCardMapper;
import com.parking.common.exception.BusinessException;
import com.parking.common.model.MemberCard;
import com.parking.common.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MemberCardServiceImpl implements MemberCardService {

    @Autowired
    MemberCardMapper cardMapper;

    @Override
    public int addMemberCard(String json) throws BusinessException {
        MemberCard card = JsonUtils.fromJson(json,MemberCard.class);
        log.info("add member card " +json);
        return cardMapper.insert(card);
    }
}