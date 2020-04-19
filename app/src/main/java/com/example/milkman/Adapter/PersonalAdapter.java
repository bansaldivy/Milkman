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
import com.example.milkman.Models.PersonalList;
import com.example.milkman.R;

import java.util.List;

public class PersonalAdapter extends RecyclerView.Adapter<PersonalAdapter.MyViewHolder> {
    private List<PersonalList> personalList;
    Context context;

    public PersonalAdapter(Context context,List<PersonalList> list){
        this.context=context;
        this.personalList=list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.personal_list_row, viewGroup, false);
        return new PersonalAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final PersonalList pl=personalList.get(i);
        myViewHolder.title.setText(pl.getTitle());
        myViewHolder.price.setText(pl.getPrice());
        Glide.with(context)
                .load(pl.getImageUrl())
                .centerCrop()
                .placeholder(R.mipmap.final_icon)
                .into(myViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return personalList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title, price;
        public ImageView imageView;
        LinearLayout personal_layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.text1);
            price=itemView.findViewById(R.id.price_personal);
            imageView=itemView.findViewById(R.id.imgView);
            personal_layout=itemView.findViewById(R.id.personal_layout);
        }
    }
}
