package com.example.luxevistaresort;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Services extends AppCompatActivity {

    Button BTN_RESERVE;

    Button BTN_SPA;

    Button BTN_DINING;

    Button BTN_CABANA;

    Button BTN_TOURS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_services);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.services), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//pool
        BTN_RESERVE = findViewById(R.id.btn_reserve);
        BTN_RESERVE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to open the BookingDetailsActivity
                Intent intent = new Intent(Services.this, Service.class);
                startActivity(intent);
            }
        });
        //SPA
        BTN_SPA = findViewById(R.id.btn_spa);
        BTN_SPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to open the BookingDetailsActivity
                Intent intent = new Intent(Services.this, SPA_TREATMENTS.class);
                startActivity(intent);
            }
        });

        //DINING
        BTN_DINING= findViewById(R.id.btn_dining);
        BTN_DINING.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to open the BookingDetailsActivity
                Intent intent = new Intent(Services.this, DINING.class);
                startActivity(intent);
            }
        });

        //CABANA
        BTN_CABANA= findViewById(R.id.btn_cabanas);
        BTN_CABANA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to open the BookingDetailsActivity
                Intent intent = new Intent(Services.this,CABANAS.class);
                startActivity(intent);
            }
        });

        //BEACH TOURS
        BTN_TOURS= findViewById(R.id.btn_beachtours);
        BTN_TOURS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to open the BookingDetailsActivity
                Intent intent = new Intent(Services.this,BEACH_TOURS.class);
                startActivity(intent);
            }
        });
    }
}