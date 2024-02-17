package com.brokurly.service;

import com.brokurly.domain.Point;
import com.brokurly.dto.PointDto;
import com.brokurly.repository.PointDao;
import com.brokurly.repository.PointLogDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointService {
    private final PointDao pointDao;

    // 총 적립금 구하기
    public int findTotalAvailPoints(String custId) {
        return pointDao.selectByCustId(custId)
                .stream()
                .map(Point::getPointDto)
                .mapToInt(PointDto::getPointAmt)
                .sum();
    }

    // (일반) 적립


    // CREATE

    // READ
    public PointDto findPointByPointId(Integer pointId) {
        return pointDao.selectByPointNo(pointId).getPointDto();
    }

    // UPDATE
    
    // DELETE 없음

    /*(일반) 적립
    PointDao insert
    PointLogDao insert

    구매 적립
    PointDao insert
    PointLogDao insert

    주문 결제 시 사용
    PointDao update
    PointLogDao insert

    기간 소멸
    PointDao update
    PointLogDao insert*/
}
