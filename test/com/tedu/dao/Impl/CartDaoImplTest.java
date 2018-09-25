package com.tedu.dao.Impl;

import com.tedu.dao.CartDao;
import com.tedu.entity.Cart;
import org.junit.Before;
import org.junit.Test;

public class CartDaoImplTest {

    private CartDao cartDao;
    private Cart cart;
    public CartDaoImplTest() {
        cartDao=new CartDaoImpl();
    }

    @Before
    public void beforeTest(){
        cart=new Cart();
        cart.setCount(10);
        cart.setGoodsId("10");
        cart.setUid(3);
    }

    @Test
    public void insertCart() {
        cartDao.insertCart(cart);
    }

    @Test
    public void selectCartByUid() {
        System.out.println(cartDao.selectCartByUid(3));
    }

    @Test
    public void deleteByBatch() {
        cartDao.deleteByBatch(new Integer[]{32,33});
    }

    @Test
    public void deleteById() {
        cartDao.deleteById(32);
    }

    @Test
    public void updateById() {
        cartDao.updateById(5,32);
    }
}