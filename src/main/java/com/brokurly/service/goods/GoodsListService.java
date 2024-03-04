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

    private static final int GOODS_PER_PAGE = 9;

    public int countGoodsList(String cateCode){
       return goodsDao.countGoodsListByCateCode(cateCode);
    }

    public List<GoodsListDto> readGoodsList(String cateCode,int page){

        int start = GOODS_PER_PAGE*(page-1);
        List<Goods> goodsList = goodsDao.selectGoodsListByCateCode(cateCode, GOODS_PER_PAGE, start);
        List<GoodsListDto> goodsListDto = new ArrayList<>();

        for(Goods goods : goodsList){
            GoodsListDto dto = goods.makeGoodsList();
            String img = goodsImageDao.getThumbnailByItemId(dto.getItemId());
            dto.setImg(img);
            goodsListDto.add(dto);
        }

        return goodsListDto;
    }




    public List<GoodsListDto> sortGoodsList(String cateCode, int page, String sortedtype){

//        List<Goods> goodsList= new ArrayList<>();

        int start = GOODS_PER_PAGE*(page-1);

        List<Goods> goodsList = goodsDao.sortGoodsList(cateCode, GOODS_PER_PAGE, start, sortedtype);

//        if("0".equals(sortedtype)){
//         goodsList= goodsDao.sortGoodsListByRegDate(cateCode, GOODS_PER_PAGE, start);
//        }
//        else if("1".equals(sortedtype)){
//            goodsList = goodsDao.sortGoodsListBySellCnt(cateCode, GOODS_PER_PAGE, start);
//        }else if("2".equals(sortedtype)){
//            goodsList = goodsDao.sortGoodsListByLowPrice(cateCode, GOODS_PER_PAGE, start);
//        }else if("3".equals(sortedtype)){
//            goodsList = goodsDao.sortGoodsListByHighPrice(cateCode, GOODS_PER_PAGE, start);
//        }else if("4".equals(sortedtype)){
//            goodsList = goodsDao.sortGoodsListByDcRt(cateCode, GOODS_PER_PAGE, start);
//        }

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
