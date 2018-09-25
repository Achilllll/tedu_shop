package com.tedu.dao.mapping;

import com.tedu.entity.GoodsCategory;
import com.tedu.utils.ObjectMapping;
import com.tedu.utils.utils.BaseEntityUtils;

import java.sql.ResultSet;

public class GoodsGategoryMapping implements ObjectMapping {
    @Override
    public Object mapping(ResultSet resultSet) {
        return BaseEntityUtils.objectMapping(resultSet,new GoodsCategory());
    }
}
