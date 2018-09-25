package com.tedu.dao.Impl;

import com.tedu.dao.GoodsCategoryDao;
import com.tedu.dao.mapping.GoodsGategoryMapping;
import com.tedu.entity.GoodsCategory;
import com.tedu.utils.Operation;

import java.util.List;

public class GoodsGategoryDaoImpl implements GoodsCategoryDao {
    private Operation operation;

    public GoodsGategoryDaoImpl() {
        operation=new Operation();
    }

    @Override
    public List<GoodsCategory> selectCategoryByParentId(Integer parentId, Integer offset, Integer count) {
        String sql="select * from t_goods_category where parent_id=? and status=1 limit ?,?";
        Object[] parameters=new Object[]{parentId,offset,count};
        return (List<GoodsCategory>) operation.query(sql,parameters,new GoodsGategoryMapping());
    }
}
