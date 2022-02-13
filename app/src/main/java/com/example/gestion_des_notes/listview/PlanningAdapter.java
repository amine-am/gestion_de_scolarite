package com.example.gestion_des_notes.listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.gestion_des_notes.R;

import java.util.ArrayList;

public class PlanningAdapter extends ArrayAdapter<String> {
    ArrayList<String> list;
    Context context;

    public PlanningAdapter(Context context,ArrayList<String>planning){
        super(context,R.layout.planning_row,planning);
        this.context = context;
        list = planning;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.planning_row, null );

        TextView ID = (TextView) convertView.findViewById(R.id.id);
        TextView Fil = (TextView) convertView.findViewById(R.id.filiere);
        TextView Niv = (TextView) convertView.findViewById(R.id.niveau);

        ID.setText(list.get(position));
        Fil.setText(list.get(position));
        Niv.setText(list.get(position));

        ImageView delete = convertView.findViewById(R.id.delete);

        return convertView;
    }
}