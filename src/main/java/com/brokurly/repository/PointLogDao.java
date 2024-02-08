package com.brokurly.repository;

import com.brokurly.entity.PointLogUsageDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PointLogDao {
    List<PointLogUsageDto> selectUsageByCustomerAndPeriod(@Param("custId") String custId, @Param("period") Integer period);
    int countUsageByCustomerAndPeriod(@Param("custId") String custId, @Param("period") Integer period);
}
