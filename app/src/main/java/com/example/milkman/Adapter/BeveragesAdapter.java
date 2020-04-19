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
import com.example.milkman.Models.BeveragesList;
import com.example.milkman.R;

import java.util.List;

public class BeveragesAdapter extends RecyclerView.Adapter<BeveragesAdapter.MyViewHolder> {

    private List<BeveragesList> beveragesList;
    Context context;

    public BeveragesAdapter(Context context, List<BeveragesList> list) {
        this.context=context;
        this.beveragesList=list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.beverages_list_row, viewGroup, false);
        return new BeveragesAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final BeveragesList bl = beveragesList.get(i);
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
        return beveragesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title,price;
        ImageView imageView;
        LinearLayout beverages_layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.text1);
            price=itemView.findViewById(R.id.price_beverages);
            imageView=itemView.findViewById(R.id.imgView);
            beverages_layout=itemView.findViewById(R.id.beverages_layout);
        }
    }
}
