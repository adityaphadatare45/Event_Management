package com.example.eventmanagement;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;
  //  TextInputEditText editText1,editText2,editText3,editTextadd;
    FirebaseAuth auth;
    FirebaseUser user;



    @Override
    //The onCreate method is a special method in Android activities that gets called when the activity is first created.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //sets the layout of this activity to the one defined in activity_main.xml.
        setContentView(R.layout.activity_main);

    auth = FirebaseAuth.getInstance();
    button = findViewById(R.id.btn1);
    textView = findViewById(R.id.txt);
  /*  editText1 = findViewById(R.id.all);
    editText2 = findViewById(R.id.day);
    editText3 = findViewById(R.id.month);
    editTextadd = findViewById(R.id.ade);*/
    //It returns the currently signed user from firebase
    user = auth.getCurrentUser();
    // If there is no user is loged then it will redirect to login activity;
    if(user == null){
        // This intent helps to start and finish the activity
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
        finish();
        }

    // The button helps to logout and redirect to login activity for next step :
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        }
    });
   /*textinputlayout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(),)
        }
   });*/




    }
}