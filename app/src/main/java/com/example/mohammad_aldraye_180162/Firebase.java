package com.example.mohammad_aldraye_180162;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Firebase extends AppCompatActivity {
    private FirebaseDatabase mDatabase;
    private DatabaseReference myRef;

    public Firebase() {
        FirebaseApp.initializeApp(this);
        mDatabase = FirebaseDatabase.getInstance();
        myRef = mDatabase.getReference("My Database");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void writeNewUser(String email, String firstname, String lastname, String phonenumber, String userID) {
        User user = new User(email, firstname, lastname, phonenumber);
        myRef.child("users").child(userID).setValue(user);
    }
    public void deleteUserData(String userId) {
        myRef.child("users").child(userId).removeValue();
    }

    public void writeWithSuccess(String userID, String user) {
        myRef.child("users").child(userID).setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d("Mohammad", "Successful writing.");
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("Mohammad", "Error: " + e);
                    }
                });
    }
}