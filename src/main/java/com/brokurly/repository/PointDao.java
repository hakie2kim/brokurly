package com.brokurly.repository;

import com.brokurly.entity.Point;
import com.brokurly.entity.PointLogExpDto;
import com.brokurly.entity.PointLogUsageDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PointDao {
    Point selectByPointNo(Integer pointNo);
}
