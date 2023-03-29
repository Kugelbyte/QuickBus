package com.example.lnctbushelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView textView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        getActionBar().hide();
        textView = findViewById(R.id.textView);
    }

    public void onClickBtn(View view)
    {
        String routeNum = textView.getText().toString();

        intent = new Intent(Activity2.this,Datafetch.class);
        intent.putExtra("Route_Num",Character.toString(routeNum.charAt(routeNum.length()-1)));           // wont work for route num > 9
        startActivity(intent);
    }
}