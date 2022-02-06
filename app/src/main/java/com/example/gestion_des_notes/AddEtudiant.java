package com.example.gestion_des_notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

public class AddEtudiant extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rb;
    String nivauChoice;
    Spinner spinnerfil;
    List<String> list = new ArrayList<String>();
    TextView cnei , nomi , prenomi;
    MaterialCardView addButton;
    boolean studetGetAddedWithScuccess = false;
    String cne;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_etudiant);
        rg = findViewById(R.id.radiogrp);
        spinnerfil = (Spinner) findViewById(R.id.input);
        SQLiteDatabase db = openOrCreateDatabase("myDB", Context.MODE_PRIVATE,null);
        Cursor c = db.rawQuery("SELECT * FROM filiers", null);
//        arrfil = new String[c.getCount()];
        if (c.moveToFirst()) {
            do {
                list.add(c.getString(1));
                System.out.println(list);//adding 2nd column data
            } while (c.moveToNext());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        spinnerfil.setAdapter(adapter);

        addButton = findViewById(R.id.addstudent);
        cnei = findViewById(R.id.inputmodule);
        nomi = findViewById(R.id.inputnom);
        prenomi = findViewById(R.id.inputprenom);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    cne = cnei.getText().toString();
                    insertStudentToDB(
                            cne,
                            nomi.getText().toString() ,
                            prenomi.getText().toString()
                    );
                    studetGetAddedWithScuccess = true;
                    cnei.setText("");
                    nomi.setText("");
                    prenomi.setText("");
                }catch (Exception ex){
                    System.out.println(ex);
                    showToast("ERROR IN ETUDIANT DB");
                    studetGetAddedWithScuccess = false;
                }
                if(studetGetAddedWithScuccess){
                    try{
                        insertInscriptiontToDB(cne ,
                                nivauChoice ,
                                spinnerfil.getSelectedItem().toString()
                        );
                        finish();
                    }catch (Exception ex){
                        System.out.println(ex);
                        showToast("ERR IN INSCRIPTION DB");
                    }
                }
            }
        });


    }

    public void checkbutton(View view){
        int radioID = rg.getCheckedRadioButtonId();
        rb = findViewById(radioID);
        nivauChoice = (String) rb.getText();
    }

    void insertStudentToDB(String cne,String nom,String prenom){
        try{
            SQLiteDatabase db = openOrCreateDatabase("myDB", Context.MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS etudiants(cne VARCHAR PRIMARY KEY,NOM VARCHAR ,PRENOM VARCHAR)");
            Cursor c = db.rawQuery("SELECT * FROM filiers", null);
            String sql = "insert into etudiants(CNE , NOM , PRENOM)values(?,?,?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1,cne);
            statement.bindString(2,nom);
            statement.bindString(3,prenom);
            statement.execute();
        }catch (Exception ex){
            showToast("ERROR IN DB !!");
            System.out.println(ex);
        }
    }

    void insertInscriptiontToDB(String cne,String niveau,String filier){
        try{
            SQLiteDatabase db = openOrCreateDatabase("myDB", Context.MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS inscriptions(id_etudiant VARCHAR,nivau VARCHAR ,Filier VARCHAR)");
            Cursor c = db.rawQuery("SELECT * FROM filiers", null);
            String sql = "insert into inscriptions(id_etudiant ,nivau  ,Filier)values(?,?,?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1,cne);
            statement.bindString(2,niveau);
            statement.bindString(3,filier);
            statement.execute();
        }catch (Exception ex){
            showToast("ERROR IN DB !!");
            System.out.println(ex);
        }
    }

    private void showToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}