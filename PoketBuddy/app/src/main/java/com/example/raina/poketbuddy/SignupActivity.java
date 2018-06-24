package com.example.raina.poketbuddy;


import android.content.Intent;
//import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    //private ActionBar toolbar;
    public DataBaseHelperM db;

    EditText InputName;
    EditText InputEmail;
    EditText InputContact;
    EditText InputId;
    EditText InputPw;

    Button signupbtn;
    Button cancelbtn;
    ImageButton homebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //toolbar = getSupportActionBar();
        //toolbar.setElevation(0);

        db = new DataBaseHelperM(this, "FMember.db", null, 1);
        init();
    }

    private void init() {
        findViewById(R.id.signupbtn).setOnClickListener(this);
        findViewById(R.id.cancelbtn).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.signupbtn:
                insert();
                break;
            case R.id.cancelbtn:
                clear();
                break;
            case R.id.homebtn:
                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
    public void insert()
    {
        InputName = (EditText) findViewById(R.id.InputName);
        InputEmail = (EditText) findViewById(R.id.InputEmail);
        InputContact = (EditText) findViewById(R.id.InputContact);
        InputId = (EditText)findViewById(R.id.InputId);
        InputPw = (EditText)findViewById(R.id.InputPw);
        String mname = InputName.getText().toString();
        String memail = InputEmail.getText().toString();
        String mcontact = InputContact.getText().toString();
        String mid = InputId.getText().toString();
        String mpw = InputPw.getText().toString();

        boolean status =  db.saver(mname, memail, mcontact, mid, mpw);
        if(status)
            Toast.makeText(this,"Finished Sign up",Toast.LENGTH_SHORT).show();
        clear();
    }

    public void clear()
    {
        InputName = (EditText) findViewById(R.id.InputName);
        InputEmail = (EditText) findViewById(R.id.InputEmail);
        InputContact = (EditText) findViewById(R.id.InputContact);
        InputId = (EditText)findViewById(R.id.InputId);
        InputPw = (EditText)findViewById(R.id.InputPw);

        InputName.setText("");
        InputEmail.setText("");
        InputContact.setText("");
        InputId.setText("");
        InputPw.setText("");
    }
}
