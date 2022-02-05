package com.example.gestion_des_notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
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
    static ArrayList<String> ids;
    static FiliereAdapter adapter;
    EditText input;
    ImageView add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filiere);

        filieres = new ArrayList<>();
        ids = new ArrayList<>();
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

        listview = findViewById(R.id.listfiliere);
        input = findViewById(R.id.inputfiliere);
        add = findViewById(R.id.addfiliere);

        adapter = new FiliereAdapter(getApplicationContext(), filieres, ids);
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
                }
            }
        });

    }

    public void addFiliere(String text){
        filieres.add(text);
        listview.setAdapter(adapter);
        insertFilierDB(text);
    }

    public void insertFilierDB(String filName){
        try {
            SQLiteDatabase db = openOrCreateDatabase("myDB", Context.MODE_PRIVATE,null);
            String sql = "insert into filiers(INTITULE)values(?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1,filName);
            statement.execute();
            System.out.println("Filier added");
        }catch (Exception ex){showToast("Failed To Insert Record");}
    }

    public static void deleteFiliere(int delete){
        filieres.remove(delete);
        listview.setAdapter(adapter);
    }

    private void showToast(String text){
        Toast.makeText(Filiere.this, text, Toast.LENGTH_SHORT).show();
    }
}
