package com.example.raina.poketbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import de.hdodenhof.circleimageview.CircleImageView;

//import android.support.v7.app.ActionBar;

public class MainActivity extends AppCompatActivity {

    //private ActionBar toolbar;
    ImageButton ClickImageButton;
    Intent bg;
    CircleImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);

        //toolbar = getSupportActionBar();
        //toolbar.setElevation(0);

        image = (CircleImageView) findViewById(R.id.image);
        bg = new Intent (this, BGMusic.class);
        startService(bg);

        ClickImageButton = (ImageButton)findViewById(R.id.loginbtn);

        ClickImageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                //ActivityOptionsCompat option = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, image, ViewCompat.getTransitionName(image));
                startActivity(intent);
               // Toast.makeText(MainActivity.this, "onclickListener function called", Toast.LENGTH_LONG).show();
            }
        });
    }
}
