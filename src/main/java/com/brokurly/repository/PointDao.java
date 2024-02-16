package com.brokurly.repository;

import com.brokurly.domain.Point;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PointDao {
    // CREATE
    int insert(Point point);

    // READ
    Point selectByPointNo(Integer pointNo);
    int countAll();

    // UPDATE
    int updatePointAmt(Integer amt);

    // DELETE
    void deleteAll();
    int deleteByPointNo(Integer pointNo);
}
