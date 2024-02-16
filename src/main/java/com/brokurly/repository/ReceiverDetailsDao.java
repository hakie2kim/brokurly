package com.brokurly.repository;

import com.brokurly.domain.ReceiverDetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReceiverDetailsDao {
    void insert(ReceiverDetails receiverDetails);

    List<ReceiverDetails> selectAll();

    ReceiverDetails selectByShipLocaId(String shipLocaId);

    void update(ReceiverDetails receiverDetails);
}
