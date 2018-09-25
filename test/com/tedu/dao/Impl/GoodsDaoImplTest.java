package com.tedu.dao.Impl;

import com.tedu.dao.GoodsDao;
import com.tedu.entity.Goods;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoodsDaoImplTest {

    private GoodsDao goodsDao;
    private Goods goods;
    @Before
    public void beforeTest(){
        goods=new Goods();
        goodsDao=new GoodsDaoImpl();
    }

    @Test
    public void selectGoodsByCategoryId() {
        System.out.println(goodsDao.selectGoodsByCategoryId(238,2,2));
    }

    @Test
    public void selectCount() {
        System.out.println(goodsDao.selectCount(241));
    }

    @Test
    public void selectGoodsById() {
        System.out.println(goodsDao.selectGoodsById(1));
    }
}