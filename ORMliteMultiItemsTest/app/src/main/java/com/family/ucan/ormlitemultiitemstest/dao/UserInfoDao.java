package com.family.ucan.ormlitemultiitemstest.dao;

import android.content.Context;

import com.family.ucan.ormlitemultiitemstest.bean.UserInfo;
import com.family.ucan.ormlitemultiitemstest.db.DatabaseHelper;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

/**
 * Created by LiuYucan on 15-7-9.
 */
public class UserInfoDao {
    private Context context;
    private Dao<UserInfo, Integer> userInfoDao;
    private DatabaseHelper helper;

    public UserInfoDao(Context context){
        this.context = context;
        try
        {
            helper = DatabaseHelper.getHelper(context);
            userInfoDao = helper.getDao(UserInfo.class);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void addUserInfo(UserInfo userInfo){
        try{
            userInfoDao.create(userInfo);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
