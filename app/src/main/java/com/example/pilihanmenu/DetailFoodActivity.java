package com.example.pilihanmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailFoodActivity extends AppCompatActivity {

    private int imageResourceId;
    private String name;
    private String description;
    private int price;

    private ImageView detailImageView;
    private TextView detailNameTextView;
    private TextView detailDescriptionTextView;
    private TextView detailPriceTextView;
    private TextView quantityTextView;
    private int quantity = 1;
    private int originalPrice;

    private TextView updateDetailPriceTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food);

        Intent intent = getIntent();
        if (intent != null) {
            imageResourceId = intent.getIntExtra("imageResourceId", R.drawable.food1);
            name = intent.getStringExtra("name");
            description = intent.getStringExtra("description");
            price = intent.getIntExtra("price", 0);

            // Initialize originalPrice after getting the price from the intent
            originalPrice = price;
        }

        // Inisialisasi view
        detailImageView = findViewById(R.id.detailImageView);
        detailNameTextView = findViewById(R.id.detailNameTextView);
        detailDescriptionTextView = findViewById(R.id.detailDescriptionTextView);
        detailPriceTextView = findViewById(R.id.detailPriceTextView);
        quantityTextView = findViewById(R.id.quantityTextView);
        updateDetailPriceTextView = findViewById(R.id.updateDetailPriceTextView); // Initialize the new TextView

        // Set data ke view
        detailImageView.setImageResource(imageResourceId);
        detailNameTextView.setText(name);
        detailDescriptionTextView.setText(description);
        detailPriceTextView.setText("Rp " + String.format("%,d", price)); // Convert the integer price to a formatted string

        // Calculate and set the initial price
        updateQuantity();

        // Inisialisasi tombol tambah dan kurang
        Button minusButton = findViewById(R.id.minusButton);
        Button plusButton = findViewById(R.id.plusButton);

        // Set onClickListener untuk tombol tambah
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                updateQuantity();
            }
        });

        // Set onClickListener untuk tombol kurang
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity > 1) {
                    quantity--;
                    updateQuantity();
                }
            }
        });

        // Set onClickListener untuk tombol pesan
        Button orderButton = findViewById(R.id.orderButton);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Calculate the total price
                int totalPayment = originalPrice * quantity;

                Intent orderIntent = new Intent(DetailFoodActivity.this, OrderConfirmationActivity.class);
                orderIntent.putExtra("orderedFoodName", name);
                orderIntent.putExtra("orderedQuantity", quantity);
                orderIntent.putExtra("orderedFoodPrice", originalPrice);
                startActivity(orderIntent);
            }
        });
    }

    private void updateQuantity() {
        quantityTextView.setText(String.valueOf(quantity));

        int newPrice = originalPrice * quantity;
        String formattedPrice = "Rp " + String.format("%,d", newPrice);

        updateDetailPriceTextView.setText(formattedPrice); // Update the updateDetailPriceTextView with the new price
    }


}
