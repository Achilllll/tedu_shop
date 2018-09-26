package com.tedu.utils;


import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static DataSource dataSource;
    private static Properties properties;


    static {
        properties = new Properties();
        try {
            properties.load(DBConnection.class.getResourceAsStream("../db.properties"));
            //创建数据源
            String driver=properties.getProperty("driver");
            Class.forName(driver);
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void closeConnection(Connection conn){
        if(conn!=null){
            try{
                //将Connection连接对象还给数据库连接池
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

}
}
