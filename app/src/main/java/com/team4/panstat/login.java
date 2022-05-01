package com.team4.panstat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {
    Button loginBtn;
    TextView registorTxt;
    String Email, Passord;
    EditText etMail, etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        loginBtn = findViewById(R.id.loginBtn);
        registorTxt = findViewById(R.id.regBtn);
        etMail = findViewById(R.id.login_mail);
        etPassword = findViewById(R.id.login_password);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Email = etMail.getText().toString();
                Passord = etPassword.getText().toString();

                if (Email.length() >= 6 && Passord.length() >= 6) {
                    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                    DatabaseReference databaseReference = firebaseDatabase.getReference("datauser");

                    Query queyCheckUserName = databaseReference.orderByChild("name").equalTo(Email);

                    queyCheckUserName.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            if (snapshot.exists()) {

                                String passwordcheck = snapshot.child(Email).child("password").getValue().toString();

                                if (Passord.equals(passwordcheck)) {
                                    Intent intent = new Intent(login.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    showMessage("Password wrong");
                                }


                            } else {
                                showMessage("user does not exit");
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });


                } else {
                    showMessage("Login & Password Parameter Invalid");
                }


            }
        });

        registorTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), register.class);
                startActivity(intent);
                //finish();
            }
        });
    }

    private void showMessage(String text) {

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void goToLogin(View view) {
        Intent intent = new Intent(getApplicationContext(), register.class);
        startActivity(intent);
    }
}