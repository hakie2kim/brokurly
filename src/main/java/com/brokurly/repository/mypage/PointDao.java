package com.brokurly.repository.mypage;

import com.brokurly.entity.mypage.Point;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PointDao {
    Point selectByPointNo(Integer pointNo);
}
