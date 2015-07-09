package com.family.ucan.ormlitemultiitemstest.bean;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by LiuYucan on 15-7-9.
 */
public class UserInfo {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "user_name")
    private String name;
    @DatabaseField(columnName = "user_sex")
    private String sex;
    @DatabaseField(columnName = "user_age")
    private int age;

    public UserInfo(){
        //default constructor
    }

    public void setId(int id){this.id = id;}
    public int getId(){return this.id;}
    public void setName(String name){this.name = name;}
    public String getName(){return this.name;}
    public void setSex(String sex){this.sex = sex;}
    public String getSex(){return this.sex;}
    public void setAge(int age){this.age = age;}
    public int getAge(){return age;}
    @Override
    public String toString(){
        return "Name: "+getName()+"\n"+
                "Sex: "+getSex()+"\n"+
                "Age: "+getAge()+"\n";
    }
}
