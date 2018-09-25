package com.tedu.dao.mapping;

import com.tedu.entity.User;
import com.tedu.utils.utils.BaseEntityUtils;
import com.tedu.utils.ObjectMapping;

import java.sql.ResultSet;

public class UserMapping implements ObjectMapping {
    public Object mapping(ResultSet resultSet) {
        return BaseEntityUtils.objectMapping(resultSet,new User());
    }
}
