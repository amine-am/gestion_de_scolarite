package com.example.gestion_des_notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Planning extends AppCompatActivity implements View.OnClickListener {

    public CardView c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

        c = (CardView) findViewById(R.id.planning);
        c.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, AddPlanning.class);
        startActivity(i);

    }
}