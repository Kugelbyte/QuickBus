package com.example.lnctbushelp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity0 extends AppCompatActivity {
    Intent intent;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_0);
        textView = findViewById(R.id.textViewRouteNum);
    }


    public void onClickBtn(View view) {
            String routeNum = textView.getText().toString();
            intent = new Intent(Activity0.this,Datafetch.class);
            intent.putExtra("Route_Num",Character.toString(routeNum.charAt(routeNum.length()-1)));           // wont work for route num > 9
            startActivity(intent);
    }
}