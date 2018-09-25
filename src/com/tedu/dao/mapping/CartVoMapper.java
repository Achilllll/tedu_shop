package com.tedu.dao.mapping;

import com.tedu.entity.Cart;
import com.tedu.utils.ObjectMapping;
import com.tedu.vo.CartVo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartVoMapper implements ObjectMapping {
    @Override
    public Object mapping(ResultSet resultSet) {
        CartVo cartVo=null;
        try {
            Integer id=resultSet.getInt("id");
            Integer uid=resultSet.getInt("userid");
            String goodsId=resultSet.getString("goodsid");
            Integer count=resultSet.getInt("count");
            String image=resultSet.getString("image");
            String title=resultSet.getString("title");
            Integer price=resultSet.getInt("price");
            cartVo=new CartVo(id,uid,goodsId,count,image,title,price);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartVo;
    }
}
