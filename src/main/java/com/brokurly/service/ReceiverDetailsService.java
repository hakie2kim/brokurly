package com.brokurly.service;

import com.brokurly.domain.ReceiverDetails;
import com.brokurly.dto.ReceiverDetailsChangeDto;
import com.brokurly.dto.ReceiverDetailsDto;
import com.brokurly.repository.ReceiverDetailsDao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
    public ReceiverDetailsDto modifyReceiverDetails(String shipLocaId, ReceiverDetailsChangeDto changeDto) {
        ReceiverDetails receiverDetails = receiverDetailsDao.selectByShipLocaId(shipLocaId);
        receiverDetails.changeReceiverDetails(changeDto);
        receiverDetailsDao.update(receiverDetails);
        return receiverDetails.makeFullDto();
    }
}
