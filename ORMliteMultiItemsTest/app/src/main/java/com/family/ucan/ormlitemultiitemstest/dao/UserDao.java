package com.family.ucan.ormlitemultiitemstest.dao;

import android.content.Context;

import com.family.ucan.ormlitemultiitemstest.bean.User;
import com.family.ucan.ormlitemultiitemstest.db.DatabaseHelper;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

/**
 * Created by LiuYucan on 15-7-10.
 */
public class UserDao {
    private Context context;
    private Dao<User, Integer> userDaoOpe;
    private DatabaseHelper databaseHelper;

    public UserDao(Context context) {
        this.context = context;
        try {
            databaseHelper = DatabaseHelper.getHelper(context);
            userDaoOpe = databaseHelper.getDao(User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(User user) {
        try {
            userDaoOpe.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
