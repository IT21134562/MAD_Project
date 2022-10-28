package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        Button btn1 = (Button)findViewById(R.id.perBtn);
        Button btn2 = (Button)findViewById(R.id.limiBtn);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 = new Intent(MainScreen.this,MainActivity.class);
                startActivity(int1);
            }
        });
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent int2 = new Intent(MainScreen.this,MainActivity2.class);
//                startActivity(int2);
//            }
//        });

    }
}