package com.brokurly.service.cart;

import com.brokurly.dto.cart.CustomerCartDto;
import com.brokurly.entity.cart.CustomerCart;
import com.brokurly.repository.cart.CustomerCartDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerCartService {

    private final CustomerCartDao customerCartDao;

    @Transactional
    public int addCart(CustomerCartDto customerCartDto) {   //장바구니 상품 추가

        CustomerCart customerCart = new CustomerCart(); //비어있는 CustomerCart 도메인 만들기
        customerCart.changeStatus(customerCartDto); //customerCartDto 있는 값으로 customerCart의 상태를 변경한다.
        //장바구니 데이터 유무 체크
        CustomerCart checkCart = customerCartDao.checkCart(customerCart);

        if (checkCart != null) {
            return 2;   //이걸 이제 개수를 추가하는걸로 변경해야됨
        }
        //장바구니 등록 & 에러 시 0 반환
        try {
            return customerCartDao.insert(customerCart);
        } catch (Exception e) {
            log.info("result=",e);
            return 0;
        }
    }

    public List<CustomerCartDto> getCartList(String custId) {    //장바구니 상품 불러오기
        List<CustomerCart> cartList = customerCartDao.getCart(custId);
        List<CustomerCartDto> customerCartDto = new ArrayList<>();

        for (CustomerCart customerCart : cartList) {    //cartList에서 CustomerCart(엔티티)를 하나씩 꺼내서
            /* 종합 정보 초기화 */
            customerCart.initSaleTotal();   //가격 계산해서 계산값 담기
            customerCartDto.add(customerCart.makeFullDto());    //makeDto메서드를 이용해 Dto로 만들어
            /* 이미지 정보 얻기 */
//            int itemId = customerCart.getItemId();
//            List<AttachImageVO> imageList = customerCartDao.getAttachList(itemId);
//            customerCart.setImageList(imageList);
        }
        return customerCartDto;
    }
}
