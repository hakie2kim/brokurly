package com.brokurly.repository;

import com.brokurly.domain.Point;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PointDao {
    Point selectByPointNo(Integer pointNo);
}
