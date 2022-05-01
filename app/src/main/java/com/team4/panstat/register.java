package com.team4.panstat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {
    EditText etname, etpassword, etmail, etconfirmpassowrd;
    TextView loginText;
    Button register;
    String name, password, email, confirmpassword;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register = findViewById(R.id.registorBtn);
        etname = findViewById(R.id.regName);
        etmail = findViewById(R.id.regMail);
        etconfirmpassowrd = findViewById(R.id.regPassword2);
        etpassword = findViewById(R.id.regPassword);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = etname.getText().toString();
                password = etpassword.getText().toString();
                confirmpassword = etconfirmpassowrd.getText().toString();
                email = etmail.getText().toString();

                //showMessage(name+""+password+" "+email);

                if (name.length() >= 1 && password.length() >= 6 && confirmpassword.length() >= 6 && email.length() >= 6) {

                    firebaseDatabase = FirebaseDatabase.getInstance();
                    reference = firebaseDatabase.getReference("datauser");

                    StoringDataModel storingDataModel = new StoringDataModel(name, password, email, confirmpassword);

                    reference.child(name).setValue(storingDataModel);

                    showMessage("Login Successfull !!");

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    showMessage("Check Input Parameter");
                }
            }
        });

    }

    public void goToLogin(View view) {
        Intent intend = new Intent(getApplicationContext(), login.class);
        startActivity(intend);
        finish();
    }

    private void showMessage(String text) {

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}