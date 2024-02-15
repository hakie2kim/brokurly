package com.brokurly.repository;

import com.brokurly.domain.ReceiverDetails;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReceiverDetailsDao {
    ReceiverDetails selectByShipLocaId(String shipLocaId);

    ReceiverDetails selectByRcvDtlId(String rcvDtlId);

    void update(ReceiverDetails receiverDetails);
}
