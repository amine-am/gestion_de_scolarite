package com.example.gestion_des_notes.listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.gestion_des_notes.Filiere;
import com.example.gestion_des_notes.R;

import java.util.ArrayList;

public class FiliereAdapter extends ArrayAdapter<String> {
    ArrayList<String> list;
    Context context;

    public FiliereAdapter(@NonNull Context context, ArrayList<String> filieres) {
        super(context, R.layout.list_row, filieres);
        this.context = context;
        list = filieres;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_row, null);
            TextView id = convertView.findViewById(R.id.id);
            String tmp;
            Integer int_tmp = position + 1;
            tmp = int_tmp.toString();
            id.setText(tmp);
            TextView name = convertView.findViewById(R.id.name);
            name.setText(list.get(position));
        }
        return convertView;
    }
}
