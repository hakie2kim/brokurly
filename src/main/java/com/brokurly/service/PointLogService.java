package com.brokurly.service;

import com.brokurly.entity.PointLogUsageDto;
import com.brokurly.repository.PointLogDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PointLogService {
    private final PointLogDao pointLogDao;

    public List<PointLogUsageDto> findPointLogByCustId(String custId) { return pointLogDao.selectByCustomer(custId); }
}
