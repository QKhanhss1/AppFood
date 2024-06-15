package com.example.AppFood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    
    Button btn1,btn2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Xulymomanhinhdanhba();

            }
        });
    }

    private void Xulymomanhinhdanhba() {
        Intent intent = new Intent(MainActivity.this,Danhba.class);
        intent.setClassName("com.example.AppFood","com.example.AppFood.Danhba");
        startActivity(intent);
    }
}








