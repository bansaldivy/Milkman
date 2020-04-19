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
import com.example.milkman.Models.GroceryList;
import com.example.milkman.R;

import java.util.List;

public class GroceryAdapter extends RecyclerView.Adapter<GroceryAdapter.MyViewHolder> {
    private List<GroceryList> groceryList;
    private Context context;

    public GroceryAdapter(Context context,List<GroceryList> list){
        this.context=context;
        this.groceryList=list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grocery_list_row, viewGroup, false);
        return new GroceryAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final GroceryList gl = groceryList.get(i);
        myViewHolder.title.setText(gl.getTitle());
        myViewHolder.price.setText(gl.getPrice());
        Glide.with(context)
                .load(gl.getImageUrl())
                .centerCrop()
                .placeholder(R.mipmap.final_icon)
                .into(myViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return groceryList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView title, price;
        public ImageView imageView;
        LinearLayout grocery_layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.text1);
            imageView=itemView.findViewById(R.id.imgView);
            price=itemView.findViewById(R.id.price_grocery);
            grocery_layout=itemView.findViewById(R.id.grocery_layout);
        }
    }
}
