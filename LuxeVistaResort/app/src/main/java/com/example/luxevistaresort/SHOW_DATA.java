package com.example.luxevistaresort;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class SHOW_DATA extends AppCompatActivity {

    TextView myTextView;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_data);

        // Connect XML to Java
        myTextView = findViewById(R.id.myTextView);

        // Connect to Firestore
        db = FirebaseFirestore.getInstance();

        // Fetch multiple documents
        db.collection("Reservations")  // << your collection name
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    if (!queryDocumentSnapshots.isEmpty()) {
                        StringBuilder data = new StringBuilder();

                        for (DocumentSnapshot document : queryDocumentSnapshots) {
                            String title = document.getString("Title");
                            String description = document.getString("Description");
                            String price = document.getString("Price");
                            String date = document.getString("Date");
                            String time = document.getString("Time");

                            data.append("Title: ").append(title).append("\n")
                                    .append("Description: ").append(description).append("\n")
                                    .append("Price: ").append(price).append("\n")
                                    .append("Date: ").append(date).append("\n")
                                    .append("Time: ").append(time).append("\n")
                                    .append("---------------------------------------------------------------\n\n");
                        }

                        myTextView.setText(data.toString());
                    } else {
                        myTextView.setText("No reservations found");
                    }
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(SHOW_DATA.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });

        // Handle window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}