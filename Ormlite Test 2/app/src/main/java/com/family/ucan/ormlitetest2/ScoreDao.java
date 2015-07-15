package com.family.ucan.ormlitetest2;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by LiuYucan on 15-7-15.
 */
public class ScoreDao {
    Dao<Score, Integer> scoreDao;
    DatabaseHelper db;
    public ScoreDao(Context context){
        db = new DatabaseHelper(context);
        try {
            scoreDao = db.getDao(Score.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insert(Score score){
        try {
            scoreDao.create(score);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Score> query(){
        List<Score> scores =null;
        try {
            scores = scoreDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scores;
    }

    public Score getScore(int id){
        Score score1 = null;
        try {
            score1 = scoreDao.queryForId(id);
            db.getDao(User.class).refresh(score1.getUser());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return score1;
    }
}