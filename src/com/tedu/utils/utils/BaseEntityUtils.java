package com.tedu.utils.utils;

import com.tedu.entity.model.BaseEntity;
import com.tedu.utils.annotation.Column;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class BaseEntityUtils {
    public static List<Object> getFieldsValues(BaseEntity baseEntity){
        List<Object> fieldsValues=new ArrayList<>();
        Field[] fields=baseEntity.getC().getDeclaredFields();
        for(Field field:fields){
            if (!field.isAnnotationPresent(Column.class)) {
                continue;
            }

            String parmentName = field.getName();
            //得到相应的get方法  get + 属性名首字母大写
            String getMethodName = "get" + parmentName.substring(0, 1).toUpperCase() + "" + parmentName.substring(1);
            try {
                //调用方法
                @SuppressWarnings("unchecked")
                Method method = baseEntity.getC().getMethod(getMethodName);
                Object o=method.invoke(baseEntity);
                if (Objects.isNull(o)){
                    fieldsValues.add(null);
                }else {
                    fieldsValues.add(o);
                }

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return fieldsValues;
    }

    public static BaseEntity objectMapping(ResultSet resultSet,BaseEntity baseEntity){
        Field[] fields=baseEntity.getC().getDeclaredFields();
        try {
            for(Field field:fields){
                Column column=field.getAnnotation(Column.class);
                if(!Objects.isNull(column)){
                    Class[] parameterTypes = new Class[1];
                    String parmentName = field.getName();
                    Object value=resultSet.getObject(column.value());
                    //反射执行set方法
                    parameterTypes[0]=field.getType();
                    String getMethodName = "set" + parmentName.substring(0, 1).toUpperCase()+ "" +parmentName.substring(1);
                    Method method = baseEntity.getC().getMethod(getMethodName,parameterTypes);
                    if("java.lang.Integer".equals(parameterTypes[0].getName())){
                        method.invoke(baseEntity,(Integer)value);
                    }else if("java.lang.String".equals(parameterTypes[0].getName())){
                        method.invoke(baseEntity,(String)value);
                    }else if("java.util.Date".equals(parameterTypes[0].getName())){
                        method.invoke(baseEntity,(Date)value);
                    }else if("java.util.Double".equals(parameterTypes[0].getName())){
                        method.invoke(baseEntity,(Double)value);
                    }
                }
            }
            Integer id=resultSet.getInt("id");
            baseEntity.setId(id);
        } catch (SQLException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return baseEntity;
    }

    public static List<String> getColumnsNames(BaseEntity baseEntity){
        List<String> columnsNames=new ArrayList<>();
        Field[]  files = baseEntity.getC().getDeclaredFields();
        for (Field field : files) {
            //判断是否使用Fields注解字段名
            if (!field.isAnnotationPresent(Column.class)) {
                continue;
            }
            //得到属性上注解的字段名
            Column columns = field.getAnnotation(Column.class);
            String columnName = columns.value();
            columnsNames.add(columnName);
        }
        return columnsNames;
    }

}
