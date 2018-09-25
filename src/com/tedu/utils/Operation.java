package com.tedu.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Operation {

    /***
     * 查询数量通用
     * @param sql
     * @param objects
     */

    public Integer count(String sql,Object[] objects){
        Connection conn=null;
        PreparedStatement preparedStatement=null;
        conn=DBConnection.getConnection();
        Integer count=0;
        try {
            preparedStatement=conn.prepareStatement(sql);
            for (int i = 0; i <objects.length ; i++) {
                preparedStatement.setObject(i+1,objects[i]);
            }
            ResultSet resultSet=preparedStatement.executeQuery();
           while(resultSet.next()){
               count=resultSet.getInt("count");
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * query方法的通用流程
     * @param sql
     * @param objects
     * @param objectMapping
     * @return
     */
    public List<? extends Object> query(String sql,Object[] objects,ObjectMapping objectMapping){
        Connection conn=null;
        PreparedStatement preparedStatement=null;
        List<Object> list=new ArrayList<Object>();

        try {
            conn=DBConnection.getConnection();
            preparedStatement=conn.prepareStatement(sql);
            for (int i = 0; i <objects.length ; i++) {
                preparedStatement.setObject(i+1,objects[i]);
            }
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Object o=objectMapping.mapping(resultSet);
                list.add(o);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            closeDatabase(conn, preparedStatement);
        }
        return list;
    }


    /**
     * 更新通用方法
     * @param sql
     * @param objects
     * @param isGenerated
     * @return
     */
    public Integer update(String sql,Object[] objects,boolean isGenerated){
        Connection conn=null;
        Integer result=0;
        PreparedStatement preparedStatement=null;
        try {
            conn=DBConnection.getConnection();
            //Statement.RETURN_GENERATED_KEYS 返回自增的id号
            preparedStatement=isGenerated?conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS):conn.prepareStatement(sql);
            conn.setAutoCommit(false);
            for (int i = 0; i <objects.length ; i++) {
                preparedStatement.setObject(i+1,objects[i]);
            }
            result=preparedStatement.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            closeDatabase(conn, preparedStatement);
        }
        return result;
    }

    private void closeDatabase(Connection conn, PreparedStatement preparedStatement) {
        try {
            if(conn!=null)conn.close();
            if(preparedStatement!=null)preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * find通用方法
     * @param sql
     * @param objects
     * @param objectMapping
     * @return
     */
    public Object find(String sql,Object[] objects,ObjectMapping objectMapping){
        Connection conn=null;
        PreparedStatement preparedStatement=null;
        Object o=null;
        try {
            conn=DBConnection.getConnection();
            preparedStatement=conn.prepareStatement(sql);
            for (int i = 0; i <objects.length ; i++) {
                preparedStatement.setObject(i,objects[i]);
            }
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                o=objectMapping.mapping(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            closeDatabase(conn, preparedStatement);
        }
        return o;
    }

}
