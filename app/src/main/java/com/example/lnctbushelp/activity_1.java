package com.example.lnctbushelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_1 extends AppCompatActivity {
    Button btn;
    TextView txtView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        txtView = findViewById(R.id.textView);
        btn = findViewById(R.id.button);


    }

   public void onClickBtn(View view)
   {
       String routeNum = txtView.getText().toString();

       intent = new Intent(activity_1.this,Datafetch.class);
       intent.putExtra("Route_Num",Character.toString(routeNum.charAt(routeNum.length()-1)));           // wont work for route num > 9
       startActivity(intent);
   }
}