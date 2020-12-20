package com.example.mohammad_aldraye_180162;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity2 extends AppCompatActivity {
    Firebase firebase = new Firebase();
    EditText firstname, lastname, emailinput, phonenumber, userid;
    Button input, update, returnbtn, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        firstname = findViewById(R.id.firstname);
        emailinput = findViewById(R.id.emailinput);
        lastname = findViewById(R.id.lastname);
        phonenumber = findViewById(R.id.phonenumber);
        userid = findViewById(R.id.userid);
        input = findViewById(R.id.input);
        update = findViewById(R.id.button5);
        returnbtn = findViewById(R.id.returnbtn);
        delete = findViewById(R.id.deletebtn);

        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ufname = firstname.getText().toString();
                String ulname = lastname.getText().toString();
                String uemail = emailinput.getText().toString();
                String uphonenumber = phonenumber.getText().toString();
                String uuid = userid.getText().toString();
               firebase.writeNewUser(uemail, ufname, ulname, uphonenumber, uuid);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ufname = firstname.getText().toString();
                String ulname = lastname.getText().toString();
                String uemail = emailinput.getText().toString();
                String uphonenumber = phonenumber.getText().toString();
                String uuid = userid.getText().toString();
                firebase.writeNewUser(uemail, ufname, ulname, uphonenumber, uuid);
            }
        });
        returnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(myIntent);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uuid = userid.getText().toString();
                firebase.deleteUserData(uuid);
            }
        });
    }
}