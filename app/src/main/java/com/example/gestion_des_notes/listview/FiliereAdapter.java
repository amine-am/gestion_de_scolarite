package com.example.gestion_des_notes.listview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.gestion_des_notes.Bulletins;
import com.example.gestion_des_notes.Etudiants;
import com.example.gestion_des_notes.Filiere;
import com.example.gestion_des_notes.Modules;
import com.example.gestion_des_notes.Notes;
import com.example.gestion_des_notes.Planning;
import com.example.gestion_des_notes.R;

import java.util.ArrayList;

public class FiliereAdapter extends ArrayAdapter<String> {

    ArrayList<String> list;
    ArrayList<String> listids;
    Context context;

    public FiliereAdapter(@NonNull Context context, ArrayList<String> filieres , ArrayList<String> ids) {
        super(context, R.layout.list_row, filieres);
        this.context = context;
        list = filieres;
        listids = ids;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_row, null);
            TextView id = convertView.findViewById(R.id.id);
            id.setText(listids.get(position));
            TextView name = convertView.findViewById(R.id.name);
            name.setText(list.get(position));

            ImageView del = convertView.findViewById(R.id.delete);
            del.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    try{
                        SQLiteDatabase db = getContext().openOrCreateDatabase("myDB", Context.MODE_PRIVATE,null);
                        String sql = "delete from filiers where id = ?";
                        SQLiteStatement statement = db.compileStatement(sql);
                        statement.bindString(1,listids.get(position));
                        statement.execute();
                    }catch (Exception e){
                        System.out.println(e);
                    }
                }
            });
        }
        return convertView;
    }


}


