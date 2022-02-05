package com.example.gestion_des_notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gestion_des_notes.listview.EtudiantAdapter;
import com.example.gestion_des_notes.listview.FiliereAdapter;

import java.util.ArrayList;

public class Etudiants extends AppCompatActivity implements View.OnClickListener {

    public CardView c;
    static ListView listview;
    static ArrayList<String> noms;
    static ArrayList<String> prenoms;
    static ArrayList<String> ids;
    static EtudiantAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etudiants);

        c = (CardView) findViewById(R.id.etudiants);
        c.setOnClickListener(this);

        noms = new ArrayList<>();
        prenoms = new ArrayList<>();
        ids = new ArrayList<>();
        try {
            SQLiteDatabase db = openOrCreateDatabase("myDB", Context.MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS etudiants(cne VARCHAR PRIMARY KEY,NOM VARCHAR ,PRENOM VARCHAR)");
            final Cursor c = db.rawQuery("select * from etudiants",null);
            int cne = c.getColumnIndex("cne");
            int nom = c.getColumnIndex("NOM");
            int prenom = c.getColumnIndex("PRENOM");
            if(c.moveToFirst())
            {
                do{
                    String idDisplay = c.getString(cne);
                    String nomDisplay = c.getString(nom);
                    String prenomDisplay = c.getString(prenom);

                    noms.add(nomDisplay);
                    prenoms.add(prenomDisplay);
                    ids.add(idDisplay);

                } while(c.moveToNext());
            }
        }catch (Exception ex){showToast("Failed to Fetch From Etudiats Table");}
        listview = findViewById(R.id.listfiliere);

        adapter = new EtudiantAdapter(getApplicationContext(), noms, prenoms, ids);
        listview.setAdapter(adapter);
    }



    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, AddEtudiant.class);
        startActivity(i);
    }

    private void showToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    public static void deleteEtudiant(int delete){
        noms .remove(delete);
        prenoms.remove(delete);
        ids.remove(delete);
        listview.setAdapter(adapter);
    }

}