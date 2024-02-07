package com.brokurly.repository;

import com.brokurly.entity.PointLogUsageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PointLogDao {
    List<PointLogUsageDto> selectByCustomer(String custId);
}
