package com.example.mohammad_aldraye_180162;
import com.google.firebase.database.IgnoreExtraProperties;

        @IgnoreExtraProperties
public class User {
    public String email;
    public String firstname;
    public String lastname;
    public String phonenumber;

    public User(){

    }
    public User(String email, String firstname, String lastname, String phonenumber) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
    }
    }
}
