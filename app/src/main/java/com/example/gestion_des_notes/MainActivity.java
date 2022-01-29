package com.example.gestion_des_notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public CardView c1, c2, c3, c4, c5 ,c6;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c1 = (CardView) findViewById(R.id.filiere);
        c2 = (CardView) findViewById(R.id.modules);
        c3 = (CardView) findViewById(R.id.etudiants);
        c4 = (CardView) findViewById(R.id.planning);
        c5 = (CardView) findViewById(R.id.notes);
        c6 = (CardView) findViewById(R.id.bulletins);

        c1.setOnClickListener(this);
        c2.setOnClickListener(this);
        c3.setOnClickListener(this);
        c4.setOnClickListener(this);
        c5.setOnClickListener(this);
        c6.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.filiere: i = new Intent(this, Filiere.class);startActivity(i);break;
            case R.id.modules: i = new Intent(this, Modules.class);startActivity(i);break;
            case R.id.etudiants: i = new Intent(this, Etudiants.class);startActivity(i);break;
            case R.id.planning: i = new Intent(this, Planning.class);startActivity(i);break;
            case R.id.notes:i = new Intent(this, Notes.class);startActivity(i);break;
            case R.id.bulletins:i = new Intent(this, Bulletins.class);startActivity(i);break;
        }
    }
}