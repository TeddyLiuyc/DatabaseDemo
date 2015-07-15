package com.family.ucan.ormlitetest2;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.field.DatabaseField;

import java.sql.SQLException;


public class MainActivity extends Activity {
    UserDao userDao;
    ScoreDao scoreDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User user = new User("lalala");
        Score score = new Score(100,user);
        Log.e("new Score",score.toString());
        userDao = new UserDao(this);
        scoreDao = new ScoreDao(this);
        userDao.insert(user);
        scoreDao.insert(score);
        Log.e("TAG", userDao.query().toString());
        Log.e("TAG", scoreDao.query().toString());
        Log.e("Please success", scoreDao.getScore(8).toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
