package com.example.milkman.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.milkman.Models.BakeryList;
import com.example.milkman.R;

import java.util.List;

public class BakeryAdapter extends RecyclerView.Adapter<BakeryAdapter.MyViewHolder> {

    private List<BakeryList> bakeryList;
    private Context context;

    public BakeryAdapter(Context context, List<BakeryList> list) {
        this.bakeryList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bakery_list_row, viewGroup, false);
        return new BakeryAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final BakeryList bl = bakeryList.get(i);
        myViewHolder.title.setText(bl.getTitle());
        myViewHolder.price.setText(bl.getPrice());
        Glide.with(context)
                .load(bl.getImageUrl())
                .centerCrop()
                .placeholder(R.mipmap.final_icon)
                .into(myViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return bakeryList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title, price;
        public ImageView imageView;
        LinearLayout bakery_layout;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.text1);
            price = itemView.findViewById(R.id.price_bakery);
            imageView = itemView.findViewById(R.id.imgView);
            bakery_layout = itemView.findViewById(R.id.bakery_layout);
        }
    }

}
