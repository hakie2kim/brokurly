package com.brokurly.repository;

import com.brokurly.domain.Point;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PointDao {
    // CREATE
    int insert(Point point);

    // READ
    List<Point> selectByCustId(String custId);
    Point selectByPointNo(Integer pointNo);
    List<Point> selectExpired();
    int countAll();

    // UPDATE
    int updatePointAmt(Integer amt);

    // DELETE
    void deleteAll();
    int deleteByPointNo(Integer pointNo);
}
