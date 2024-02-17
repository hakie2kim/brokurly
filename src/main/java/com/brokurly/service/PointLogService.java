package com.brokurly.service;

import com.brokurly.domain.PointAndPointLog;
import com.brokurly.domain.PointLog;
import com.brokurly.dto.PointAndPointLogEarningDto;
import com.brokurly.dto.PointLogEarningDto;
import com.brokurly.dto.PointLogExpDto;
import com.brokurly.dto.PointLogUsageDto;
import com.brokurly.repository.PointLogDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PointLogService {
    private final PointLogDao pointLogDao;

    // CREATE
    public int addPointLogWithOrderId(PointLog pointLog) {
        return pointLogDao.insert(pointLog);
    }

    /*public int addPointLogWithoutOrderId(PointLog pointLog) {
        return pointLogDao.insertWithoutOrderId(pointLog);
    }*/

    // READ
    public List<PointLogUsageDto> findPointLogUsageByCustomerAndPeriod(String custId, Integer period) {
        /*List<PointLogUsageDto> pointLogUsageDtos = new ArrayList<>();

        List<PointLog> pointLogs = pointLogDao.selectUsageByCustomerAndPeriod(custId, period);

        for (PointLog pointLog : pointLogs) {
            pointLogUsageDtos.add(pointLog.getPointLogUsageDto());
        }

        return pointLogUsageDtos;*/

        return pointLogDao.selectUsageByCustomerAndPeriod(custId, period)
                .stream()
                .map(PointLog::getPointLogUsageDto)
                .collect(Collectors.toList());
    }

    public int getPointLogUsageCountByCustomerAndPeriod(String custId, Integer period) {
        return pointLogDao.countUsageByCustomerAndPeriod(custId, period);
    }

    // 총 누적 적립금액 찾기
    public int getTotalAccumulPoints(String custId) {
        return pointLogDao.selectEarningByCustomer(custId)
                .stream()
                .map(PointLog::getPointLogEarningDto)
                .mapToInt(PointLogEarningDto::getPointAmt)
                .sum();
    }

    public List<PointLogExpDto> findPointLogExpByCustomerAndPeriod(String custId, Integer period) {
        return pointLogDao.selectExpByCustomerAndPeriod(custId, period)
                .stream()
                .map(PointLog::getPointLogExpDto)
                .collect(Collectors.toList());
    }

    public int getPointLogExpCountByCustomerAndPeriod(String custId, Integer period) {
        return pointLogDao.countExpByCustomerAndPeriod(custId, period);
    }

    public List<PointAndPointLogEarningDto> findPointLogEarningByCustomerAndPeriod(String custId, Integer period) {
        return pointLogDao.selectEarningByCustomerAndPeriod(custId, period)
                .stream()
                .map(PointAndPointLog::getPointAndPointLogEarningDto)
                .collect(Collectors.toList());
    }

    public int getPointLogEarningCountByCustomerAndPeriod(String custId, Integer period) {
        return pointLogDao.countEarningByCustomerAndPeriod(custId, period);
    }

    // UPDATE, DELETE 없음
}
