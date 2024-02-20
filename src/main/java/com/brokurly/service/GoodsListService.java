package com.brokurly.service;

import com.brokurly.domain.Goods;
import com.brokurly.dto.GoodsListDto;
import com.brokurly.repository.GoodsDao;
import com.brokurly.repository.GoodsImageDao;
import com.brokurly.repository.GoodsListDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
