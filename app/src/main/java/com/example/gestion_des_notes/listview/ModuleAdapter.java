package com.example.gestion_des_notes.listview;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.gestion_des_notes.Filiere;
import com.example.gestion_des_notes.Modules;
import com.example.gestion_des_notes.R;

import java.util.ArrayList;

public class ModuleAdapter extends ArrayAdapter<String> {

    ArrayList<String> list;
    ArrayList<String> listids;
    Context context;

    public ModuleAdapter(@NonNull Context context, ArrayList<String> modules , ArrayList<String> ids) {
        super(context, R.layout.list_row, modules);
        this.context = context;
        list = modules;
        listids = ids;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_row, null);

            TextView id = convertView.findViewById(R.id.id);
            try{
                id.setText(listids.get(position));
            }catch (Exception e){
                id.setText(listids.get(position -1 ));
            }
            TextView name = convertView.findViewById(R.id.name);
            try{
                name.setText(list.get(position));
            }catch (Exception e){
                name.setText(list.get(position -1 ));
            }
            ImageView del = convertView.findViewById(R.id.delete);

            del.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    try{
                        SQLiteDatabase db = getContext().openOrCreateDatabase("myDB", Context.MODE_PRIVATE,null);
                        String sql = "delete from modules where id = ?";
                        SQLiteStatement statement = db.compileStatement(sql);
                        statement.bindString(1,listids.get(position));
                        statement.execute();
                        Modules.deleteModule(position);
                        showToast("Module supprimé");
                    }catch (Exception e){
                        System.out.println(e);
                    }
                }
            });
        }
        return convertView;
    }

    private void showToast(String text){
        Toast.makeText(this.context, text, Toast.LENGTH_SHORT).show();
    }


}
