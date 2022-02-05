package com.example.gestion_des_notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class AddEtudiant extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rb;
    String nivauChoice;
    static ArrayList<String> filieres;
    static ArrayList<String> ids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_etudiant);
        rg = findViewById(R.id.radiogrp);
        try {
            SQLiteDatabase db = openOrCreateDatabase("myDB", Context.MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS filiers(id INTEGER PRIMARY KEY AUTOINCREMENT,INTITULE VARCHAR)");
            final Cursor c = db.rawQuery("select * from filiers",null);
            int id = c.getColumnIndex("id");
            int intutle = c.getColumnIndex("INTITULE");
            if(c.moveToFirst())
            {
                do{
                    String idDisplay = c.getString(id);
                    String intutleDisplay = c.getString(intutle);
                    filieres.add(intutleDisplay);
                    ids.add(idDisplay);

                } while(c.moveToNext());
            }
        }catch (Exception ex){showToast("Failed to Fetch From Filiere Table");}


    }

    public void checkbutton(View view){
        int radioID = rg.getCheckedRadioButtonId();

        rb = findViewById(radioID);
        nivauChoice = (String) rb.getText();
        System.out.println("================================>" + nivauChoice);
    }

    private void showToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}