package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {

    EditText title,desc,rarity,img;
    Button btnAdd,btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        title = (EditText)findViewById(R.id.txtTitle);
        desc = (EditText)findViewById(R.id.txtDesc);
        rarity = (EditText)findViewById(R.id.txtRarity);
        img = (EditText)findViewById(R.id.txtImg);

        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnBack = (Button)findViewById(R.id.btnBack);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                insertData();
                clearAll();

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void insertData(){

        Map<String,Object> map = new HashMap<>();
        map.put("title",title.getText().toString());
        map.put("desc",desc.getText().toString());
        map.put("rarity",rarity.getText().toString());
        map.put("img",img.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("pChallenges").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        Toast.makeText(AddActivity.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(AddActivity.this, "Error while Adding Data", Toast.LENGTH_SHORT).show();

                    }
                });

    }

    private void clearAll(){

        title.setText("");
        desc.setText("");
        rarity.setText("");
        img.setText("");

    }
}