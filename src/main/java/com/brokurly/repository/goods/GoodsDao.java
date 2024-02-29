package com.brokurly.repository.goods;


import com.brokurly.entity.goods.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsDao {

    // CREATE
    int insert(Goods goods); //장바구니에 담기

    // READ
    Goods selectByItemId(String itemId);  //optional 값이 없는 null을 optional로 감싸서 전달

    // UPDATE
    int update(Goods goods);

    // DELTE
    int deleteByItemId(String itemId);

    List<Goods> selectGoodsListByCateCode(@Param("cateCode") String cateCode, @Param("limit") int limit,
                                          @Param("start") int start);


    int countGoodsListByCateCode(String cateCode);

    List<Goods> sortGoodsList(@Param("cateCode") String cateCode, @Param("limit") int limit,
                              @Param("start") int start, @Param("sortedtype") String sortedtype);

    List<Goods> sortGoodsListByRegDate(@Param("cateCode") String cateCode, @Param("limit") int limit,
                                       @Param("start") int start);

    List<Goods> sortGoodsListByLowPrice(@Param("cateCode") String cateCode, @Param("limit") int limit,
                                        @Param("start") int start);

    List<Goods> sortGoodsListByHighPrice(@Param("cateCode") String cateCode, @Param("limit") int limit,
                                         @Param("start") int start);

    List<Goods> sortGoodsListBySellCnt(@Param("cateCode") String cateCode, @Param("limit") int limit,
                                       @Param("start") int start);

    List<Goods> sortGoodsListByDcRt(@Param("cateCode") String cateCode, @Param("limit") int limit,
                                    @Param("start") int start);

}
