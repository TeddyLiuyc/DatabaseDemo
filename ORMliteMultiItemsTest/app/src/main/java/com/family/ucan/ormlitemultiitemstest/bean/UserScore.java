package com.family.ucan.ormlitemultiitemstest.bean;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by LiuYucan on 15-7-9.
 */
public class UserScore {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "total_score")
    private int total_score;
    @DatabaseField(columnName = "today_score")
    private int today_score;
    @DatabaseField(columnName = "last_score")
    private int last_score;
    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true,
            columnName = "user_info")
    private UserInfo userInfo;

    public UserScore(){
        //default constructor
    }

    public void setId(int id){this.id = id;}
    public int getId(){return id;}
    public void setTotal_score(int total_score){this.total_score = total_score;}
    public int getTotal_score() {return total_score;}
    public void setToday_score(int today_score){this.today_score = today_score;}
    public int getToday_score(){return today_score;}
    public void setLast_score(int last_score){this.last_score = last_score;}
    public int getLast_score(){return last_score;}
    public void setUserInfo(UserInfo userInfo){this.userInfo = userInfo;}
    public UserInfo getUserInfo(){return userInfo;}

    @Override
    public String toString(){
        return userInfo.toString()+
                "Total Score: "+getTotal_score()+"\n"+
                "Today Score: "+getToday_score()+"\n"+
                "Last Score: "+getLast_score();
    }
}
