package com.example.fiit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PaymentDetails extends AppCompatActivity {

    EditText cNumber, cName, cExp, cCvv;
    Button payBtn;


    DatabaseReference paymentDb;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        cNumber = (EditText)findViewById(R.id.cardNumTxt);
        cName = (EditText)findViewById(R.id.cardNameTxt);
        cExp = (EditText)findViewById(R.id.expireText);
        cCvv = (EditText)findViewById(R.id.cvvTxt);
        payBtn = (Button) findViewById(R.id.btnPay);

        paymentDb = FirebaseDatabase.getInstance().getReference().child("Payments");

        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertPaymentData();
            }
        });

    }

    private void insertPaymentData() {
        String cardNumber = cNumber.getText().toString();
        String cardName = cName.getText().toString();
        String cardExp = cExp.getText().toString();
        String cardCvv = cCvv.getText().toString();

        Payments payments = new Payments(cardNumber, cardName, cardExp, cardCvv);

        paymentDb.push().setValue(payments);
        Toast.makeText(PaymentDetails.this, "Data inserted", Toast.LENGTH_SHORT).show();
    }
}