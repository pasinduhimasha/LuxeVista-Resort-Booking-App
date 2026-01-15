package com.example.luxevistaresort;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class CABANAS extends AppCompatActivity {

    CalendarView calendarView;
    TimePicker timePicker;
    Button buttonReserve, btn_logout, btn_menu;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String selectedDate = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cabanas);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize
        calendarView = findViewById(R.id.calendarView);
        timePicker = findViewById(R.id.timePicker);
        buttonReserve = findViewById(R.id.buttonReserve);
        btn_logout = findViewById(R.id.btn_logout);
        btn_menu = findViewById(R.id.btn_menu);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        // Get selected date
        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
        });

        // Save Reservation
        buttonReserve.setOnClickListener(v -> {
            if (selectedDate.isEmpty()) {
                Toast.makeText(CABANAS.this, "Please select a date", Toast.LENGTH_SHORT).show();
                return;
            }

            int hour = timePicker.getHour();
            int minute = timePicker.getMinute();
            String selectedTime = hour + ":" + (minute < 10 ? "0" + minute : minute);

            String userId = fAuth.getCurrentUser().getUid();
            String title = ((TextView)findViewById(R.id.textView)).getText().toString();
            String price = ((TextView)findViewById(R.id.textView3)).getText().toString();
            String description = ((TextView)findViewById(R.id.textViewDescription)).getText().toString();

            Map<String, Object> reservation = new HashMap<>();
            reservation.put("UserID", userId);
            reservation.put("Date", selectedDate);
            reservation.put("Time", selectedTime);
            reservation.put("Title", title);
            reservation.put("Price", price);
            reservation.put("Description", description);

            fStore.collection("Reservations").add(reservation)
                    .addOnSuccessListener(documentReference -> {
                        Toast.makeText(CABANAS.this, "Reservation Successful!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), CABANAS.class));
                        finish();
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(CABANAS.this, "Reservation Failed!", Toast.LENGTH_SHORT).show();
                    });
        });

        // Logout Button
        btn_logout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), Login.class));
            finish();
        });

        // Menu Button
        btn_menu.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), UserDashboard.class));
            finish();
        });
    }
}
