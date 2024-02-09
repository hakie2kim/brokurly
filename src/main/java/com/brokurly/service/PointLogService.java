package com.brokurly.service;

import com.brokurly.dto.PointLogUsageDto;
import com.brokurly.repository.PointLogDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PointLogService {
    private final PointLogDao pointLogDao;

    public List<PointLogUsageDto> findPointLogUsageByCustomer(String custId, Integer period) {
        return pointLogDao.selectUsageByCustomerAndPeriod(custId, period);
    }

    public int getPointLogUsageByCustomerCount(String custId, Integer period) {
        return pointLogDao.countUsageByCustomerAndPeriod(custId, period);
    }
}
