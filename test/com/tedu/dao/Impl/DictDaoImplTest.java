package com.tedu.dao.Impl;

import com.tedu.dao.DictDao;
import org.junit.Test;

public class DictDaoImplTest {

    private DictDao dictDao;
    public DictDaoImplTest() {
        dictDao=new DictDaoImpl();
    }

    @Test
    public void selectProvince() {
        System.out.println(dictDao.selectProvince());
    }

    @Test
    public void selectCity() {
        System.out.println(dictDao.selectCity("110000"));
    }

    @Test
    public void selectArea() {
        System.out.println(dictDao.selectArea("110100"));
    }


    @Test
    public void selectProvinceNameByCode() {
        System.out.println(dictDao.selectProvinceNameByCode("110000"));
    }

    @Test
    public void selectCityNameByCode() {
        System.out.println(dictDao.selectCityNameByCode("110100"));
    }

    @Test
    public void selectAreaNameByCode() {
        System.out.println(dictDao.selectArea("110101"));
    }
}