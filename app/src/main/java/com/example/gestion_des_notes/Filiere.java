package com.example.gestion_des_notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Filiere extends AppCompatActivity {

    ListView listview;
    ArrayList<String> filieres;
    ArrayAdapter<String> adapter;
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


        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, filieres);
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

    public void addFiliere(String text){
        filieres.add(text);
        listview.setAdapter(adapter);
    }

    private void showToast(String text){
        Toast.makeText(Filiere.this, text, Toast.LENGTH_SHORT).show();
    }
}
