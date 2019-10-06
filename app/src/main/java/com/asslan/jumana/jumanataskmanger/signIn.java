package com.asslan.jumana.jumanataskmanger;

import android.content.Intent;
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

public class signIn extends AppCompatActivity {
    private EditText emsign,pssign;
    private Button singIn1,signUp1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        emsign = findViewById(R.id.emSign);
        pssign = findViewById(R.id.psSign);
        singIn1 = findViewById(R.id.signIn1);
        signUp1 = findViewById(R.id.signUp1);


        signUp1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), signup.class);

                startActivity(intent);

            }
        });

        singIn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });
    }

            private void dataHandler() {
                String email=emsign.getText().toString();
                String password=pssign.getText().toString();
                boolean isok=true;
//                if(email.length()<4)
//                {
//                    emsign.setError("Email length eror");
//                   isok=false;
//                }
//                if(email.indexOf("@")<0 || email.indexOf(".")<0)
//                {
//                    emsign.setError("email wrong format");
//                    isok=false;
//                }
                if(isValidEmailAddress(email)==false)
                {
                    emsign.setError("Invalid Emaill");
                    isok=true;
                }
                if(password.length()<8)
                {
                    pssign.setError("password length error");
                    isok=false;
                }

                if(isok)
                {
                    signIn(email,password);


                }
            }








    public boolean isValidEmailAddress(String email)
    {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    private void signIn(String email, String pass)
    {
        FirebaseAuth auth=FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    //todo go to ,main screen(all task activity)
                    Intent i=new Intent(signIn.this, MainTasksActivity.class);
                    startActivity(i);

                }
                else
                    {
                        emsign.setError("email or passwrod is wrong");

                }
            }
        });
    }

}
