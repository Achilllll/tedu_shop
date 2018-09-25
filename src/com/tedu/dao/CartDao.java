package com.tedu.dao;


import com.tedu.entity.Cart;
import com.tedu.vo.CartVo;

import java.util.List;

public interface CartDao {

    /**
     * 插入数据到购物车表
     * @param cart
     */
    void insertCart(Cart cart);

    /**
     * 查询购物车信息
     * @param uid
     * @return
     */
    List<CartVo> selectCartByUid(Integer uid);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByBatch(Integer[] ids);

    /**
     * 单行删除
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 修改商品数量
     * @param num
     * @param id
     */
    void updateById(Integer num, Integer id);

}
