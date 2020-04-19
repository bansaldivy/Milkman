package com.example.milkman.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.milkman.Activity.LoginActivity;
import com.example.milkman.DatabaseHelper;
import com.example.milkman.R;

public class CreateAccountActivity extends AppCompatActivity {
    EditText name,pass,mob,code;
    String fullname,mobile,password,refcode;
    Button cont,signin;
    DatabaseHelper cadatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account_layout);

        cont = findViewById(R.id.cont);
        signin = findViewById(R.id.sign);
        name = findViewById(R.id.name);
        pass = findViewById(R.id.password);
        mob = findViewById(R.id.mobile);
        code = findViewById(R.id.code);
        cadatabase = new DatabaseHelper(this);
        addData();
    }

        public void addData(){
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullname=name.getText().toString().trim();
                password=pass.getText().toString().trim();
                mobile=mob.getText().toString().trim();
                refcode=code.getText().toString().trim();

                int isInserted = cadatabase.insertData(name.getText().toString(), mob.getText().toString(), pass.getText().toString(), code.getText().toString());

                if (!(fullname.isEmpty() || password.isEmpty() || mobile.length() != 10 )) {
                    if(isInserted==1)
                    {
                        Toast.makeText(getApplicationContext(),"Successfully Created",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        finish();
                    }
                    else if (isInserted==100){
                        Snackbar snack = Snackbar.make(v,"Mobile Number already exists",Snackbar.LENGTH_LONG);
                        View view = snack.getView();
                        FrameLayout.LayoutParams params=(FrameLayout.LayoutParams)view.getLayoutParams();
                        params.gravity = Gravity.TOP;
                        view.setLayoutParams(params);
                        snack.show();
                        //DB
                    }
                    else if (isInserted==0){
                        Snackbar snack = Snackbar.make(v,"Something went wrong",Snackbar.LENGTH_LONG);
                        View view = snack.getView();
                        FrameLayout.LayoutParams params=(FrameLayout.LayoutParams)view.getLayoutParams();
                        params.gravity = Gravity.TOP;
                        view.setLayoutParams(params);
                        snack.show();
                        //DB
                    }
                }
                else {
                    Snackbar snack = Snackbar.make(v,"ENTER VALID DETAILS",Snackbar.LENGTH_SHORT);
                    View view = snack.getView();
                    FrameLayout.LayoutParams params=(FrameLayout.LayoutParams)view.getLayoutParams();
                    params.gravity = Gravity.TOP;
                    view.setLayoutParams(params);
                    snack.show();
                }
               /* SharedPreferences sharedPreferences=getSharedPreferences("AccountData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putString("Name",name.getText().toString());
                editor.putString("Mobile",mob.getText().toString());
                editor.putString("Password",pass.getText().toString());

                editor.commit();*/
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                finish();
            }
        });
    }
}
