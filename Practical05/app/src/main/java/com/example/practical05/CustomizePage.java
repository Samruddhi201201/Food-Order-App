package com.example.practical05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CustomizePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_page);

    }
    public void onClick3(View view){
        Intent i2=new Intent(getApplicationContext(),Cart.class);
        startActivity(i2);
    }
}