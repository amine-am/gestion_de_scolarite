package com.example.gestion_des_notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Etudiants extends AppCompatActivity implements View.OnClickListener {

    public CardView c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etudiants);

        c = (CardView) findViewById(R.id.etudiants);
        c.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, AddEtudiant.class);
        startActivity(i);

    }
}