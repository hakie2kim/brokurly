package com.brokurly.repository.order;

import com.brokurly.entity.order.ReceiverDetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReceiverDetailsDao {
    // CREATE
    int insert(ReceiverDetails receiverDetails);

    // READ
    int count();
    List<ReceiverDetails> selectAll();
    ReceiverDetails selectByShipLocaId(String shipLocaId);
    ReceiverDetails selectByRcvDtlId(String rcvDtlId);

    // UPDATE
    int update(ReceiverDetails receiverDetails);

    // DELETE
    int deleteAll();
    int deleteByRcvDtlId(String rcvDtlId);
}
