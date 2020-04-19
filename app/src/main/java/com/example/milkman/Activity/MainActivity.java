package com.example.milkman.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.milkman.R;

public class MainActivity extends AppCompatActivity {

    Button signIn,create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_page);
        checkPermissionManifest();
        signIn = findViewById(R.id.signin);
        create = findViewById(R.id.btn_create);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CreateAccountActivity.class));

            }
        });
    }

    private void checkPermissionManifest() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)== PackageManager.PERMISSION_DENIED){
                requestPermissions(new String[]{Manifest.permission.READ_PHONE_STATE},101);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode){
            case 101:
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_DENIED){
                    Toast.makeText(this, "Please Allow permissions", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
