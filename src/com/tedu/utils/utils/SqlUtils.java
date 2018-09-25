package com.tedu.utils.utils;

import com.tedu.entity.model.BaseEntity;
import com.tedu.utils.annotation.Column;
import com.tedu.utils.annotation.Table;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class SqlUtils {
    public static String querySql(BaseEntity baseEntity){
        //拼接sql
        StringBuilder sBuilder = new StringBuilder("select * from ");
        @SuppressWarnings("rawtypes")
        Class c = baseEntity.getClass();
        //得到表名
        //判断是否使用了table注解
        @SuppressWarnings("unchecked")
        boolean isuseTableName = c.isAnnotationPresent(Table.class);

        if (false  == isuseTableName ) {
            return "没有注解表名";
        }
        if (isuseTableName) {
            Table tableName = (Table) c.getAnnotation(Table.class);
            sBuilder.append(tableName.value());
            sBuilder.append(" where 1=1 ");
        }

        //得到类属性的所有字段
        Field[]  files = c.getDeclaredFields();

        for (Field field : files) {

            //判断是否使用Fields注解字段名
            if (!field.isAnnotationPresent(Column.class)) {
                continue;
            }
            //得到属性上注解的字段名
            Column columns = field.getAnnotation(Column.class);
            String columnName = columns.value();
            //得到属性名
            String parmentName = field.getName();

            //得到相应的get方法  get + 属性名首字母大写
            String getMethodName = "get" + parmentName.substring(0, 1).toUpperCase() + "" + parmentName.substring(1);

            //得到检索条件值  拼接sql
            Object filedValue = "";
            try {
                //调用方法
                @SuppressWarnings("unchecked")
                Method method = c.getMethod(getMethodName);
                filedValue = method.invoke(baseEntity);

                if ("".equals(filedValue) || (filedValue instanceof Integer && (Integer) filedValue == 0)) {
                    continue;
                }

                //拼接sql
                //判断字段数据类型
                if (filedValue instanceof String) {
                    sBuilder.append("and " + columnName + "=" + "'" + filedValue + "' ");
                }
                if (filedValue instanceof Integer) {
                    sBuilder.append("and " + columnName + "=" + filedValue + " ");
                }

            } catch (NoSuchMethodException | SecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return sBuilder.toString();
    }

    //要求传入参数
    public static String insertSql(BaseEntity baseEntity){
        //拼接sql
        StringBuilder sBuilder = new StringBuilder("insert into ");
        @SuppressWarnings("rawtypes")
        Class c = baseEntity.getC();
        //得到表名
        //判断是否使用了table注解
        @SuppressWarnings("unchecked")
        boolean isuseTableName = c.isAnnotationPresent(Table.class);
        if (false  == isuseTableName ) {
            return "没有注解表名";
        }
        if (isuseTableName) {
            Table tableName = (Table) c.getAnnotation(Table.class);
            sBuilder.append(tableName.value()+"(");
        }

        List<String> columnsNames= BaseEntityUtils.getColumnsNames(baseEntity);
        for (String s:columnsNames){
            sBuilder.append(s+",");
        }
        //去掉多余的，
        sBuilder.deleteCharAt(sBuilder.length()-1);
        sBuilder.append(") values (");
        for (int i = 0; i <columnsNames.size() ; i++) {
            sBuilder.append("?,");
        }
        sBuilder.deleteCharAt(sBuilder.length()-1);
        sBuilder.append(")");
        return sBuilder.toString();
    }

    //更新
    public static String updateSql(BaseEntity baseEntity){
        //拼接sql
        StringBuilder sBuilder = new StringBuilder("update ");
        @SuppressWarnings("rawtypes")
        Class c = baseEntity.getC();
        //得到表名
        //判断是否使用了table注解
        @SuppressWarnings("unchecked")
        boolean isuseTableName = c.isAnnotationPresent(Table.class);
        if (false  == isuseTableName ) {
            return "没有注解表名";
        }
        if (isuseTableName) {
            Table tableName = (Table) c.getAnnotation(Table.class);
            sBuilder.append(tableName.value()+" set ");
        }

        List<String> columnsNames=BaseEntityUtils.getColumnsNames(baseEntity);
        for (String s:columnsNames){
            sBuilder.append(s+"=?,");
        }
        //去掉多余的，
        sBuilder.deleteCharAt(sBuilder.length()-1);
        sBuilder.append(" where id="+baseEntity.getId());
        return sBuilder.toString();
    }

    public static String batchDeleteSql(BaseEntity baseEntity,int length){
        StringBuffer stringBuffer=new StringBuffer("delete from ");
        //设置表名
        boolean isuseTableName = baseEntity.getC().isAnnotationPresent(Table.class);
        if (false  == isuseTableName ) {
            return "没有注解表名";
        }
        if (isuseTableName) {
            Table tableName = (Table) baseEntity.getC().getAnnotation(Table.class);
            stringBuffer.append(tableName.value());
            stringBuffer.append(" where id in (");
        }

        for (int i = 0; i <length ; i++) {
            stringBuffer.append("?,");
        }
        return stringBuffer.substring(0,stringBuffer.length()-1)+")";
    }


}
