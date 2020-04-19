package com.example.milkman.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.example.milkman.R;

public class Rate_Us_Account extends AppCompatActivity {
    Button submit;
    EditText edit_rate;
    RatingBar bar;
    String edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate_us_account);
        Toolbar toolbar=findViewById(R.id.rate_back);
        setSupportActionBar(toolbar);
        if (getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        submit = findViewById(R.id.btn_submit);
        edit_rate = findViewById(R.id.edit_rate);
        bar = findViewById(R.id.rating_bar);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit = edit_rate.getText().toString().trim();

                if (!((edit.isEmpty()) && !(bar.isSelected()))) {
                    Toast.makeText(getApplicationContext(), "Thank you for your feedback!", Toast.LENGTH_LONG).show();
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
