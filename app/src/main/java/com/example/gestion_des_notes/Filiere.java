package com.example.gestion_des_notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gestion_des_notes.listview.FiliereAdapter;

import java.util.ArrayList;

public class Filiere extends AppCompatActivity {

    static ListView listview;
    static ArrayList<String> filieres;
    static FiliereAdapter adapter;
    EditText input;
    ImageView add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filiere);

        listview = findViewById(R.id.listfiliere);
        input = findViewById(R.id.inputfiliere);
        add = findViewById(R.id.addfiliere);

        filieres = new ArrayList<>();
        filieres.add("MBD");


        adapter = new FiliereAdapter(getApplicationContext(), filieres);
        listview.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String text = input.getText().toString();
                if (text == null || text.length() == 0){
                    showToast("Non autorisé");
                }else{
                    addFiliere(text);
                    input.setText("");
                    showToast("Filière " + text + " ajoutée.");
                }
            }
        });
    }

    public static void addFiliere(String text){
        filieres.add(text);
        listview.setAdapter(adapter);
    }

    public static void deleteFiliere(int delete){
        filieres.remove(delete);
        listview.setAdapter(adapter);
    }

    private void showToast(String text){
        Toast.makeText(Filiere.this, text, Toast.LENGTH_SHORT).show();
    }
}
