package com.example.lnctbushelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class startScreen extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        getSupportActionBar().hide();

        Button routeBtn = findViewById(R.id.button2);
        Button manageBtn = findViewById(R.id.button3);


    }

    public void onClickRouteBtn(View view) {
         intent = new Intent(startScreen.this,MainActivity.class);
        startActivity(intent);
    }


    public void onClickManageBtn(View view) {
        intent = new Intent(startScreen.this,Login.class);
        startActivity(intent);
    }
}