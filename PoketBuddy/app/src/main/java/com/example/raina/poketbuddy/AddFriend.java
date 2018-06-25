package com.example.raina.poketbuddy;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

//import android.support.v7.app.ActionBar;

public class AddFriend extends AppCompatActivity implements View.OnClickListener{

    public DataBaseHelper db;
    //private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);
        //toolbar = getSupportActionBar();
        //toolbar.setElevation(0);

        db = new DataBaseHelper(this, "Friend.db", null, 1);
        init();

        ImageButton hbtn = (ImageButton) findViewById(R.id.homebtn);
        ImageButton btn = (ImageButton) findViewById(R.id.menubtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup=new PopupMenu(getApplicationContext(),v);

                getMenuInflater().inflate(R.menu.friendsmenu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        switch (id) {
                            /*
                            case R.id.home: {
                                Intent intent = new Intent(FriendsConnect.this, FriendsConnect.class);
                                startActivity(intent);
                                return true;
                            }*/
                            case R.id.add: {
                                Intent intent = new Intent(AddFriend.this, AddFriend.class);
                                startActivity(intent);
                                return true;
                            }
                            case R.id.edit: {
                                Intent intent = new Intent(AddFriend.this, EditFriend.class);
                                startActivity(intent);
                                return true;
                            }
                            case R.id.find: {
                                Intent intent = new Intent(AddFriend.this, FindFriend.class);
                                startActivity(intent);
                                return true;
                            }
                            case R.id.remove: {
                                Intent intent = new Intent(AddFriend.this, RemoveFriend.class);
                                startActivity(intent);
                                return true;
                            }
                        }
                        return false;
                    }
                });
                popup.show();
            }
        });
        hbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddFriend.this, FriendsConnect.class);
                startActivity(intent);
            }
        });
    }
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.friendsmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.home: {
                Intent intent = new Intent(AddFriend.this, FriendsConnect.class);
                startActivity(intent);
                break;
            }
            case R.id.add: {
                Intent intent = new Intent(AddFriend.this, AddFriend.class);
                startActivity(intent);
                break;
            }
            case R.id.edit: {
                Intent intent = new Intent(AddFriend.this, EditFriend.class);
                startActivity(intent);
                break;
            }
            case R.id.find: {
                Intent intent = new Intent(AddFriend.this, FindFriend.class);
                startActivity(intent);
                break;
            }
            case R.id.remove: {
                Intent intent = new Intent(AddFriend.this, RemoveFriend.class);
                startActivity(intent);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }*/
    private void init() {
        findViewById(R.id.adbtn).setOnClickListener(this);
        findViewById(R.id.ccbtn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.adbtn:
                insert();
                break;
            case R.id.ccbtn:
                clear();
                break;
        }
    }
    public void insert()
    {
        EditText fname = (EditText) findViewById(R.id.fName);
        EditText phone = (EditText) findViewById(R.id.phone);
        EditText gender = (EditText) findViewById(R.id.gender);
        EditText qualification = (EditText)findViewById(R.id.qlf);
        EditText profession = (EditText)findViewById(R.id.pf);
        EditText address = (EditText)findViewById(R.id.address);
        String names = fname.getText().toString();
        String phones = phone.getText().toString();
        String genders = gender.getText().toString();
        String qlfs = qualification.getText().toString();
        String pros = profession.getText().toString();
        String adds = address.getText().toString();

        boolean status =  db.saver(names,phones,genders,qlfs,pros,adds);

        if(status)
            Toast.makeText(this,"Record Inserted",Toast.LENGTH_SHORT).show();

    }

    public void clear()
    {
        EditText fname = (EditText) findViewById(R.id.fName);
        EditText phone = (EditText) findViewById(R.id.phone);
        EditText gender = (EditText) findViewById(R.id.gender);
        EditText qualification = (EditText)findViewById(R.id.qlf);
        EditText profession = (EditText)findViewById(R.id.pf);
        EditText address = (EditText)findViewById(R.id.address);

        fname.setText("");
        phone.setText("");
        gender.setText("");
        qualification.setText("");
        profession.setText("");
        address.setText("");
    }
}

