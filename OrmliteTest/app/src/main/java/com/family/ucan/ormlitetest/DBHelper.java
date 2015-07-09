package com.family.ucan.ormlitetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.accessibility.AccessibilityManager;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by LiuYucan on 15-7-9.
 */
public class DBHelper extends OrmLiteSqliteOpenHelper {
    private static final String  DB_NAME = "ormliteTest.db";
    private static final int DB_VERSION = 1;

    private Dao<User, Integer> userDao = null;
    private RuntimeExceptionDao<User, Integer> simpleRuntimeUserDao = null;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            Log.i(DBHelper.class.getName(), "onCreate");
            Log.i("test", "name = " + DBHelper.class.getName());
            TableUtils.createTable(connectionSource, User.class);
        } catch (SQLException e) {
            Log.e(DBHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }
    }

    public void insert(User user){
        RuntimeExceptionDao<User, Integer> dao = getSimpleDataUserDao();
        //通过实体对象创建在数据库中创建一条数据，成功返回1，说明插入了一条数据
        Log.i("test", "dao = " + dao+"  user= "+user);
        int returnValue = dao.create(user);
        Log.i("test", "插入数据后返回值：" + returnValue);
    }


    /**
     * 查询所有的用户信息
     * @return
     */
    public List<User> findAllUser(){
        RuntimeExceptionDao<User, Integer> dao = getSimpleDataUserDao();
        return dao.queryForAll();
    }

    public RuntimeExceptionDao<User, Integer> getSimpleDataUserDao() {
        if (simpleRuntimeUserDao == null) {
            simpleRuntimeUserDao = getRuntimeExceptionDao(User.class);
        }
        Log.i("test", "simpleRuntimeDao ======= "+simpleRuntimeUserDao);
        return simpleRuntimeUserDao;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        Log.i("test", "更新....");
        try {
            Log.i(DBHelper.class.getName(), "onUpgrade");
            //删掉旧版本的数据
            TableUtils.dropTable(connectionSource, User.class, true);
            //创建一个新的版本
            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            Log.e(DBHelper.class.getName(), "Can't drop databases", e);
            throw new RuntimeException(e);
        }
    }
}
