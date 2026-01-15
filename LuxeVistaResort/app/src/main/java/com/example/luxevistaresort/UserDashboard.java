package com.example.luxevistaresort;

import android.app.Notification;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class UserDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView img_signOff = findViewById(R.id.IMG_signOff);
        TextView txtBTN_signOut = findViewById(R.id.TXTBTN_signOut);
        ImageView img_booking = findViewById(R.id.IMG_booking);
        TextView txtBTN_booking = findViewById(R.id.TXTBTN_booking);
        ImageView img_services = findViewById(R.id.IMG_services);
        TextView txtBTN_services = findViewById(R.id.TXTBTN_services);
        ImageView img_about = findViewById(R.id.IMG_about);
        TextView txtBTN_about = findViewById(R.id.TXTBTN_about);
        ImageView img_sdata = findViewById(R.id.IMG_sdata);
        TextView txtBTN_sdata = findViewById(R.id.TXTBTN_sdata);
        ImageView img_dbook = findViewById(R.id.IMG_dbook);
        TextView txtBTN_dbook = findViewById(R.id.TXTBTN_dbook);
        ImageView img_notifi = findViewById(R.id.IMG_notifi);
        ImageView img_search = findViewById(R.id.IMG_search);



        img_signOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });

        txtBTN_signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });
        // Booking page connection
        img_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboard.this, ITEM_ROOM.class);
                startActivity(intent);
            }
        });

        txtBTN_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboard.this, ITEM_ROOM.class);
                startActivity(intent);
            }
        });

        //service page
        img_services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboard.this, Services.class);
                startActivity(intent);
            }
        });
        txtBTN_services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboard.this, Services.class);
                startActivity(intent);
            }
        });

        //about_us page

        img_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboard.this, About.class);
                startActivity(intent);
            }
        });

        txtBTN_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboard.this, About.class);
                startActivity(intent);
            }
        });

        //show services data
        img_sdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboard.this, SHOW_DATA.class);
                startActivity(intent);
            }
        });

        txtBTN_sdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboard.this, SHOW_DATA.class);
                startActivity(intent);
            }
        });

        //show booking data
        img_dbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboard.this, SHOW_BOOKING_DATA.class);
                startActivity(intent);
            }
        });

        txtBTN_dbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboard.this, SHOW_BOOKING_DATA.class);
                startActivity(intent);
            }
        });
        //notfication
        img_notifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboard.this, NOTIFI.class);
                startActivity(intent);
            }
        });

        //search
        img_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboard.this, Booking.class);
                startActivity(intent);
            }
        });



    }

    public void signOut()
    {
        FirebaseAuth.getInstance().signOut();

        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();

    }
}