package com.example.milkman.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.milkman.Fragment.AccountFragment;
import com.example.milkman.Fragment.DeliveryFragment;
import com.example.milkman.Fragment.HomeFragment;
import com.example.milkman.Fragment.PlansFragment;
import com.example.milkman.R;
import com.example.milkman.Utils.BottomNavigationBehavior;

public class navigation extends AppCompatActivity {
    Button logout;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        bottomNavigationView = findViewById(R.id.navebar);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new HomeFragment()).commit();
        logout=findViewById(R.id.btn_logout);

       // CoordinatorLayout.LayoutParams layoutParams=(CoordinatorLayout.LayoutParams) bottomNavigationView.getLayoutParams();
        //layoutParams.setBehavior(new BottomNavigationBehavior());
        sp=getSharedPreferences("login",MODE_PRIVATE);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                Toast.makeText(getApplicationContext(),"Successfully Logged Out",Toast.LENGTH_LONG).show();
                sp.edit().putBoolean("logged",false).apply();
                finish();
            }
        });
    }

    BottomNavigationView bottomNavigationView;
    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.home_navigation:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new HomeFragment()).commit();
                    //Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.plans_navigation:
                    //Toast.makeText(getApplicationContext(), "Plans", Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new PlansFragment()).commit();
                    return true;
                case R.id.delivery_navigation:
                    //Toast.makeText(getApplicationContext(), "Delivery", Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new DeliveryFragment()).commit();
                    return true;
                case R.id.account_navigation:
                    //Toast.makeText(getApplicationContext(), "Account", Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new AccountFragment()).commit();
                    return true;
            }
            return false;
        }
    };

}
