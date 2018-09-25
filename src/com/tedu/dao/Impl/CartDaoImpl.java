package com.tedu.dao.Impl;

import com.tedu.dao.CartDao;
import com.tedu.dao.mapping.CartVoMapper;
import com.tedu.entity.Cart;
import com.tedu.utils.utils.BaseEntityUtils;
import com.tedu.utils.Operation;
import com.tedu.utils.utils.SqlUtils;
import com.tedu.vo.CartVo;

import java.util.List;
import java.util.Objects;

public class CartDaoImpl implements CartDao {

    private Operation operation;

    public CartDaoImpl() {
        operation=new Operation();
    }

    @Override
    public void insertCart(Cart cart) {
        if(Objects.isNull(cart.getId())){
            String sql= SqlUtils.insertSql(cart);
            Object[] objects= BaseEntityUtils.getFieldsValues(cart).toArray();
            operation.update(sql,objects,true);
        }
    }

    @Override
    public List<CartVo> selectCartByUid(Integer uid) {
        String sql="select t_cart.id ,userid,goodsid,count,image,title,price from t_cart " +
                "inner join t_goods on t_cart.goodsid=t_goods.id where userid="+uid;
        return (List<CartVo>) operation.query(sql,new Object[]{},new CartVoMapper());
    }

    @Override
    public void deleteByBatch(Integer[] ids) {
        String sql=SqlUtils.batchDeleteSql(new Cart(),ids.length);
        Object[] parameters=ids;
        operation.update(sql,parameters,false);
    }

    @Override
    public void deleteById(Integer id) {
        String sql="delete from t_cart where id="+id;
        Object[] parameters=new Object[]{};
        operation.update(sql,parameters,false);
    }

    @Override
    public void updateById(Integer count, Integer id) {
        String sql="update t_cart set count=? where id=?";
        Object[] parameters=new Object[]{count,id};
        operation.update(sql,parameters,false);
    }
}
