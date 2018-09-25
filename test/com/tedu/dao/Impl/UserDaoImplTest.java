package com.tedu.dao.Impl;

import com.tedu.dao.UserDao;
import com.tedu.entity.User;
import org.junit.Test;

public class UserDaoImplTest {
    private UserDao userDao;
    private User user;

    public UserDaoImplTest() {
        userDao=new UserDaoImpl();
        user=new User();
        user.setPassword("123456");
        user.setUsername("whd");
        user.setEmail("841417348@qq.com");
        user.setImage("/hiahfoasf");
        user.setPhone("15869107523");
    }

    @Test
    public void insertUser() {
        userDao.insertUser(user);
    }

    @Test
    public void selectUserByUsername() {
        System.out.println(userDao.selectUserByUsername("whd"));
    }

    @Test
    public void selectByEmail() {
        System.out.println(userDao.selectByEmail("841417348@qq.com"));
    }

    @Test
    public void selectByPhone() {
        System.out.println(userDao.selectByPhone("15869107523"));
    }

    @Test
    public void updateUser() {
        user=userDao.selectUserByUsername("whd");
        user.setUsername("whd1");
        userDao.updateUser(user);
    }

    @Test
    public void selectUserById() {
        System.out.println(userDao.selectUserById(7));
    }

    @Test
    public void updateImage() {
        userDao.updateImage("/var/www/html",7);
    }
}