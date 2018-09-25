package com.tedu.dao.Impl;

import com.tedu.dao.UserDao;
import com.tedu.dao.mapping.UserMapping;
import com.tedu.entity.User;
import com.tedu.utils.Operation;
import com.tedu.utils.utils.BaseEntityUtils;
import com.tedu.utils.utils.SqlUtils;

import java.util.Objects;

public class UserDaoImpl implements UserDao {
    private Operation operation;

    public UserDaoImpl() {
        this.operation = new Operation();
    }

    @Override
    public void insertUser(User user) {
        if(Objects.isNull(user.getId())){
            String sql= SqlUtils.insertSql(user);
            Object[] paramters=BaseEntityUtils.getFieldsValues(user).toArray();
            operation.update(sql,paramters,true);
        }
    }

    @Override
    public User selectUserByUsername(String username) {
        String sql="select * from t_user where username='"+username+"'";
        return (User) operation.find(sql,new Object[]{},new UserMapping());
    }

    @Override
    public Integer selectByEmail(String email) {
        String sql="select count(*) as count from t_user where email='"+email+"'";
        return operation.count(sql,new Object[]{});
    }

    @Override
    public Integer selectByPhone(String phone) {
        String sql="select count(*) as count from t_user where phone='"+phone+"'";
        return operation.count(sql,new Object[]{});
    }

    @Override
    public void updateUser(User user) {
        String sql=SqlUtils.updateSql(user);
        Object[] parameters= BaseEntityUtils.getFieldsValues(user).toArray();
        operation.update(sql,parameters,false);
    }

    @Override
    public User selectUserById(Integer id) {
        String sql="select count(*) as count from t_user where id="+id;
        return (User) operation.find(sql,new Object[]{}, new UserMapping());
    }

    @Override
    public void updateImage(String image, Integer id) {
        String sql="update t_user set image=? where id=?";
        operation.update(sql,new Object[]{image,id},false);
    }
}
