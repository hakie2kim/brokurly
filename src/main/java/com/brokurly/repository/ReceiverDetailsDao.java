package com.brokurly.repository;

import com.brokurly.domain.ReceiverDetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReceiverDetailsDao {
    int insert(ReceiverDetails receiverDetails);

    List<ReceiverDetails> selectAll();

    ReceiverDetails selectByShipLocaId(String shipLocaId);

    ReceiverDetails selectByRcvDtlId(String rcvDtlId);

    int update(ReceiverDetails receiverDetails);

    int deleteByRcvDtlId(String rcvDtlId);
}
