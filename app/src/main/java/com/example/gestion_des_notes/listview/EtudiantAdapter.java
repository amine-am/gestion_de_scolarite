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

import com.example.gestion_des_notes.Etudiants;
import com.example.gestion_des_notes.Filiere;
import com.example.gestion_des_notes.R;

import java.util.ArrayList;

public class EtudiantAdapter extends ArrayAdapter<String> {


    ArrayList<String> listN;
    ArrayList<String> listPN;
    ArrayList<String> listids;
    Context context;

    public EtudiantAdapter(@NonNull Context context, ArrayList<String> noms ,ArrayList<String> prenoms, ArrayList<String> ids) {
        super(context, R.layout.etudiant_row, noms);
        this.context = context;
        listN = noms;
        listPN = prenoms;
        listids = ids;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.etudiant_row, null);

            TextView id = convertView.findViewById(R.id.cne);
            try{
                id.setText(listids.get(position));
            }catch (Exception e){
                id.setText(listids.get(position -1 ));
            }
            TextView name = convertView.findViewById(R.id.nom);
            try{
                name.setText(listN.get(position));
            }catch (Exception e){
                name.setText(listN.get(position -1 ));
            }
            TextView prenom = convertView.findViewById(R.id.prenom);
            try{
                prenom.setText(listPN.get(position));
            }catch (Exception e){
                prenom.setText(listPN.get(position -1 ));
            }
            ImageView del = convertView.findViewById(R.id.delete);

            del.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    try{
                        SQLiteDatabase db = getContext().openOrCreateDatabase("myDB", Context.MODE_PRIVATE,null);
                        String sql = "delete from etudiants where cne = ?";
                        SQLiteStatement statement = db.compileStatement(sql);
                        statement.bindString(1,listids.get(position));
                        statement.execute();
                        Etudiants.deleteEtudiant(position);
                        showToast("Done");
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
