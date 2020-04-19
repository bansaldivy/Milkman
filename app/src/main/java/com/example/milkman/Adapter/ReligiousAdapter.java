package com.example.milkman.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.milkman.Models.BakeryList;
import com.example.milkman.Models.ReligiousList;
import com.example.milkman.R;

import java.util.List;

public class ReligiousAdapter extends RecyclerView.Adapter<ReligiousAdapter.MyViewHolder> {
    private List<ReligiousList> religiousList;
    Context context;

    public ReligiousAdapter(Context context, List<ReligiousList> list) {
        this.religiousList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ReligiousAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.religious_list_row, viewGroup, false);
        return new ReligiousAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ReligiousAdapter.MyViewHolder myViewHolder, int i) {
        final ReligiousList rl = religiousList.get(i);
        myViewHolder.title.setText(rl.getTitle());
        myViewHolder.price.setText(rl.getPrice());
        Glide.with(context)
                .load(rl.getImageUrl())
                .centerCrop()
                .placeholder(R.mipmap.final_icon)
                .into(myViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return religiousList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title, price;
        public ImageView imageView;
        LinearLayout religious_layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.text1);
            price = itemView.findViewById(R.id.price_religious);
            imageView = itemView.findViewById(R.id.imgView);
            religious_layout = itemView.findViewById(R.id.religious_layout);
        }
    }
}
