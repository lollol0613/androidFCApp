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

public class RemoveFriend extends AppCompatActivity implements View.OnClickListener {
    ImageButton imageButton;
    public DataBaseHelper db;
    EditText name, rname, rphone, rgen, rpros, rquals, raddress;
    boolean s;
    //private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_friend);
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
                        return false;
                    }
                });
                popup.show();
            }
        });
        hbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RemoveFriend.this, FriendsConnect.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        rname = (EditText) findViewById(R.id.rname);
        rphone = (EditText) findViewById(R.id.rphone);
        raddress = (EditText) findViewById(R.id.raddress);
        rpros = (EditText) findViewById(R.id.rpros);
        rgen = (EditText) findViewById(R.id.rgen);
        rquals = (EditText) findViewById(R.id.rquals);
        name = (EditText) findViewById(R.id.nametxt);

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
        String n = name.getText().toString();
        final Friend friend = db.queryPersonByName(n);

        rname.setText(friend.getName());
        rphone.setText(friend.getPhone_number());
        rgen.setText(friend.getGender());
        rpros.setText(friend.getProfession());
        rquals.setText(friend.getQul());
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
    */
}
