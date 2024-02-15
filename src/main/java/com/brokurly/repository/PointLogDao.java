package com.brokurly.repository;

import com.brokurly.domain.PointAndPointLog;
import com.brokurly.domain.PointLog;
import com.brokurly.dto.PointAndPointLogEarningDto;
import com.brokurly.dto.PointLogExpDto;
import com.brokurly.dto.PointLogUsageDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PointLogDao {
    // CREATE
    int insert(PointLog pointLog);

    // READ
    List<PointLog> selectUsageByCustomerAndPeriod(@Param("custId") String custId, @Param("period") Integer period);
    int countUsageByCustomerAndPeriod(@Param("custId") String custId, @Param("period") Integer period);
    List<PointLog> selectExpByCustomerAndPeriod(@Param("custId") String custId, @Param("period") Integer period);
    int countExpByCustomerAndPeriod(@Param("custId") String custId, @Param("period") Integer period);
    List<PointAndPointLog> selectEarningByCustomerAndPeriod(@Param("custId") String custId, @Param("period") Integer period);
    int countEarningByCustomerAndPeriod(@Param("custId") String custId, @Param("period") Integer period);
    int countAll();

    // UPDATE 없음

    // DELETE
    void deleteAll();
    void deleteByPointNo(Integer pointNo);
}
