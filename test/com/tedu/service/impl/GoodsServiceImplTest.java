package com.tedu.service.impl;

import com.tedu.service.GoodsService;
import org.junit.Test;

public class GoodsServiceImplTest {

    private GoodsService goodsService;

    public GoodsServiceImplTest() {
        this.goodsService = new GoodsServiceImpl();
    }

    @Test
    public void listGoods() {
        System.out.println(goodsService.listGoods(163,1,3));
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