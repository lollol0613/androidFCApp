package com.example.raina.poketbuddy;

import android.content.Intent;
import android.net.Uri;
//import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class FriendsConnect extends AppCompatActivity {

    //private ActionBar toolbar;
    //ImageButton callic, smsic, mapic;
    RecyclerView recyclerView;
    FriendListAdapter friendAdapter;
    ArrayList<Friend> userList = new ArrayList<Friend>();

    public DataBaseHelper db;

    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_connect2);
        //toolbar = getSupportActionBar();
        //toolbar.setElevation(0);

        db = new DataBaseHelper(this, "Friend.db", null, 1);
        userList = db.getAllFriend();

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        friendAdapter = new FriendListAdapter(userList);

        recyclerView.setAdapter(friendAdapter);
        friendAdapter.setOnItemClickListener(new FriendListAdapter.ClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Friend friend = FriendsConnect.this.userList.get(position);
                Toast.makeText(FriendsConnect.this, "You clicked on : " + friend.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View v, int Position) {

            }
        });
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
                                Intent intent = new Intent(FriendsConnect.this, AddFriend.class);
                                startActivity(intent);
                                return true;
                            }
                            case R.id.edit: {
                                Intent intent = new Intent(FriendsConnect.this, EditFriend.class);
                                startActivity(intent);
                                return true;
                            }
                            case R.id.find: {
                                Intent intent = new Intent(FriendsConnect.this, FindFriend.class);
                                startActivity(intent);
                                return true;
                            }
                            case R.id.remove: {
                                Intent intent = new Intent(FriendsConnect.this, RemoveFriend.class);
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
                Intent intent = new Intent(FriendsConnect.this, FriendsConnect.class);
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
                Intent intent = new Intent(FriendsConnect.this, FriendsConnect.class);
                startActivity(intent);
                return true;
            }
            case R.id.add: {
                Intent intent = new Intent(FriendsConnect.this, AddFriend.class);
                startActivity(intent);
                return true;
            }
            case R.id.edit: {
                Intent intent = new Intent(FriendsConnect.this, EditFriend.class);
                startActivity(intent);
                return true;
            }
            case R.id.find: {
                Intent intent = new Intent(FriendsConnect.this, FindFriend.class);
                startActivity(intent);
                return true;
            }
            case R.id.remove: {
                Intent intent = new Intent(FriendsConnect.this, RemoveFriend.class);
                startActivity(intent);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }*/
}
