package com.example.milkman.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.milkman.Activity.CartActivity;
import com.example.milkman.Activity.Milk_Activity;
import com.example.milkman.Models.MilkList;
import com.example.milkman.R;

import java.util.ArrayList;
import java.util.List;

public class MilkAdapter extends RecyclerView.Adapter<MilkAdapter.MyViewHolder> {

    private List<MilkList> milkList ;
    private Context context;

    public MilkAdapter(Context context, List<MilkList> list) {
        this.milkList=list;
        this.context=context;
    }

    @NonNull
    @Override
    public MilkAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.milk_list_row, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MilkAdapter.MyViewHolder myViewHolder, final int i) {
        final MilkList ml=milkList.get(i);
        myViewHolder.title.setText(ml.getTitle());
        myViewHolder.price.setText(ml.getPrice());
        Glide.with(context)
                .load(ml.getImageUrl())
                .centerCrop()
                .placeholder(R.mipmap.final_icon)
                .into(myViewHolder.imageView);

        myViewHolder.addcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context.getApplicationContext(),"Added to Cart", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return milkList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title,price;
        public ImageView imageView;
        LinearLayout milk_layout;
        Button addcart;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.text1);
            price=itemView.findViewById(R.id.price_milk);
            imageView = itemView.findViewById(R.id.imgView);
            milk_layout = itemView.findViewById(R.id.account_layout);
            addcart=itemView.findViewById(R.id.cartm);
        }
    }

}
