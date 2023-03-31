package com.example.lnctbushelp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Management extends AppCompatActivity {
    Button frag1;
    Button frag2;
    Fragment1 fragment1;
    Fragment2 fragment2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);
        getSupportActionBar().hide();

        frag1 = findViewById(R.id.buttonFrag1);
        frag2 = findViewById(R.id.buttonFrag2);

        fragment2 = new Fragment2();
        fragment1 = new Fragment1();

        frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               replaceFragment(new Fragment1());
            }
        });

        frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new Fragment2());
            }
        });
    }

    private void replaceFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
       fragmentTransaction.replace(R.id.frameLayout,fragment);
       fragmentTransaction.commit();
    }
}