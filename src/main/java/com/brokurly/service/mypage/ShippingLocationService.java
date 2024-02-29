package com.brokurly.service.mypage;

import com.brokurly.dto.mypage.ShippingLocationAddDto;
import com.brokurly.dto.mypage.ShippingLocationDto;
import com.brokurly.dto.mypage.ShippingLocationManagementDto;
import com.brokurly.entity.mypage.ShippingLocation;
import com.brokurly.entity.mypage.ShippingLocationAndShoppingLocationChangeLog;
import com.brokurly.repository.mypage.ShippingLocationDao;
import com.brokurly.utils.RandomGeneratorUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShippingLocationService {
    private final ShippingLocationDao shippingLocationDao;

    @Transactional
    public ShippingLocationAddDto addNewShippingLocation(String addr, String specAddr, String defAddrFl) {
        String shipLocaId = RandomGeneratorUtils.randomGeneratedShipLocaId();

        // ShippingLocationAddDto -> ShippingLocation
        ShippingLocation shippingLocation = new ShippingLocation();
        ShippingLocationAddDto shippingLocationAddDto = new ShippingLocationAddDto(shipLocaId, addr, specAddr, defAddrFl, currDateAsYYYYMMDD(), "N");
        shippingLocation.updateShippingLocationAddDto(shippingLocationAddDto);

        shippingLocationDao.insert(shippingLocation);

        return shippingLocationAddDto;
    }

    public List<ShippingLocationDto> getShippingLocationListByCustomer(String custId) {
        return shippingLocationDao.selectByCustomer(custId)
                .stream()
                .map(ShippingLocationAndShoppingLocationChangeLog::makeShippingLocationDto)
                .filter(sl -> "N".equals(sl.getDelFl()))
                .sorted(Comparator.comparing(ShippingLocationDto::getShipLocaRegDt).reversed())
                .collect(Collectors.toList());
    }

    private static String currDateAsYYYYMMDD() {
        LocalDate currLD = LocalDate.now();
        DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return currLD.format(dtFormatter);
    }
}
