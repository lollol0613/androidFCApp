package com.example.raina.poketbuddy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;

//import android.support.v7.app.ActionBar;

public class FindFriend extends AppCompatActivity implements View.OnClickListener {

    public DataBaseHelper db;
    boolean status;
    EditText name, rname, rphone, rsms, raddress;
    ImageView profileimg;
    public ImageButton mapbtn, callbtn, smsbtn;
    public Button findbtn;
    //private ActionBar toolbar;

    //public static final String phoneno="com.example.raina.poketbuddy.phoneno";
    //public static final String fname = "com.example.raina.poketbuddy.fname";

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
        /*
        findbtn = (Button) findViewById(R.id.findbtn);
        findbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText) findViewById(R.id.nametxt);
                String n = name.getText().toString();

                Friend friend = db.queryPersonByName(n);

                if(friend.getstatus()) {
                    EditText rname = (EditText) findViewById(R.id.rname);
                    EditText rphone = (EditText) findViewById(R.id.rphone);
                    EditText raddress = (EditText) findViewById(R.id.raddress);

                    rname.setText(friend.getName());
                    rphone.setText(friend.getPhone_number());
                    raddress.setText(friend.getAddress());

                } else {
                    Toast.makeText(FindFriend.this, "Record Not Found", Toast.LENGTH_SHORT).show();
                }
            }
        });*/

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
        mapbtn = (ImageButton) findViewById(R.id.map);
        callbtn = (ImageButton)findViewById(R.id.call);
        smsbtn = (ImageButton) findViewById(R.id.sms);

        rphone= (EditText) findViewById(R.id.rphone);
        Intent intent = getIntent();

        callbtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:+64-"+rphone.getText().toString()));
                startActivity(intent);
            }
        });
        smsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:+64-"+rphone.getText().toString()));
                intent.putExtra("sms_body", "The SMS text here");
                startActivity(intent);
            }
        });
        mapbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindFriend.this, MapsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        rname = (EditText) findViewById(R.id.rname);
        rphone = (EditText) findViewById(R.id.rphone);
        rsms = (EditText) findViewById(R.id.rsms);
        raddress = (EditText) findViewById(R.id.raddress);
        name = (EditText) findViewById(R.id.nametxt);
        profileimg = (ImageView) findViewById(R.id.profilepc);

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

        profileimg.setImageResource(R.drawable.common);
        rname.setText(friend.getName());
        rphone.setText(friend.getPhone_number());
        rsms.setText(friend.getPhone_number());
        raddress.setText(friend.getAddress());

            //String pno = rphone.getText().toString();
            //String n1 = rname.getText().toString();
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
