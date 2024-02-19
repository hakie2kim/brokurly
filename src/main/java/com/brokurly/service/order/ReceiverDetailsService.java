package com.brokurly.service.order;

import com.brokurly.entity.order.ReceiverDetails;
import com.brokurly.dto.order.ReceiverDetailsChangeDto;
import com.brokurly.dto.order.ReceiverDetailsDto;
import com.brokurly.repository.order.ReceiverDetailsDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReceiverDetailsService {
    private final ReceiverDetailsDao receiverDetailsDao;

    public ReceiverDetailsDto findReceiverDetails(String shipLocaId) {
        ReceiverDetails receiverDetails = receiverDetailsDao.selectByShipLocaId(shipLocaId);
        return receiverDetails.toResponseDto();
    }

    @Transactional
    public ReceiverDetailsDto modifyReceiverDetails(String shipLocaId, ReceiverDetailsChangeDto changeDto) {
        ReceiverDetails receiverDetails = receiverDetailsDao.selectByShipLocaId(shipLocaId);
        receiverDetails.changeReceiverDetails(changeDto);
        receiverDetailsDao.update(receiverDetails);
        return receiverDetails.toResponseDto();
    }
}
