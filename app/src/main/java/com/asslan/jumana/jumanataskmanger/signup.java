package com.asslan.jumana.jumanataskmanger;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {
    private EditText fname, lname, em2, pass2, rewarte, phone;
    private Button save1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        fname = findViewById(R.id.fName);
        lname = findViewById(R.id.lName);
        em2 = findViewById(R.id.emSign);
        pass2 = findViewById(R.id.pass2);
        rewarte = findViewById(R.id.rewarte);
        phone = findViewById(R.id.phone);
        save1 = findViewById(R.id.save1);

        save1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();

            }
        });
    }

    private void dataHandler() {
        boolean isok1 = true;
        String email = em2.getText().toString();
        String passwl = pass2.getText().toString();
        String passw2 = rewarte.getText().toString();
        String fname1 = fname.getText().toString();
        String lname1 = lname.getText().toString();
        String phone1 = phone.getText().toString();
        if (email.length() < 4 || email.indexOf('@') < 0 || email.indexOf('.') < 0) {
            em2.setError("wrong email");
            isok1 = false;


        }
        if (passwl.length() < 8 || passwl.equals(passw2) == false) {
            pass2.setError("have to be at least 8 char and the same password");
            rewarte.setError("have to be at least 8 char and the same password");
            isok1 = false;
        }
        if (fname1.length() == 0) {
            fname.setError("enter name");
            isok1 = false;

        }
        if (isok1) {
            createAcount(email, passwl, fname1, lname1, phone1);
        }
    }

    private void createAcount(String email, String passwl, String fname1, String lname1, String phpne1) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email, passwl).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    finish();
                }
                else {
                    em2.setError("Sign up failed");

                }
            }
        });



    }


}


















