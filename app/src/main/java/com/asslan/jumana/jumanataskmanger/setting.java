package com.asslan.jumana.jumanataskmanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.SeekBar;

public class setting extends AppCompatActivity {
    private CheckBox chbox;
    private SeekBar sk1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        chbox=findViewById(R.id.chbox);
        sk1=findViewById(R.id.sk1);

    }
}
