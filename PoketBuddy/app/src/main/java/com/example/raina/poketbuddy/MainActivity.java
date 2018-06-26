package com.example.raina.poketbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageButton ClickImageButton;
    Intent bg;
    ImageView image;

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
        image = (ImageView)findViewById(R.id.image);

        ClickImageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                ActivityOptionsCompat option = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, image, ViewCompat.getTransitionName(image));
                startActivity(intent, option.toBundle());
               // Toast.makeText(MainActivity.this, "onclickListener function called", Toast.LENGTH_LONG).show();
            }
        });
    }
}
