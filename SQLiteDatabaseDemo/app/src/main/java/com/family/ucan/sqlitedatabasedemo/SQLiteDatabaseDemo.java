package com.family.ucan.sqlitedatabasedemo;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class SQLiteDatabaseDemo extends Activity implements AdapterView.OnItemClickListener {
    private UserDB userDB;
    private Cursor mCursor;
    private EditText UserName;
    private EditText UserSex;
    private EditText UserAge;
    private ListView UsersList;

    private int USER_ID = 0;
    protected final static int MENU_ADD = Menu.FIRST;
    protected final static int MENU_DELETE = Menu.FIRST + 1;
    protected final static int MENU_UPDATE = Menu.FIRST + 2;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setUpViews();
    }

    public void setUpViews() {
        userDB = new UserDB(this);
        mCursor = userDB.select();

        UserName = (EditText) findViewById(R.id.username);
        UserSex = (EditText) findViewById(R.id.sex);
        UserAge = (EditText) findViewById(R.id.age);
        UsersList = (ListView) findViewById(R.id.userslist);

        UsersList.setAdapter(new BooksListAdapter(this, mCursor));
        UsersList.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(Menu.NONE, MENU_ADD, 0, "ADD");
        menu.add(Menu.NONE, MENU_DELETE, 0, "DELETE");
        menu.add(Menu.NONE, MENU_UPDATE, 0, "UPDATE");
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case MENU_ADD:
                add();
                break;
            case MENU_DELETE:
                delete();
                break;
            case MENU_UPDATE:
                update();
                break;
        }
        return true;
    }

    public void add() {
        String userName = UserName.getText().toString();
        int userAge = Integer.valueOf(UserAge.getText().toString());
        String userSex = UserSex.getText().toString();
        if (userName.equals("") || userSex.equals("")) {
            return;
        }
        userDB.insert(userName, userAge, userSex);
        mCursor.requery();
        UsersList.invalidateViews();
        UserName.setText("");
        UserAge.setText("");
        UserSex.setText("");
        Toast.makeText(this, "Add Successed!", Toast.LENGTH_SHORT).show();
    }

    public void delete() {
        if (!UserName.getText().equals("")){
            userDB.delete(UserName.getText().toString());
            Toast.makeText(this, "by name", Toast.LENGTH_SHORT).show();
        }
        else{
            if (USER_ID == 0) {
                return;
            }
            userDB.delete(USER_ID);
        }
        mCursor.requery();
        UsersList.invalidateViews();
        UserName.setText("");
        UserAge.setText("");
        UserSex.setText("");
        Toast.makeText(this, "Delete Successed!", Toast.LENGTH_SHORT).show();
    }

    public void update() {
        String userName = UserName.getText().toString();
        int userAge = Integer.valueOf(UserAge.getText().toString());
        String userSex = UserSex.getText().toString();
        if (userName.equals("") || userSex.equals("")) {
            return;
        }
        userDB.update(USER_ID, userName,userAge, userSex);
        mCursor.requery();
        UsersList.invalidateViews();
        UserName.setText("");
        UserAge.setText("");
        UserSex.setText("");
        Toast.makeText(this, "Update Successed!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        mCursor.moveToPosition(position);
        USER_ID = mCursor.getInt(0);
        UserName.setText(mCursor.getString(1));
        UserAge.setText(mCursor.getString(2));
        UserSex.setText(mCursor.getString(3));

    }

    public class BooksListAdapter extends BaseAdapter {
        private Context mContext;
        private Cursor mCursor;

        public BooksListAdapter(Context context, Cursor cursor) {

            mContext = context;
            mCursor = cursor;
        }

        @Override
        public int getCount() {
            return mCursor.getCount();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView mTextView = new TextView(mContext);
            mCursor.moveToPosition(position);
            mTextView.setText(mCursor.getString(1) + "___" + mCursor.getString(2)+ "___" + mCursor.getString(3));
            return mTextView;
        }

    }
}
