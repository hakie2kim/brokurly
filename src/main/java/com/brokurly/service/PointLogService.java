package com.brokurly.service;

import com.brokurly.dto.PointLogEarningDto;
import com.brokurly.dto.PointLogExpDto;
import com.brokurly.dto.PointLogUsageDto;
import com.brokurly.repository.PointLogDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PointLogService {
    private final PointLogDao pointLogDao;

    public List<PointLogUsageDto> findPointLogUsageByCustomerAndPeriod(String custId, Integer period) {
        return pointLogDao.selectUsageByCustomerAndPeriod(custId, period);
    }

    public int getPointLogUsageCountByCustomerAndPeriod(String custId, Integer period) {
        return pointLogDao.countUsageByCustomerAndPeriod(custId, period);
    }

    public List<PointLogExpDto> findPointLogExpByCustomerAndPeriod(String custId, Integer period) {
        return pointLogDao.selectExpByCustomerAndPeriod(custId, period);
    }

    public int getPointLogExpCountByCustomerAndPeriod(String custId, Integer period) {
        return pointLogDao.countExpByCustomerAndPeriod(custId, period);
    }

    public List<PointLogEarningDto> findPointLogEarningByCustomerAndPeriod(String custId, Integer period) {
        return pointLogDao.selectEarningByCustomerAndPeriod(custId, period);
    }

    public int getPointLogEarningCountByCustomerAndPeriod(String custId, Integer period) {
        return pointLogDao.countEarningByCustomerAndPeriod(custId, period);
    }
}
