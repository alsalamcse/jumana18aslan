package com.asslan.jumana.jumanataskmanger.data1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.asslan.jumana.jumanataskmanger.R;

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
        ImageView ivInfo=vitem.findViewById(R.id.itmImgInfo);

        Task myTask = getItem(position);//getting data source

        //connect item view to data source
        tvTitle.setText(myTask.getTitle());
        tvSubject.setText(myTask.getSub());
        rbPrio.setRating(myTask.getPrio(priority));
        cbIsCompleted.setChecked(false);

        return vitem;
    }
}



