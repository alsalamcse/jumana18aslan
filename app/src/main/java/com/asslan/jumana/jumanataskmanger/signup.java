package com.asslan.jumana.jumanataskmanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class signup extends AppCompatActivity
{
    private EditText fname,lname,em2,pass2,rewarte,phone;
    private Button save1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        fname=findViewById(R.id.fName);
        lname=findViewById(R.id.lName);
        em2=findViewById(R.id.emSign);
        pass2=findViewById(R.id.pass2);
        rewarte=findViewById(R.id.rewarte);
        phone=findViewById(R.id.phone);
        save1=findViewById(R.id.save1);




    }
}
