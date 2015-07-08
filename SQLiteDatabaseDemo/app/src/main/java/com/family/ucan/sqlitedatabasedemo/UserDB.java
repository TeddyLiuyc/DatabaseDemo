package com.family.ucan.sqlitedatabasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by LiuYucan on 15-7-7.
 */
public class UserDB extends SQLiteOpenHelper {
    private final static String DATABASE_NAME = "UserDB.db";
    private final static int DATABASE_VERSION = 1;
    private final static String TABLE_NAME = "users_table";
    public final static String USER_ID = "user_id";
    public final static String USER_NAME = "user_name";
    public final static String USER_SEX = "user_sex";
    public final static String USER_AGE = "user_age";

    public UserDB(Context context) {
        // TODO Auto-generated constructor stub
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //创建table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + USER_ID
                + " INTEGER primary key autoincrement, " + USER_NAME
                + " text, "+ USER_AGE
                + " integer, "+ USER_SEX +" text);";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }

    public Cursor select() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db
                .query(TABLE_NAME, null, null, null, null, null, null);
        return cursor;
    }
    //增加操作
    public long insert(String userName,int age, String sex)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        /* ContentValues */
        ContentValues cv = new ContentValues();
        cv.put(USER_NAME, userName);
        cv.put(USER_AGE, age);
        cv.put(USER_SEX, sex);
        long row = db.insert(TABLE_NAME, null, cv);
        return row;
    }
    //删除操作
    public void delete(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String where = USER_ID + " = ?";
        String[] whereValue ={ Integer.toString(id) };
        db.delete(TABLE_NAME, where, whereValue);
    }
    // delete the list by s
    public void delete(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String where = USER_NAME + " = ?";
        String[] whereValue ={ name };
        db.delete(TABLE_NAME, where, whereValue);
    }
    //修改操作
    public void update(int id, String userName,int age, String sex)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String where = USER_ID + " = ?";
        String[] whereValue = { Integer.toString(id) };

        ContentValues cv = new ContentValues();
        cv.put(USER_NAME, userName);
        cv.put(USER_AGE, age);
        cv.put(USER_SEX, sex);
        db.update(TABLE_NAME, cv, where, whereValue);
    }
}
