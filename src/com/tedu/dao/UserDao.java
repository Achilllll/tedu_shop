package com.tedu.dao;

import com.tedu.entity.User;

/**
 * 对用户管理模块的持久层完成数据库的操作
 * @author Wanghuidi
 */
public interface UserDao {

    /**
     * 向数据库插入数据
     * @param user
     */
    void insertUser(User user);

    /**
     * 通过用户名查询
     * @param username 用户名
     * @return 如果查询数据库有此用户名，返回user对象，如果没有，则返回null
     */
    User selectUserByUsername(String username);

    /**
     * 通过邮箱查询
     * @param email
     * @return 如果email存在返回1，否则返回0
     */
    Integer selectByEmail(String email);

    /**
     * 通过手机号查询
     * @param phone
     * @return 如果有返回1，否则返回0
     */
    Integer selectByPhone(String phone);

    /**
     * 修改用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 通过id查询用户信息（修改用户信息时使用）
     * @param id
     * @return
     */
    User selectUserById(Integer id);

    /**
     * 修改头像
     * @param image
     * @param id
     */
    void updateImage(String image,Integer id);


}
