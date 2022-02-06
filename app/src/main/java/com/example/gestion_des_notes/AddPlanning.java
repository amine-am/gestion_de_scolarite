package com.example.gestion_des_notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddPlanning extends AppCompatActivity {

    Spinner spinner;
    List<String> list = new ArrayList<String>();
    ImageView add;
    static ArrayList<String> filieres;
    static ArrayList<String> niveau;
    static ArrayList<String> modules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_planning);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String fil = extras.getString("fil");
            String niv = extras.getString("niv");

            //Spinner for modules
            spinner = (Spinner) findViewById(R.id.inputmodule);
            SQLiteDatabase db = openOrCreateDatabase("myDB", Context.MODE_PRIVATE,null);
            Cursor c = db.rawQuery("SELECT * FROM modules", null);
            if (c.moveToFirst()) {
                do {
                    list.add(c.getString(1));
                    System.out.println(list);//adding 2nd column data
                } while (c.moveToNext());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
            spinner.setAdapter(adapter);

            filieres = new ArrayList<>();
            niveau = new ArrayList<>();
            modules = new ArrayList<>();
            try {
                SQLiteDatabase dbp = openOrCreateDatabase("myDB", Context.MODE_PRIVATE,null);
                db.execSQL("CREATE TABLE IF NOT EXISTS planning(id_fil VARCHAR ,niveau VARCHAR, id_module VARCHAR)");
                final Cursor cu = dbp.rawQuery("select * from planning",null);
                int indexfil = cu.getColumnIndex("id_fil");
                int indexniv = cu.getColumnIndex("niveau");
                int indexmod = cu.getColumnIndex("id_module");
                if(c.moveToFirst())
                {
                    do{
                        String id_filiere = cu.getString(indexfil);
                        String id_niveau = cu.getString(indexniv);
                        String id_module = cu.getString(indexmod);
                        planning.add(intutleDisplay);
                        ids.add(idDisplay);

                    } while(cu.moveToNext());
                }
            }catch (Exception ex){showToast("Failed to Fetch From Planning Table");}





        }
    }

    public void addFiliere(String text){
        filieres.add(text);
        listview.setAdapter(adapter);
    }



    private void showToast(String text){
        Toast.makeText(AddPlanning.this, text, Toast.LENGTH_SHORT).show();
    }
}