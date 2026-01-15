package com.example.luxevistaresort;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class OCEAN_VIEW_ROOM3 extends AppCompatActivity {

    ImageView imageView;
    TextView textView, textView3, textViewDescription, textViewTitle;
    CalendarView calendarView;
    TimePicker timePicker;
    Button buttonReserve, btn_logout, btn_menu;

    String selectedDate;
    int selectedHour, selectedMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocean_view_room3);

        // Initialize views
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        textView3 = findViewById(R.id.textView3);
        textViewDescription = findViewById(R.id.textViewDescription);
        textViewTitle = findViewById(R.id.textViewTitle);
        calendarView = findViewById(R.id.calendarView);
        timePicker = findViewById(R.id.timePicker);
        buttonReserve = findViewById(R.id.buttonReserve);
        btn_logout = findViewById(R.id.btn_logout);
        btn_menu = findViewById(R.id.btn_menu);

        // Set default selected date
        selectedDate = "";

        // CalendarView date change listener
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
            }
        });

        // Reserve button click
        buttonReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedHour = timePicker.getHour();
                selectedMinute = timePicker.getMinute();

                // Get service texts
                String serviceName = textView.getText().toString();
                String servicePrice = textView3.getText().toString();
                String serviceDescription = textViewDescription.getText().toString();

                if (selectedDate.isEmpty()) {
                    Toast.makeText(OCEAN_VIEW_ROOM3.this, "Please select a date", Toast.LENGTH_SHORT).show();
                } else {
                    String time = String.format("%02d:%02d", selectedHour, selectedMinute);

                    // Saving reservation to Firestore
                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    Map<String, Object> reservation = new HashMap<>();
                    reservation.put("Date", selectedDate);
                    reservation.put("Time", time);
                    reservation.put("UserID", FirebaseAuth.getInstance().getCurrentUser().getUid());
                    reservation.put("ServiceName", serviceName);
                    reservation.put("ServicePrice", servicePrice);
                    reservation.put("ServiceDescription", serviceDescription);

                    db.collection("Booking")
                            .add(reservation)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(OCEAN_VIEW_ROOM3.this, "Reservation Saved!", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(OCEAN_VIEW_ROOM3.this, "Failed to Save Reservation", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            }
        });

        // Logout button click
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go back to login screen
                Intent intent = new Intent(OCEAN_VIEW_ROOM3.this, Firstscreen.class);
                startActivity(intent);
                finish();
            }
        });

        // Menu button click
        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go back to main menu
                Intent intent = new Intent(OCEAN_VIEW_ROOM3.this, UserDashboard.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
