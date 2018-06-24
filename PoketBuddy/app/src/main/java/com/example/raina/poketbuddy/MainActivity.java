package com.example.raina.poketbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
//import android.support.v7.app.ActionBar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //private ActionBar toolbar;
    ImageButton ClickImageButton;
    Intent bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);

        //toolbar = getSupportActionBar();
        //toolbar.setElevation(0);

        bg = new Intent (this, BGMusic.class);
        startService(bg);

        ClickImageButton = (ImageButton)findViewById(R.id.loginbtn);

        ClickImageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
               // Toast.makeText(MainActivity.this, "onclickListener function called", Toast.LENGTH_LONG).show();
            }
        });
    }
}
