package com.brokurly.service.goods;

import com.brokurly.entity.goods.Goods;
import com.brokurly.repository.goods.GoodsDao;
import com.brokurly.repository.goods.GoodsImageDao;
import com.brokurly.dto.goods.GoodsListDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GoodsListService {
    private final GoodsDao goodsDao;
    private final GoodsImageDao goodsImageDao;

    public List<GoodsListDto> readGoodsList(String cateCode){

        List<Goods> goodsList = goodsDao.selectGoodsListbyCateCode(cateCode);
        List<GoodsListDto> goodsListDto = new ArrayList<>();

        for(Goods goods : goodsList){
            GoodsListDto dto = goods.makeGoodsList();
            String img = goodsImageDao.getThumbnailByItemId(dto.getItemId());
            dto.setImg(img);
            goodsListDto.add(dto);
        }

        return goodsListDto;
    }
}
