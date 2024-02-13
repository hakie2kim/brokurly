package com.brokurly.service;

import com.brokurly.domain.ReceiverDetails;
import com.brokurly.dto.ReceiverDetailsChangeDto;
import com.brokurly.dto.ReceiverDetailsDto;
import com.brokurly.repository.ReceiverDetailsDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReceiverDetailsService {
    private final ReceiverDetailsDao receiverDetailsDao;

    public ReceiverDetailsDto findReceiverDetails(String shipLocaId) {
        ReceiverDetails receiverDetails = receiverDetailsDao.selectByShipLocaId(shipLocaId);
        return receiverDetails.makeFullDto();
    }

    @Transactional
    public ReceiverDetailsDto changeReceiverDetails(ReceiverDetailsChangeDto changeDto) {
        ReceiverDetails receiverDetails = receiverDetailsDao.selectByRcvDtlId(changeDto.getRcvDtlId());
        receiverDetails.update(changeDto);
        receiverDetailsDao.update(receiverDetails);
        return receiverDetails.makeFullDto();
    }
}
