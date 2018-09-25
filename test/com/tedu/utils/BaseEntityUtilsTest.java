package com.tedu.utils;

import com.tedu.entity.Address;
import com.tedu.utils.utils.BaseEntityUtils;
import org.junit.Before;
import org.junit.Test;

public class BaseEntityUtilsTest {

    private Address address;

    @Before
    public void before(){
        address=new Address();
        address.setId(1);
        address.setUid(2);
        address.setCreatedUser("测试人");
        address.setRecvProvinceCode("110000");
        address.setRecvAreaCode("110000");
        address.setRecvZip("1100108");
        address.setRecvDistrict("北京市市辖区海淀区");
        address.setRecvAddress("北三环西路甲18号");
        address.setRecvPhone("13911111111");
    }

    @Test
    public void getFieldsValues() {
        System.out.println(BaseEntityUtils.getFieldsValues(address));
    }

    @Test
    public void getColumnsNames() {
        System.out.println(BaseEntityUtils.getColumnsNames(address));
    }
}