package com.tedu.dao;

import com.tedu.entity.GoodsCategory;

import java.util.List;

public interface GoodsCategoryDao {

    /**
     * 查询分类信息
     * @param parentId
     * @param offset
     * @param count
     * @return
     */
    List<GoodsCategory> selectCategoryByParentId(
            Integer parentId,
            Integer offset,
            Integer count);


    /***
     * 根据id查找主类
     * @param id
     * @return
     */
    GoodsCategory selectCategoryById(Integer id);

}
