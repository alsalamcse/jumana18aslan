package com.asslan.jumana.jumanataskmanger.data1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.asslan.jumana.jumanataskmanger.R;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TaskAdapter extends ArrayAdapter<Task>
{

    public TaskAdapter(@NonNull Context context) {
        super(context, R.layout.taskitem);
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //building item view
        View vitem= LayoutInflater.from(getContext()).inflate(R.layout.taskitem,parent,false);
        TextView tvTitle=vitem.findViewById(R.id.itmTvTitle);
        TextView tvSubject=vitem.findViewById(R.id.itmTvSubject);
        RatingBar rbPrio=vitem.findViewById(R.id.itmRatingPrio);
        CheckBox cbIsCompleted=vitem.findViewById(R.id.itmChbxIsCompleted);
        ImageView itmImgInfo=vitem.findViewById(R.id.itmImgInfo);



        //getting data source
        final Task myTask = getItem(position);

        //todo טיפול באירוע מחיקה

        cbIsCompleted.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (isChecked)
                 {
                     //todo delete this item
                     FirebaseUtils.getRefrence().child(myTask.getKey()).removeValue(new DatabaseReference.CompletionListener() {
                         @Override
                         public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                                          if (databaseError==null)
                                          {
                                              Toast.makeText(getContext(), "deleted", Toast.LENGTH_SHORT).show();
                                          }
                                          else {
                                              Toast.makeText(getContext(), "not deleted"+databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                                          }
                         }
                     });
                 }
            }
        });

        itmImgInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),myTask.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });




        //connect item view to data source
        tvTitle.setText(myTask.getTitle());
        tvSubject.setText(myTask.getSub());
        rbPrio.setRating(myTask.getPriority());
        cbIsCompleted.setChecked(false);

        return vitem;
    }
    public void ShowMenu(){

    }
}



////