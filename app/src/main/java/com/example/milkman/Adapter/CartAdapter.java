package com.example.milkman.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.milkman.Activity.ConfirmationActivity;
import com.example.milkman.Models.CartList;
import com.example.milkman.R;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {
    private List<CartList> cartList;
    private Context context;

    public CartAdapter(Context context, List<CartList> list) {
        this.context = context;
        this.cartList = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_list_row, viewGroup, false);
        return new CartAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final CartList cl = cartList.get(i);
        myViewHolder.title.setText(cl.getTitle());
        myViewHolder.price.setText(cl.getPrice());
        Glide.with(context)
                .load(cl.getImageUrl())
                .centerCrop()
                .placeholder(R.mipmap.final_icon)
                .into(myViewHolder.imageView);


    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title, price;
        public ImageView imageView;
        LinearLayout cart_layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.text1);
            imageView = itemView.findViewById(R.id.imgView);
            price = itemView.findViewById(R.id.price_cart);
            cart_layout = itemView.findViewById(R.id.cart_layout);
        }
    }
}
