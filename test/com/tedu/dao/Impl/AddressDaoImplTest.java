package com.tedu.dao.Impl;

import com.tedu.dao.AddressDao;
import com.tedu.entity.Address;
import org.junit.Before;
import org.junit.Test;
import java.util.List;



public class AddressDaoImplTest {

    private Address address;
    private AddressDao addressDao;

    @Before
    public void beforeTest(){
        addressDao=new AddressDaoImpl();
        address=new Address();
        address.setCreatedUser("ceshiren ");
        address.setRecvProvinceCode("110");
        address.setRecvUsername("hihihi");
        address.setUid(3);
        address.setRecvCityCode("12323");
        address.setRecvAreaCode("110000");
        address.setRecvZip("110086");
        address.setRecvDistrict("beijingtiannanmen");
        address.setRecvAddress("beijingjialu");
        address.setRecvPhone("13911111111");
    }

    @Test
    public void insertAddress() {
        addressDao.insertAddress(address);
    }

    @Test
    public void selectAddressByUid() {
        List<Address> addresses=addressDao.selectAddressByUid(3);
        System.out.println("length "+addresses.size());
    }

    @Test
    public void updateCancel() {

        int i=addressDao.updateCancel(4);
        System.out.println("updateCancle= "+i);

    }

    @Test
    public void updateDefault() {
        int i=addressDao.updateCancel(4);
        System.out.println("updateDefault= "+i);
    }

    @Test
    public void selectAddressById() {
        Address address1=addressDao.selectAddressById(4);
        System.out.println(address1.toString());
    }

    @Test
    public void updateAddress() {
        Address address1=addressDao.selectAddressById(4);
        address1.setRecvUsername("wanghuidi");
        addressDao.updateAddress(address1);
        System.out.println(addressDao.selectAddressById(4));
    }

    @Test
    public void deleteAddress() {
        addressDao.deleteAddress(9);
    }
}