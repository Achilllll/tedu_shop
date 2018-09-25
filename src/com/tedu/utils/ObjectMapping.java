package com.tedu.utils;

import java.sql.ResultSet;

public interface ObjectMapping {
    public Object mapping(ResultSet resultSet);
}
