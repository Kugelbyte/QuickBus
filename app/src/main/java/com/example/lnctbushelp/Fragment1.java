package com.example.lnctbushelp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Fragment1 extends Fragment {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    View view;
    EditText routeNumber;
    EditText busNumber;
    EditText phoneNumber;
    EditText driverName;
    Button saveButton;
    String route_Number;
    String bus_Number;
    String phone_Number;
    String driver_Name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_1, container, false);
        firebaseDatabase = FirebaseDatabase.getInstance();
        saveButton = view.findViewById(R.id.buttonSave);
        routeNumber = view.findViewById(R.id.editTextRouteNumber);
        busNumber = view.findViewById(R.id.editTextBusNumber);
        phoneNumber = view.findViewById(R.id.editTextPhone);
        driverName = view.findViewById(R.id.editTextDriverName);






        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*route_Number = "1";
                DatabaseReference reference = firebaseDatabase.getReference();
                reference.setValue(route_Number);

                DatabaseReference myRef = firebaseDatabase.getReference(route_Number);
                myRef.setValue("MP045666");

                myRef.child("MP045666").child("Driver_Name").setValue("Rohan");
                myRef.child("MP045666").child("Contact").setValue("934567890");*/
                route_Number = routeNumber.getText().toString();
                bus_Number = busNumber.getText().toString();
                phone_Number = phoneNumber.getText().toString();
                driver_Name = driverName.getText().toString();



                DatabaseReference reference = firebaseDatabase.getReference();

                reference.push().setValue(route_Number);






                DatabaseReference check = firebaseDatabase.getReference(route_Number);

                check.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists())
                        {
                            Toast.makeText(getActivity(),"The route already exists",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            DatabaseReference myRef = firebaseDatabase.getReference(route_Number);
                            myRef.setValue(bus_Number);

                            myRef.child(bus_Number).child("Driver_Name").setValue(driver_Name);
                            myRef.child(bus_Number).child("Contact").setValue(phone_Number);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(getActivity(),""+error.toString(),Toast.LENGTH_SHORT).show();
                    }
                });






            }
        });


        return view;
    }

    private void modifyData(String route_Number)
    {




    }
}