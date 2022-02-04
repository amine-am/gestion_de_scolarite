package com.example.gestion_des_notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gestion_des_notes.listview.FiliereAdapter;
import com.example.gestion_des_notes.listview.ModuleAdapter;

import java.util.ArrayList;

public class Modules extends AppCompatActivity {

    static ListView listview;
    static ArrayList<String> modules;
    static ArrayList<String> ids;
    static ModuleAdapter adapter;
    EditText input;
    ImageView add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules);

        modules = new ArrayList<>();
        ids = new ArrayList<>();
        try {

            SQLiteDatabase db = openOrCreateDatabase("myDB", Context.MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS modules(id INTEGER PRIMARY KEY AUTOINCREMENT,NOM VARCHAR)");
            final Cursor c = db.rawQuery("select * from modules",null);
            int id = c.getColumnIndex("id");
            int intutle = c.getColumnIndex("NOM");
            if(c.moveToFirst())
            {
                do{
                    String idDisplay = c.getString(id);
                    String intutleDisplay = c.getString(intutle);
                    modules.add(intutleDisplay);
                    ids.add(idDisplay);
                } while(c.moveToNext());
            }
        }catch (Exception ex){showToast("Failed to Fetch From Modules Table");}

        listview = findViewById(R.id.listmodules);
        input = findViewById(R.id.inputmodule);
        add = findViewById(R.id.addmodule);

        adapter = new ModuleAdapter(getApplicationContext(), modules, ids);
        listview.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String text = input.getText().toString();
                if (text == null || text.length() == 0){
                    showToast("Non autorisé");
                }else{
                    addModuke(text);
                    input.setText("");
                }
            }
        });
    }


    public void addModuke(String text){
        modules.add(text);
        listview.setAdapter(adapter);
        insertFilierDB(text);
    }

    public void insertFilierDB(String modName){
        try {
            SQLiteDatabase db = openOrCreateDatabase("myDB", Context.MODE_PRIVATE,null);
            String sql = "insert into modules(nom)values(?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1,modName);
            statement.execute();
            System.out.println("Module added");
        }catch (Exception ex){showToast("Failed To Insert Record");}
    }

    public static void deleteModule(int delete){
        modules.remove(delete);
        listview.setAdapter(adapter);
    }

    private void showToast(String text){
        Toast.makeText(Modules.this, text, Toast.LENGTH_SHORT).show();
    }


}