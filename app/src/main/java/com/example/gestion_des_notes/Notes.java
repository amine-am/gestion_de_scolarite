package com.example.gestion_des_notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//public class Notes extends AppCompatActivity implements View.OnClickListener {
public class Notes extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    public CardView c;
    Spinner spinnerfil , spinnermod;
    List<String> list = new ArrayList<String>();
    List<String> listdesmodules = new ArrayList<String>();
    List<String> fullNames = new ArrayList<String>();
    TextView fullnameCommaSeprated;
    TextView filierIntutule;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        c = (CardView) findViewById(R.id.notes);
//        c.setOnClickListener(this);
        spinnerfil = (Spinner) findViewById(R.id.inputcne);
        spinnermod = (Spinner) findViewById(R.id.inputmodule);
        fullnameCommaSeprated = findViewById(R.id.outputprenom);

        SQLiteDatabase db = openOrCreateDatabase("myDB", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS etudiants(cne VARCHAR PRIMARY KEY,NOM VARCHAR ,PRENOM VARCHAR)");
        final Cursor c = db.rawQuery("select * from etudiants",null);
        if (c.moveToFirst()) {
            do {
                list.add(c.getString(0));
                fullNames.add(c.getString(1) + " ," + c.getString(2));
            } while (c.moveToNext());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        spinnerfil.setAdapter(adapter);

        db.execSQL("CREATE TABLE IF NOT EXISTS etudiants(cne VARCHAR PRIMARY KEY,NOM VARCHAR ,PRENOM VARCHAR)");
        final Cursor cu = db.rawQuery("select * from modules",null);
        int cnt = 0;
        if (cu.moveToFirst()) {
            do {
                cnt +=1;
                System.out.println("c = " + cnt);
                System.out.println("From modeul we have " + cu.getString(1));
                listdesmodules.add(cu.getString(1));
            } while (c.moveToNext());
        }
        ArrayAdapter<String> adaptermodules = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listdesmodules);
        spinnermod.setAdapter(adapter);
        changeStudentName();


        spinnerfil.setAdapter(adapter);
        spinnermod.setAdapter(adaptermodules);
        spinnerfil.setOnItemSelectedListener(this);
        spinnermod.setOnItemSelectedListener(this);
    }


    public void changeStudentName(){
        fullnameCommaSeprated.setText(
                fullNames.get(0)
        );
    }

    //Changer les categories / les designations / et les tables
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        fullnameCommaSeprated.setText(
                fullNames.get(i)
        );
        SQLiteDatabase db = openOrCreateDatabase("myDB", Context.MODE_PRIVATE,null);
        String query = "select * from inscriptions where id_etudiant =?";
        db.execSQL("CREATE TABLE IF NOT EXISTS filiers(id INTEGER PRIMARY KEY AUTOINCREMENT,INTITULE VARCHAR)");
        final Cursor c = db.rawQuery("select * from inscriptions where id_etudiant = ?" , new String[]{spinnerfil.getSelectedItem().toString()});

        if(c.moveToFirst())
        {
            do{
                filierIntutule = findViewById(R.id.outputfiliere);
                filierIntutule.setText(
                        c.getString(2)
                );
            } while(c.moveToNext());
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) { }

}