package com.family.ucan.ormlitemultiitemstest.dao;

import android.content.Context;
import com.family.ucan.ormlitemultiitemstest.bean.Sentence;
import com.family.ucan.ormlitemultiitemstest.bean.User;
import com.family.ucan.ormlitemultiitemstest.db.DatabaseHelper;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by LiuYucan on 15-7-10.
 */
public class SentenceDao {
    private Dao<Sentence, Integer> sentenceDaoOpe;
    private DatabaseHelper databaseHelper;

    public SentenceDao(Context context) {
        try {
            databaseHelper = DatabaseHelper.getHelper(context);
            sentenceDaoOpe = databaseHelper.getDao(Sentence.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(Sentence sentence) {
        try {
            sentenceDaoOpe.create(sentence);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Sentence getSentenceWithUser(int id) {
        Sentence sentence = null;
        try {
            sentence = sentenceDaoOpe.queryForId(id);
            databaseHelper.getDao(User.class).refresh(sentence.getUser());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sentence;
    }

    public Sentence get(int id) {
        Sentence sentence = null;
        try {
            sentence = sentenceDaoOpe.queryForId(id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sentence;
    }

    public List<Sentence> listByUserId(int userId) {
        try {
            return sentenceDaoOpe.queryBuilder().where().eq("user_id", userId)
                    .query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
