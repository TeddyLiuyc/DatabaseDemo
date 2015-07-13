package com.family.ucan.ormlitemultiitemstest.bean;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by LiuYucan on 15-7-10.
 */
public class Sentence {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "sentence")
    private String sentence;
    @DatabaseField(canBeNull = false, foreign = true, columnName = "user")
    private User user;

    public Sentence() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return this.sentence;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    @Override
    public String toString() {
        return "sentence: "+getSentence()+"User: "+getUser().toString();
    }
}
