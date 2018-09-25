package com.tedu.dao.mapping;

import com.tedu.entity.Address;
import com.tedu.utils.utils.BaseEntityUtils;
import com.tedu.utils.ObjectMapping;
import java.sql.ResultSet;

public class AddressMapping implements ObjectMapping {
    @Override
    //配置动态mapping
    public Object mapping(ResultSet resultSet) {
        return BaseEntityUtils.objectMapping(resultSet,new Address());
    }
}
