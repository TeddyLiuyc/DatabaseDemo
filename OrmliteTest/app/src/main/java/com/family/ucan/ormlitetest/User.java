package com.family.ucan.ormlitetest;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by LiuYucan on 15-7-9.
 */
public class User {
    @DatabaseField(generatedId=true)//自增长的主键
    private int id;
    @DatabaseField
    private String userName;
    @DatabaseField
    private String password;

    //必须有一个无参的构造函数
    public User() {
        super();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString(){
        return "id: "+getId()+", name: "+getUserName()+", password: "+getPassword();
    }
}
