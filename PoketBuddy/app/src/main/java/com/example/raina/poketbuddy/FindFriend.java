package com.example.raina.poketbuddy;

import android.content.Intent;
//import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class FindFriend extends AppCompatActivity implements View.OnClickListener {

    public DataBaseHelper db;
    boolean status;
    EditText rphone, raddress,name;
    TextView rname;
    //private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_friend);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
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
                                Intent intent = new Intent(FindFriend.this, AddFriend.class);
                                startActivity(intent);
                                return true;
                            }
                            case R.id.edit: {
                                Intent intent = new Intent(FindFriend.this, EditFriend.class);
                                startActivity(intent);
                                return true;
                            }
                            case R.id.find: {
                                Intent intent = new Intent(FindFriend.this, FindFriend.class);
                                startActivity(intent);
                                return true;
                            }
                            case R.id.remove: {
                                Intent intent = new Intent(FindFriend.this, RemoveFriend.class);
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
                Intent intent = new Intent(FindFriend.this, FriendsConnect.class);
                startActivity(intent);
            }
        });
    }
    private void init() {
        rname = (TextView) findViewById(R.id.rname);
        rphone = (EditText) findViewById(R.id.rphone);
        raddress = (EditText) findViewById(R.id.raddress);
        name = (EditText) findViewById(R.id.nametxt);

        findViewById(R.id.findbtn).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.findbtn:
                find();
                break;
        }
    }
    public void find() {
        String n = name.getText().toString();
        final Friend friend = db.queryPersonByName(n);

        rname.setText(friend.getName());
        rphone.setText(friend.getPhone_number());
        raddress.setText(friend.getAddress());
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
                Intent intent = new Intent(FindFriend.this, FriendsConnect.class);
                startActivity(intent);
                break;
            }
            case R.id.add: {
                Intent intent = new Intent(FindFriend.this, AddFriend.class);
                startActivity(intent);
                break;
            }
            case R.id.edit: {
                Intent intent = new Intent(FindFriend.this, EditFriend.class);
                startActivity(intent);
                break;
            }
            case R.id.find: {
                Intent intent = new Intent(FindFriend.this, FindFriend.class);
                startActivity(intent);
                break;
            }
            case R.id.remove: {
                Intent intent = new Intent(FindFriend.this, RemoveFriend.class);
                startActivity(intent);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }*/
}
