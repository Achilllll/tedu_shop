package com.tedu.dao.Impl;

import com.tedu.dao.GoodsCategoryDao;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoodsGategoryDaoImplTest {

    private GoodsCategoryDao goodsCategoryDao;

    public GoodsGategoryDaoImplTest() {
        goodsCategoryDao=new GoodsGategoryDaoImpl();
    }

    @Test
    public void selectCategoryByParentId() {
        System.out.println(goodsCategoryDao.selectCategoryByParentId(1,5,5));
    }
}