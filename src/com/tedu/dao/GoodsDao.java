package com.tedu.dao;


import com.tedu.entity.Goods;
import java.util.List;

public interface GoodsDao {

    /**
     * 查询热卖商品
     * @param categoryId
     * @param offset
     * @param count
     * @return
     */
    List<Goods> selectGoodsByCategoryId(
            Integer categoryId,
            Integer offset,
            Integer count);

    /**
     * 根据分类id获取记录数
     * @param categoryId
     * @return
     */
    Integer selectCount(Integer categoryId);

    /**
     * 查询商品信息
     * @param id
     * @return
     */
    Goods selectGoodsById(Integer id);


}
