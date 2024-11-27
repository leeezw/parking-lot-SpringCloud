package com.parking.card.service;

import com.parking.common.exception.BusinessException;

public interface MemberCardService {


    int addMemberCard(String json) throws BusinessException;
}
