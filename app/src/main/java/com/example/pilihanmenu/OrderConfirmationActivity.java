package com.example.pilihanmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OrderConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);

        // Get data from the previous activity
        Intent intent = getIntent();
        String orderedFoodName = intent.getStringExtra("orderedFoodName");
        int orderedQuantity = intent.getIntExtra("orderedQuantity", 1);
        int orderedFoodPrice = intent.getIntExtra("orderedFoodPrice", 0);

        // Initialize views
        TextView orderedFoodTextView = findViewById(R.id.orderedFoodTextView);
        TextView orderedFoodPriceTextView = findViewById(R.id.orderedFoodPriceTextView);
        TextView totalPaymentTextView = findViewById(R.id.totalPaymentTextView);

        // Set data to the views
        orderedFoodTextView.setText(orderedFoodName);
        orderedFoodPriceTextView.setText("Rp. " + orderedFoodPrice + " X " + orderedQuantity);

        int totalPayment = orderedFoodPrice * orderedQuantity;
        totalPaymentTextView.setText("Rp. " + totalPayment);

        // Set click listener for "Kembali ke Main" button
        Button backToMainButton = findViewById(R.id.backToMainButton);
        backToMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(OrderConfirmationActivity.this, MainActivity.class);
                mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mainIntent);
                finish();
            }
        });
    }

}