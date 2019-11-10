package com.asslan.jumana.jumanataskmanger.ui.main;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.asslan.jumana.jumanataskmanger.R;
import com.asslan.jumana.jumanataskmanger.data1.Task;
import com.asslan.jumana.jumanataskmanger.data1.TaskAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllTasksFragment extends Fragment {
    private TaskAdapter taskAdapter;
    private ListView lvTasks;


    public AllTasksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        taskAdapter=new TaskAdapter(getContext());
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_all_tasks,container,false);
        lvTasks=view.findViewById(R.id.lstvTasks);
        lvTasks.setAdapter(taskAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        readTasksFromFirebase();
    }

    public void readTasksFromFirebase()
    {
        FirebaseDatabase database=FirebaseDatabase.getInstance();// to connect to firbase
        FirebaseAuth auth=FirebaseAuth.getInstance();//to get current UID
         String uid = auth.getUid();
        DatabaseReference reference = database.getReference();

        reference.child("task").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) 
            {
                taskAdapter.clear();
                for (DataSnapshot d:dataSnapshot.getChildren())
                {
                    Task task=d.getValue(Task.class);
                    Log.d("Task",task.toString());
                    taskAdapter.add(task);
                }
                
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

}
