package com.tedu.dao.mapping;

import com.tedu.entity.Goods;
import com.tedu.utils.ObjectMapping;
import com.tedu.utils.utils.BaseEntityUtils;

import java.sql.ResultSet;

public class GoodsMapping implements ObjectMapping {
    @Override
    public Object mapping(ResultSet resultSet) {
        return BaseEntityUtils.objectMapping(resultSet,new Goods());
    }
}
