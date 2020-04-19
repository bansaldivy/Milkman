package com.example.milkman.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.milkman.DatabaseHelper;
import com.example.milkman.R;

public class LoginActivity extends AppCompatActivity {
    SharedPreferences sp;
    Button cont, create;
    EditText mobileno, password;
    String mob, pass;
    DatabaseHelper databaseHelper;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        databaseHelper = new DatabaseHelper(this);
        cont = findViewById(R.id.btn_cont);
        create = findViewById(R.id.btn_create);
        mobileno = findViewById(R.id.login_mobile);
        password = findViewById(R.id.login_password);

        sp=getSharedPreferences("login",MODE_PRIVATE);

        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mob = mobileno.getText().toString().trim();
                pass = password.getText().toString().trim();

                if (mob.isEmpty() || pass.isEmpty() || mob.length() != 10) {
                    Snackbar snack = Snackbar.make(v, "ENTER VALID DETAILS", Snackbar.LENGTH_SHORT);
                    View view = snack.getView();
                    FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();
                    params.gravity = Gravity.TOP;
                    view.setLayoutParams(params);
                    snack.show();
                    //Snackbar.make(v,"PLEASE ENTER MOBILE NO. AND PASSWORD",Snackbar.LENGTH_LONG).show();
                } else {

                    if(databaseHelper.login(mob,pass)){
                        startActivity(new Intent(getApplicationContext(), navigation.class));
                        finish();
                        Toast.makeText(getApplicationContext(),"You are Logged In",Toast.LENGTH_SHORT).show();
                        sp.edit().putBoolean("logged",true).apply();
                    }else{
                        Snackbar snack = Snackbar.make(v, "WRONG DETAILS ENTERED", Snackbar.LENGTH_SHORT);
                        View view = snack.getView();
                        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();
                        params.gravity = Gravity.TOP;
                        view.setLayoutParams(params);
                        snack.show();
                    }
                }
            }
        });
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CreateAccountActivity.class));
            }
        });
    }
}
