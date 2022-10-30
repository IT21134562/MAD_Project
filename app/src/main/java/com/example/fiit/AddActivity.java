package com.example.fiit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

    EditText name, surl, exe1, exe2, exe3, exe4, exe5;
    Button btnAdd, btnBack;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name = (EditText)findViewById(R.id.txtName);
        exe1 = (EditText)findViewById(R.id.txtEx1);
        exe2 = (EditText)findViewById(R.id.txtEx2);
        exe3 = (EditText)findViewById(R.id.txtEx3);
        exe4 = (EditText)findViewById(R.id.txtEx4);
        exe5 = (EditText)findViewById(R.id.txtEx5);

        surl = (EditText)findViewById(R.id.txtImageUrl);

        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnBack = (Button)findViewById(R.id.btnBack);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void insertData() {
        Map<String,Object> map = new HashMap<>();
        map.put("name", name.getText().toString());
        map.put("surl", surl.getText().toString());
        map.put("exe1", exe1.getText().toString());
        map.put("exe2", exe2.getText().toString());
        map.put("exe3", exe3.getText().toString());
        map.put("exe4", exe4.getText().toString());
        map.put("exe5", exe5.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("exercises").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddActivity.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddActivity.this, "Error while Insertion", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}