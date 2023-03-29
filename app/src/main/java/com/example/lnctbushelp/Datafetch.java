package com.example.lnctbushelp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Datafetch extends AppCompatActivity {


    RecyclerView recyclerView;
    DatabaseReference reference;
    MyAdapter myAdapter;
    ArrayList<Route> list;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datafetch);
        getActionBar().hide();

        intent = getIntent();
        String routeNum = intent.getStringExtra("Route_Num");
        Toast.makeText(Datafetch.this,routeNum,Toast.LENGTH_LONG).show();
        recyclerView = findViewById(R.id.userList);
        reference = FirebaseDatabase.getInstance().getReference(routeNum);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        myAdapter = new MyAdapter(this,list);

        recyclerView.setAdapter(myAdapter);



        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                   /* for(DataSnapshot dataSnapshot : snapshot.getChildren())
                    {
                       String ma = dataSnapshot.getValue().toString();
                      String n = dataSnapshot.getKey().toString();
                       System.out.println("Driver is " + n + " " + ma);
                    }*/
                    list.clear();
                    for(DataSnapshot dataSnapshot : snapshot.getChildren())
                    {
                           Route route = new Route(dataSnapshot.getKey().toString(),dataSnapshot.child("Driver_Name").getValue().toString(),dataSnapshot.child("Contact").getValue().toString());

                           list.add(route);
                    }
                    myAdapter.notifyDataSetChanged();



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }


}