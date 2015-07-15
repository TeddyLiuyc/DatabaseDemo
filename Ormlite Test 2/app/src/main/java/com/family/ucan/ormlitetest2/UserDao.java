package com.family.ucan.ormlitetest2;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by LiuYucan on 15-7-15.
 */
public class UserDao {
    Dao<User, Integer> userDao;
    DatabaseHelper db;
    public UserDao(Context context) {
        db = new DatabaseHelper(context);
        try {
            userDao = db.getDao(User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insert(User user){
        try {
            userDao.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<User> query(){
        List<User> users = null;
        try {
            users = userDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

}
