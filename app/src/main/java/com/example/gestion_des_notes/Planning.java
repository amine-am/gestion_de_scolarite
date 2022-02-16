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
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.gestion_des_notes.listview.Bulletin;
import com.example.gestion_des_notes.listview.BulletinAdapter;
import com.example.gestion_des_notes.listview.Plan;
import com.example.gestion_des_notes.listview.PlanningAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Planning extends AppCompatActivity implements View.OnClickListener {

    public CardView card;
    Spinner spinnerfil;
    private Spinner spinnerniv;
    private static final String[] niveau = {"M1","M2"};
    List<String> list = new ArrayList<String>();
    //List Planning
    static ListView listView;
    static ArrayList<String> planningid;
    static ArrayList<String> planningfil;
    static ArrayList<String> planningniv;
    static PlanningAdapter planningadapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

        //Niveau Spinner
        spinnerniv = (Spinner)findViewById(R.id.inputniveau);
        ArrayAdapter<String>adapterniv = new ArrayAdapter<String>(Planning.this,
                android.R.layout.simple_spinner_item,niveau);
        adapterniv.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerniv.setAdapter(adapterniv);

        card = (CardView) findViewById(R.id.planning);
        card.setOnClickListener(this);

        //Filiere Spinner
        spinnerfil = (Spinner) findViewById(R.id.inputfiliere);
        SQLiteDatabase db = openOrCreateDatabase("myDB", Context.MODE_PRIVATE,null);
        Cursor c = db.rawQuery("SELECT * FROM filiers", null);
        if (c.moveToFirst()) {
            do {
                list.add(c.getString(1));
                System.out.println(list);//adding 2nd column data
            } while (c.moveToNext());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        spinnerfil.setAdapter(adapter);

        ListView PlanList = (ListView) findViewById(R.id.listplanning);
        ArrayList<Plan> resultatList = new ArrayList<>();

        PlanningAdapter adapter1 = new PlanningAdapter(this, R.layout.planning_row, resultatList);
        PlanList.setAdapter(adapter1);



        showToast("Planning" + getFil() + getNiv() + "ajouté");




    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, AddPlanning.class);
        String fil = spinnerfil.getSelectedItem().toString();
        String niv = spinnerniv.getSelectedItem().toString();
        i.putExtra("fil",fil);
        i.putExtra("niv",niv);
        startActivity(i);

    }
    private void showToast(String text){
        Toast.makeText(Planning.this, text, Toast.LENGTH_SHORT).show();
    }


}