package com.asslan.jumana.jumanataskmanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class signIn extends AppCompatActivity {
    private EditText emsign,pssign;
    private Button singIn1,signUp1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        emsign=findViewById(R.id.emSign);
        pssign=findViewById(R.id.psSign);
        singIn1=findViewById(R.id.signIn1);
        signUp1=findViewById(R.id.signUp1);




    }

}
