package com.family.ucan.ormlitetest;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    DBHelper dbHelper = new DBHelper(this);
    Button add;
    TextView display;
    EditText name;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = (Button)findViewById(R.id.add);
        display = (TextView)findViewById(R.id.display);
        name = (EditText)findViewById(R.id.name);
        password = (EditText)findViewById(R.id.password);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!name.getText().toString().equals("") && !password.getText().toString().equals("")) {
                    User aaa = new User();
                    aaa.setUserName(name.getText().toString());
                    aaa.setPassword(password.getText().toString());
                    dbHelper.insert(aaa);
                    Toast.makeText(MainActivity.this, "成功加入" + name.getText().toString(),
                            Toast.LENGTH_SHORT).show();
                    display.setText(dbHelper.findAllUser().get(1).toString());
                }
            }
        });
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
