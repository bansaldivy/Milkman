package com.example.milkman.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.milkman.Activity.About_Us_Account;
import com.example.milkman.Activity.Profile_Account;
import com.example.milkman.Activity.Rate_Us_Account;
import com.example.milkman.Activity.Support_Account;
import com.example.milkman.Activity.Transaction_History_Account;
import com.example.milkman.Activity.Wallet_Account;
import com.example.milkman.Models.AccountList;
import com.example.milkman.R;

import java.util.List;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.MyViewHolder> {
    private List<AccountList> accountList;

    private Context context;

    public AccountAdapter(Context context, List<AccountList> list) {
        this.accountList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.account_list_row, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        final AccountList acc = accountList.get(i);
        myViewHolder.title.setText(acc.getTitle());
        Glide.with(context)
                .load(acc.getImageUrl())
                .centerCrop()
                .placeholder(R.mipmap.final_icon)
                .into(myViewHolder.imageView);

        myViewHolder.account_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (acc.getTitle().equals("Profile")) {
                    Intent intent = new Intent(context.getApplicationContext(), Profile_Account.class);
                    context.startActivity(intent);
                } else if (acc.getTitle().equals("Wallet")) {
                    Intent intent = new Intent(context.getApplicationContext(), Wallet_Account.class);
                    context.startActivity(intent);
                } else if (acc.getTitle().equals("Transaction History")) {
                    Intent intent = new Intent(context.getApplicationContext(), Transaction_History_Account.class);
                    context.startActivity(intent);
                } else if (acc.getTitle().equals("Call Us")) {
                    Intent in = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:7597617230"));
                    try {
                        context.startActivity(in);
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(context, "Could not find an activity to place the call.", Toast.LENGTH_SHORT).show();
                    }
                } else if (acc.getTitle().equals("Support")) {
                    Intent intent = new Intent(context.getApplicationContext(), Support_Account.class);
                    context.startActivity(intent);
                } else if (acc.getTitle().equals("Rate Us")) {
                    Intent intent = new Intent(context.getApplicationContext(), Rate_Us_Account.class);
                    context.startActivity(intent);
                } else if (acc.getTitle().equals("About Us")) {
                    Intent intent = new Intent(context.getApplicationContext(), About_Us_Account.class);
                    context.startActivity(intent);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return accountList.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public ImageView imageView;
        LinearLayout account_layout;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.text1);
            imageView = itemView.findViewById(R.id.imgView);
            account_layout = itemView.findViewById(R.id.account_layout);
        }
    }
}
