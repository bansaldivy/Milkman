package com.example.milkman.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.example.milkman.R;

public class Support_Account extends AppCompatActivity {
    Button sup;
    EditText del, pay, acc;
    String delivery, payment, account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.support_account);
        Toolbar toolbar = findViewById(R.id.sup_back);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        sup = findViewById(R.id.btn_support);
        del = findViewById(R.id.delivery_support);
        pay = findViewById(R.id.payment_support);
        acc = findViewById(R.id.account_support);

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                delivery = del.getText().toString().trim();
                payment = pay.getText().toString().trim();
                account = acc.getText().toString().trim();

                if (!(delivery.isEmpty() && payment.isEmpty() && account.isEmpty())) {
                    Toast.makeText(getApplicationContext(), "Thank You! We will shortly resolve this issue.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

