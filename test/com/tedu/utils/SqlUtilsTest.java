package com.tedu.utils;

import com.tedu.entity.Address;
import com.tedu.utils.utils.SqlUtils;
import org.junit.Before;
import org.junit.Test;


public class SqlUtilsTest {
    private Address address;
    @Before
    public void beforeTest(){
        address=new Address();
        address.setId(1);
        address.setCreatedUser("测试人");
        address.setRecvProvinceCode("110000");
        address.setRecvAreaCode("110000");
        address.setRecvZip("1100108");
        address.setRecvDistrict("北京市市辖区海淀区");
        address.setRecvAddress("北三环西路甲18号");
        address.setRecvPhone("13911111111");
    }

    @Test
    public void querySql() {
        System.out.println(SqlUtils.querySql(address));
    }

    @Test
    public void insertSql() {
        System.out.println(SqlUtils.insertSql(address));
    }

    @Test
    public void updateSql() {
        System.out.println(SqlUtils.updateSql(address));
    }
}