package com.tedu.dao.Impl;

import com.tedu.dao.AddressDao;
import com.tedu.dao.mapping.AddressMapping;
import com.tedu.entity.Address;
import com.tedu.utils.utils.BaseEntityUtils;
import com.tedu.utils.Operation;
import com.tedu.utils.utils.SqlUtils;
import java.util.List;
import java.util.Objects;

public class AddressDaoImpl implements AddressDao{

    private Operation operation;
    public AddressDaoImpl() {
        this.operation = new Operation();
    }

    @Override
    public void insertAddress(Address address) {
        if (Objects.isNull(address.getId())){
            Object[] obs=BaseEntityUtils.getFieldsValues(address).toArray();
            String sql=SqlUtils.insertSql(address);
            //自动生产主键
            operation.update(sql,obs, true);
        }
    }

    @Override
    public List<Address> selectAddressByUid(Integer uid) {
        AddressMapping mapping=new AddressMapping();
        String sql="select * from t_address where uid=?";
        List<Address> addressList= (List<Address>) operation.query(sql,new Object[]{uid},mapping);
        return addressList;
    }

    @Override
    public Integer updateCancel(Integer uid) {
        String sql="update t_address set is_default=1 where uid="+uid;
        return operation.update(sql,new Object[]{},false);
    }

    @Override
    public Integer updateDefault(Integer id) {
        String sql="update t_address set is_default =1 where id=?";
        return operation.update(sql,new Object[]{id},false);
    }

    @Override
    public Address selectAddressById(Integer id) {
        String sql="select * from t_address where id="+id;
        return (Address) operation.find(sql,new Object[]{},new AddressMapping());
    }

    @Override
    public void updateAddress(Address address) {
        if (Objects.isNull(address.getId())){
            Object[] obs=BaseEntityUtils.getFieldsValues(address).toArray();
            String sql=SqlUtils.updateSql(address);
            //自动生产主键
            operation.update(sql,obs, false);
        }
    }

    @Override
    public void deleteAddress(Integer id) {
        String sql="delete from t_address where id="+id;
        operation.update(sql,new Object[]{},false);
    }



}
