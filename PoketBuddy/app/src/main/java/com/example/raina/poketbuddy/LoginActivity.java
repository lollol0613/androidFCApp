package com.example.raina.poketbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
//import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    //private ActionBar toolbar;
    Button newAccBtn, loginbtn;
    public DataBaseHelperM db;
    boolean status;
    EditText InputId, InputPw;

    //String username = "test", password = "1234";

    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //toolbar = getSupportActionBar();
        //toolbar.setElevation(0);

        db = new DataBaseHelperM (this, "FMember.db", null, 1);
        init();

        newAccBtn = (Button)findViewById(R.id.newaccbtn);

        newAccBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
                // Toast.makeText(MainActivity.this, "onclickListener function called", Toast.LENGTH_LONG).show();
            }
        });
    }
    private void init() {
        InputId = (EditText) findViewById(R.id.InputId);
        InputPw = (EditText) findViewById(R.id.InputPw);

        findViewById(R.id.loginbtn).setOnClickListener(this);
    }
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.loginbtn:
                login();
                break;
        }
    }
    public void login() {
        String username = InputId.getText().toString();
        String password = InputPw.getText().toString();
        final FMember fmember = db.queryPersonById(username);

        if(username.equals(fmember.getMid()) && password.equals(fmember.getPassword())) {
                Intent intent = new Intent (LoginActivity.this, FriendsConnect.class);
                startActivity(intent);
        } else {
                Toast.makeText(this, "Logi Failed, Try again", Toast.LENGTH_SHORT).show();
        }
    }
}
