package com.asslan.jumana.jumanataskmanger;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import com.asslan.jumana.jumanataskmanger.data1.Task;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addTask extends AppCompatActivity {
    private EditText etTitle,etSub;
    private SeekBar sk1;
    private Button save2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        etTitle = findViewById(R.id.etTitle);
        etSub = findViewById(R.id.etSub);
        sk1 = findViewById(R.id.sk1);
        save2 = findViewById(R.id.save2);


        save2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });
    }

            private void dataHandler() {
                boolean isok = true;
                String Title = etTitle.getText().toString();
                String Subject = etSub.getText().toString();
                int priority = sk1.getProgress();

                if (Title.length() == 0) {
                    etTitle.setError("Enter Title");
                    isok = false;
                }
                if (Subject.length() == 0) {
                    etSub.setError("Enter Subject");
                    isok = false;
                }
                if (isok) {
                    Task t = new Task();
                    t.setTitle(Title);
                    t.setSub(Subject);

                    createTask(t);

                }
            }



    //save data base
    private void createTask(Task t) {
        //1

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //2
        DatabaseReference reference = database.getReference();
        //to get the user id (or other details like email)
        FirebaseAuth auth=FirebaseAuth.getInstance();
        String uid = auth.getCurrentUser().getUid();
        t.setOwner(uid);


        String key = reference.child("tasks").push().getKey();
        reference.child("tasks").child(uid).child(key).setValue(t).addOnCompleteListener(addTask.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull com.google.android.gms.tasks.Task<Void> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(addTask.this, "Add ", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(addTask.this, "Add Failed"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
