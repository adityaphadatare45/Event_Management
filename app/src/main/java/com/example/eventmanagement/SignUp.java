package com.example.eventmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {
    TextInputEditText editTextEmail, editTextPassword;
    Button buttonReg , buttonFinger;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    TextView textView;


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null ){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        buttonReg = findViewById(R.id.btn_signup);
        progressBar = findViewById(R.id.pbar);
        textView = findViewById(R.id.ctl);
        buttonFinger = findViewById(R.id.fgr);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();
            }
        });


        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String email , password;
                email = String.valueOf(editTextEmail.getText());
                password = String.valueOf(editTextPassword.getText());

                if(TextUtils.isEmpty(email)) {
                    Toast.makeText(SignUp.this, "Enter email", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE); // Adjusted visibility here
                    return;
                }

                if(TextUtils.isEmpty(password)) {
                    Toast.makeText(SignUp.this, "Enter password", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE); // Adjusted visibility here
                    return;
                }



                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(task -> {
                            progressBar.setVisibility(View.GONE); // Adjusted visibility here
                            if (task.isSuccessful()) {
                                Toast.makeText(SignUp.this, "Account Created.", Toast.LENGTH_SHORT).show();
                                // Proceed to your desired activity
                            } else {
                                // If sign in fails, display a message to the user.
                                String errorMessage;
                                Toast.makeText(SignUp.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
        buttonFinger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FingerPrint.class);
                startActivity(intent);
                finish();
            }
        });

    }
}