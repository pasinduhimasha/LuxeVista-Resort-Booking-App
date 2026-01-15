package com.example.luxevistaresort;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ITEM_ROOM extends AppCompatActivity {

    Button BTN_DBOOK;
    Button BTN_DBOOK2;
    Button BTN_DBOOK3;
    Button BTN_OBOOK1;

    Button BTN_OBOOK2;
    Button BTN_OBOOK3;
    Button BTN_SBOOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_item_room);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//deluxe room 1
        BTN_DBOOK = findViewById(R.id.btn_dbook);
        BTN_DBOOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to open the BookingDetailsActivity
                Intent intent = new Intent(ITEM_ROOM.this, RoomActivity.class);
                startActivity(intent);
            }
        });

        //deluxe room 2
        BTN_DBOOK2 = findViewById(R.id.btn_dbook2);
        BTN_DBOOK2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to open the BookingDetailsActivity
                Intent intent = new Intent(ITEM_ROOM.this, DELUXE_ROOM2.class);
                startActivity(intent);
            }
        });

        //deluxe room 3
        BTN_DBOOK3 = findViewById(R.id.btn_dbook3);
        BTN_DBOOK3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to open the BookingDetailsActivity
                Intent intent = new Intent(ITEM_ROOM.this, DELUXE_ROOM3.class);
                startActivity(intent);
            }
        });

        //ocean view room1
        BTN_OBOOK1 = findViewById(R.id.btn_obook1);
        BTN_OBOOK1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to open the BookingDetailsActivity
                Intent intent = new Intent(ITEM_ROOM.this, Ocean_VIEW_ROOM1.class);
                startActivity(intent);
            }
        });

        //ocean view room1
        BTN_OBOOK2 = findViewById(R.id.btn_obook2);
        BTN_OBOOK2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to open the BookingDetailsActivity
                Intent intent = new Intent(ITEM_ROOM.this, OCEAN_VIEW_ROOM2.class);
                startActivity(intent);
            }
        });

        //ocean view room3
        BTN_OBOOK3 = findViewById(R.id.btn_obook3);
        BTN_OBOOK3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to open the BookingDetailsActivity
                Intent intent = new Intent(ITEM_ROOM.this, OCEAN_VIEW_ROOM3.class);
                startActivity(intent);
            }
        });

        //single room
        BTN_SBOOK = findViewById(R.id.btn_sbook);
        BTN_SBOOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to open the BookingDetailsActivity
                Intent intent = new Intent(ITEM_ROOM.this, SINGLE_ROOM.class);
                startActivity(intent);
            }
        });
    }
}