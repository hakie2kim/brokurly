package com.brokurly.service.mypage;

import com.brokurly.entity.mypage.Point;
import com.brokurly.repository.mypage.PointDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointService {
    private final PointDao pointDao;

    public Point findPointByPointId(Integer pointId) {
        return pointDao.selectByPointNo(pointId);
    }
}
