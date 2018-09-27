package com.tedu.service.impl;

import com.tedu.dto.GoodsDto;
import com.tedu.service.GoodsService;
import org.junit.Test;

import java.util.List;

public class GoodsServiceImplTest {

    private GoodsService goodsService;

    public GoodsServiceImplTest() {
        this.goodsService = new GoodsServiceImpl();
    }

    @Test
    public void listGoods() {
        List<GoodsDto> goodsDtos=goodsService.listGoods(238,1,3);
        for (GoodsDto goodsdto: goodsDtos) {
            System.out.println(goodsdto);
        }

    }

    @Test
    public void getCategories() {
        System.out.println(goodsService.getCategories(161,1 ));
    }

    @Test
    public void goodsDetail() {
        System.out.println(goodsService.goodsDetail(1));
    }
}