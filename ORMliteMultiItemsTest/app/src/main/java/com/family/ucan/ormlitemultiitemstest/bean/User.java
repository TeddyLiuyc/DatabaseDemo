package com.family.ucan.ormlitemultiitemstest.bean;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by LiuYucan on 15-7-10.
 */
public class User {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "name")
    private String name;

    public User() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString(){
        return "name: "+getName();
    }
}
