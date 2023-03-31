package com.example.lnctbushelp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    ScrollView sl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        sl = findViewById(R.id.mainScrollView);
        linearLayout = findViewById(R.id.mainLinearLayout);


        setSingleEvent(linearLayout);


    }

    private void setSingleEvent(LinearLayout linearLayout)
    {

        for(int i = 0; i < linearLayout.getChildCount();i++)
        {
            CardView cardView = (CardView)linearLayout.getChildAt(i);
            final int idx = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent;
                    switch (idx)
                    {
                        case 0:
                                intent = new Intent(MainActivity.this,Activity0.class);
                                startActivity(intent);
                                break;
                        case 1:
                                Toast.makeText(MainActivity.this,"Information is unavailable at the moment",Toast.LENGTH_SHORT).show();
                               /* intent = new Intent(MainActivity.this,activity_1.class);
                                startActivity(intent);*/
                                break;
                        case 2:
                                Toast.makeText(MainActivity.this,"Information is unavailable at the moment",Toast.LENGTH_SHORT).show();
                                /*intent = new Intent(MainActivity.this,Activity2.class);
                                startActivity(intent);*/
                                break;
                    }
                }
            });
        }
    }


}