package com.example.gestion_des_notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.SQLOutput;

public class Planning extends AppCompatActivity implements View.OnClickListener {

    public CardView c;
    Spinner spinnerfil;
    String arrfil[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

        c = (CardView) findViewById(R.id.planning);
        c.setOnClickListener(this);
        spinnerfil = (Spinner) findViewById(R.id.inputfiliere);
        SQLiteDatabase db = openOrCreateDatabase("myDB", Context.MODE_PRIVATE,null);
        Cursor c = db.rawQuery("SELECT * FROM filiers", null);
        arrfil = new String[c.getCount()];
        c.moveToFirst();
        for (int i=0;i< arrfil.length;i++){
            arrfil[i] = c.getString(1);
            System.out.println("THE DATAS");
            System.out.println(i);
            System.out.println(arrfil[i]);
            c.moveToFirst();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrfil);
        spinnerfil.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, AddPlanning.class);
        startActivity(i);

    }
    private void showToast(String text){
        Toast.makeText(Planning.this, text, Toast.LENGTH_SHORT).show();
    }
}