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
    Spinner spinnerfil;
    List<String> list = new ArrayList<String>();
    List<String> fullNames = new ArrayList<String>();
    TextView fullnameCommaSeprated;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        c = (CardView) findViewById(R.id.notes);
//        c.setOnClickListener(this);
        spinnerfil = (Spinner) findViewById(R.id.inputcne);
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
        changeStudentName();


        spinnerfil.setAdapter(adapter);
        spinnerfil.setOnItemSelectedListener(this);

    }


    public void changeStudentName(){
        fullnameCommaSeprated.setText(
                fullNames.get(0)
        );
    }

    private void showToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    //Changer les categories / les designations / et les tables
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        fullnameCommaSeprated.setText(
                fullNames.get(i)
        );
        SQLiteDatabase db = openOrCreateDatabase("myDB", Context.MODE_PRIVATE,null);
//        db.execSQL("CREATE TABLE IF NOT EXISTS filiers(id INTEGER PRIMARY KEY AUTOINCREMENT,INTITULE VARCHAR)");MUST BE INSCRIPTIONS
        final Cursor c = db.rawQuery("select * from inscriptions where id_etudiant = \" " + spinnerfil.getSelectedItem().toString() + "\"",null);
        if(c.moveToFirst())
        {
            do{
                System.out.println("FIIIIIIIL  = " + c.getString(0));
            } while(c.moveToNext());
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) { }

}