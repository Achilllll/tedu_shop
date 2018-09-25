package com.tedu.dao.Impl;

import com.tedu.dao.GoodsDao;
import com.tedu.dao.mapping.GoodsMapping;
import com.tedu.entity.Goods;
import com.tedu.utils.Operation;

import java.util.List;

public class GoodsDaoImpl implements GoodsDao {

    private Operation operation;
    public GoodsDaoImpl() {
        operation=new Operation();
    }

    @Override
    public List<Goods> selectGoodsByCategoryId(Integer categoryId, Integer offset, Integer count) {
        String sql="select * from t_goods where category_id=? and (select count(*))>0 and status=1"
                +" order by"
                + " priority DESC"
                + " limit ?,?";
        Object[] parameters=new Object[]{categoryId,offset,count};
        return (List<Goods>) operation.query(sql,parameters,new GoodsMapping());
    }

    @Override
    public Integer selectCount(Integer categoryId) {
        String sql="select count(*) as count from t_goods where category_id="+categoryId;
        return operation.count(sql,new Object[]{});
    }

    @Override
    public Goods selectGoodsById(Integer id) {
        String sql="select * from t_goods where id="+id;
        return (Goods) operation.find(sql,new Object[]{},new GoodsMapping());
    }
}
