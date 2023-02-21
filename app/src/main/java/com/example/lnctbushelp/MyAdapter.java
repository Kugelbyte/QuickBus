package com.example.lnctbushelp;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    Context context;
    ArrayList<Route> list;

    public MyAdapter(Context context, ArrayList<Route> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Route route = list.get(position);
        holder.driverName.setText(route.getDriverName());
        holder.busNumber.setText(route.getBusNumber());
        holder.contact.setText(route.getContact());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView busNumber,driverName,contact;



        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);

            busNumber = itemView.findViewById(R.id.busNumber_1);
            driverName = itemView.findViewById(R.id.driverName_1);
            contact = itemView.findViewById(R.id.contact_1);
        }
    }
}
