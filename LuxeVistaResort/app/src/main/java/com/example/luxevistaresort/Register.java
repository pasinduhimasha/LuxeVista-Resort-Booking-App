package com.example.luxevistaresort;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    EditText etxt_email, etxt_password,etxt_fullName, etxt_phone;
    Button btn_register;
    TextView txtbtn_goLogin;
    Boolean valid = false;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        etxt_email = findViewById(R.id.ETXT_email);
        etxt_password = findViewById(R.id.ETXT_password);
        etxt_fullName = findViewById(R.id.ETXT_fullName);
        etxt_phone = findViewById(R.id.ETXT_phone);
        btn_register = findViewById(R.id.BTN_register);
        txtbtn_goLogin = findViewById(R.id.TXTBTN_goLogin);

        txtbtn_goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goLogin = new Intent(getApplicationContext(), Login.class);
                startActivity(goLogin);
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Checking the fields
                chechkField(etxt_email);
                chechkField(etxt_password);
                chechkField(etxt_fullName);
                chechkField(etxt_phone);

                // Checking is valid == true?
                if(valid)
                {
                    //Save user details to variables
                    String fullName = etxt_fullName.getText().toString();
                    String phone = etxt_phone.getText().toString();
                    String emailAddress = etxt_email.getText().toString();
                    String password = etxt_password.getText().toString();

                    //user register process
                    fAuth.createUserWithEmailAndPassword(emailAddress, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {

                            Toast.makeText(Register.this, "Account is Created", Toast.LENGTH_SHORT).show();

                            FirebaseFirestore user = FirebaseFirestore.getInstance();

                            DocumentReference df = fStore.collection("userDetails72A").document(fAuth.getCurrentUser().getUid());

                            Map<String, Object> userInfo = new HashMap<>();

                            userInfo.put("FullName", fullName);
                            userInfo.put("PhoneNumber", phone);
                            userInfo.put("EmailAddress", emailAddress);
                            userInfo.put("Password", password);

//                            userInfo.put("isAdmin", "0");

                            df.set(userInfo);


                            Intent moveLogin = new Intent(getApplicationContext(), Login.class);
                            startActivity(moveLogin);
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Register.this, "Failed to create the Account", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }

    public boolean chechkField(EditText ex){
        if (ex.getText().toString().isEmpty())
        {
            ex.setError("Required");
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }
}