package com.example.raina.poketbuddy;

import android.content.Intent;
//import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class RemoveFriend extends AppCompatActivity implements View.OnClickListener {
    ImageButton imageButton;
    public DataBaseHelper db;
    boolean s;
    //private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_friend);
        //toolbar = getSupportActionBar();
        //toolbar.setElevation(0);
        db = new DataBaseHelper(this, "Friend.db", null, 1);
        init();
    }

    private void init() {
        findViewById(R.id.findbtn).setOnClickListener(this);
        findViewById(R.id.deletebtn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.findbtn:
                find();
                break;
            case R.id.deletebtn:
                delete();
                break;
        }
    }

    public void find() {
        EditText name = (EditText) findViewById(R.id.nametxt);
        String n = name.getText().toString();
        Friend friend = db.queryPersonByName(n);

        EditText rname = (EditText) findViewById(R.id.rname);
        EditText rphone = (EditText) findViewById(R.id.rphone);
        EditText raddress = (EditText) findViewById(R.id.raddress);

        rname.setText(friend.getName());
        rphone.setText(friend.getPhone_number());
        raddress.setText(friend.getAddress());
    }


    public void delete() {
        EditText name = (EditText) findViewById(R.id.nametxt);
        String n = name.getText().toString();
        s = db.delete_rec(n);
        db.close();
        if (s) {
            Toast.makeText(this, "Record Deleted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Record Not Deleted", Toast.LENGTH_SHORT).show();
        }
    }
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
                Intent intent = new Intent(RemoveFriend.this, FriendsConnect.class);
                startActivity(intent);
                break;
            }
            case R.id.add: {
                Intent intent = new Intent(RemoveFriend.this, AddFriend.class);
                startActivity(intent);
                break;
            }
            case R.id.edit: {
                Intent intent = new Intent(RemoveFriend.this, EditFriend.class);
                startActivity(intent);
                break;
            }
            case R.id.find: {
                Intent intent = new Intent(RemoveFriend.this, FindFriend.class);
                startActivity(intent);
                break;
            }
            case R.id.remove: {
                Intent intent = new Intent(RemoveFriend.this, RemoveFriend.class);
                startActivity(intent);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
