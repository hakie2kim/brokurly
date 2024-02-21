package com.brokurly.service.cart;

import com.brokurly.entity.cart.CustomerCart;
import com.brokurly.repository.cart.CustomerCartDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerCartService {

    private final CustomerCartDao customerCartDao;

    public int insert(CustomerCart customerCart){

        //장바구니 데이터 유무 체크
        CustomerCart checkCart = customerCartDao.checkCart(customerCart);

        if(checkCart != null){
            return 2;
        }
        //장바구니 등록 & 에러 시 0 반환
        try {
            return customerCartDao.insert(customerCart);
        }catch (Exception e){
            return 0;
        }
    }
}
