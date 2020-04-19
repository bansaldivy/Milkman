package com.example.milkman.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.milkman.Activity.Bakery_Activity;
import com.example.milkman.Activity.Beverages_Activity;
import com.example.milkman.Activity.Grocery_Activity;
import com.example.milkman.Activity.Milk_Activity;
import com.example.milkman.Activity.Personal_Activity;
import com.example.milkman.Activity.Religious_Activity;
import com.example.milkman.Models.HomeList;
import com.example.milkman.R;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    private List<HomeList> homeList;
    Context context;

    public HomeAdapter(Context context, List<HomeList> list) {
        this.homeList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_list_row, viewGroup, false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.MyViewHolder myViewHolder, int i) {
        final HomeList acc = homeList.get(i);
        myViewHolder.title.setText(acc.getTitle());
        Glide.with(context)
                .load(acc.getImageUrl())
                .centerCrop()
                .placeholder(R.mipmap.final_icon)
                .into(myViewHolder.imageView);

        myViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (acc.getTitle().equals("Dairy")) {
                    Intent intent = new Intent(context.getApplicationContext(), Milk_Activity.class);
                    context.startActivity(intent);
                } else if (acc.getTitle().equals("Bakery")) {
                    Intent intent = new Intent(context.getApplicationContext(), Bakery_Activity.class);
                    context.startActivity(intent);
                } else if (acc.getTitle().equals("Religious")) {
                    Intent intent = new Intent(context.getApplicationContext(), Religious_Activity.class);
                    context.startActivity(intent);
                } else if (acc.getTitle().equals("Personal care")) {
                    Intent intent = new Intent(context.getApplicationContext(), Personal_Activity.class);
                    context.startActivity(intent);
                } else if (acc.getTitle().equals("Grocery & Staples")) {
                    Intent intent = new Intent(context.getApplicationContext(), Grocery_Activity.class);
                    context.startActivity(intent);
                } else if (acc.getTitle().equals("Beverages")){
                    Intent intent = new Intent(context.getApplicationContext(), Beverages_Activity.class);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return homeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView imageView;
        LinearLayout linearLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.home_title);
            imageView = itemView.findViewById(R.id.home_image);
            linearLayout = itemView.findViewById(R.id.home_layout);
        }

    }
}
