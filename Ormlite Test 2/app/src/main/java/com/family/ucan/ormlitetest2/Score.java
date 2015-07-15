package com.family.ucan.ormlitetest2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by LiuYucan on 15-7-15.
 */
@DatabaseTable(tableName = "tb_score")
public class Score {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "score")
    private int score;
    @DatabaseField(canBeNull = false, foreign = true, columnName = "user")
    private User user;
    public Score(){

    }
    public Score(int score, User user){
        this.user = user;
        this.score = score;
    }
    public void setScore(int score){
        this.score = score;
    }
    public int getScore(){
        return this.score;
    }
    public User getUser(){
        return this.user;
    }
    public void setUser(User user){
        this.user = user;
    }
    @Override
    public String toString(){
        return getUser().toString()+"\nScore: "+getScore()+"\n";
    }
}
