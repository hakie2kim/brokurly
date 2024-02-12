package com.brokurly.service;

import com.brokurly.domain.Point;
import com.brokurly.repository.PointDao;
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
