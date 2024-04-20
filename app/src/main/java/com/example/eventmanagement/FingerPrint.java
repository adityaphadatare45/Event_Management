package com.example.eventmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import java.util.concurrent.Executor;

public class FingerPrint extends AppCompatActivity {

        BiometricPrompt biometricPrompt;
        BiometricPrompt.PromptInfo promptInfo;
        ConstraintLayout mFingerPrint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_finger_print);
        mFingerPrint= findViewById(R.id.main);

        BiometricManager biometricManager = BiometricManager.from(this);

        switch(biometricManager.canAuthenticate())
        {
            // In this case if users mobile didn't have fingerprint the toast msg will generate.
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                Toast.makeText(this, "Devise Doesn't Have FingerPrint ", Toast.LENGTH_SHORT).show();
                break;
             // In this case if users mobile ahve fingerprint but it is not working at that time the toast msg will generate.
            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                Toast.makeText(this, "FingerPrint Is Not Working", Toast.LENGTH_SHORT).show();
                break;
           // if user did not assign any fingerprint the toast msg will display.
            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                Toast.makeText(this, "No FingerPrint Assign", Toast.LENGTH_SHORT).show();
        }
        // Executor Initialization
        // This will ensure that biometric authentication callbacks are run on the main thread.
        Executor executor= ContextCompat.getMainExecutor(this);

        // This code snippet will help us to handle callbacks , to handle different authentication outcomes.
        biometricPrompt= new BiometricPrompt(FingerPrint.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            // This method called when an error occurs during authentication.
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
            }

            @Override
            // This method will help to user about successful authentication and leads to main activity of application.
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(FingerPrint.this, "Login Success", Toast.LENGTH_SHORT).show();
                // To go to mainactivity
                Intent intent = new Intent(FingerPrint.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            //  this method will called when the authentication fails.
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }
        });
    // This promt info will display on screen when authentication is started.
        promptInfo = new BiometricPrompt.PromptInfo.Builder().
                setTitle("Event Management")
                .setDescription("Use FingerPrint to Login ")
                .setDeviceCredentialAllowed(true).build();

        // The biometricPrompt.authenticate(promptInfo) method is called to display the biometric prompt and
        // start the authentication process using the configured PromptInfo.
                biometricPrompt.authenticate(promptInfo);

    }
}