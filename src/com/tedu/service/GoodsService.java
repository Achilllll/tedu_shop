package com.tedu.service;

import com.tedu.dto.GoodsCategoryDto;
import com.tedu.dto.GoodsDto;
import com.tedu.entity.Goods;

import java.util.List;

public interface GoodsService {
    /***
     * 根据类别加载商品
     * @param categoryId
     * @param offset
     * @param count
     * @return
     */
    public List<GoodsDto> listGoods(Integer categoryId, Integer offset, Integer count);

    /***
     * 根据parentid (商品子类)加载商品类别名,并封装成
     * @param mainCategoryId
     * @param offset
     * @return
     */
    //TODO
    public GoodsCategoryDto getCategories(Integer mainCategoryId, Integer offset);

    /***
     * id查询商品详情
     * @param id
     * @return
     */
    public Goods goodsDetail(Integer id);
}
