package com.example.gestion_des_notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gestion_des_notes.listview.Bulletin;
import com.example.gestion_des_notes.listview.BulletinAdapter;

import java.util.ArrayList;

public class Bulletins extends AppCompatActivity {

    String module;
    String note;
    EditText noteInput;
    Button ajouterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulletins);


        ListView BulletinList = (ListView) findViewById(R.id.listbulletin);
        ArrayList<Bulletin> resultatList = new ArrayList<>();

        BulletinAdapter adapter1 = new BulletinAdapter(this, R.layout.bulletin_row, resultatList);
        BulletinList.setAdapter(adapter1);
        ArrayList<String> bulletinModules = new ArrayList<String>();
        ArrayList<Double> bulletinNotes = new ArrayList<Double>();

        ajouterButton = (Button) findViewById(R.id.ajouterButton);
        ajouterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (note<0 && note>20) {
                    String noteToast = "La note doit être entre 0 et 20";
                    showToast(noteToast);
                }else{
                    Bulletin result = new Bulletin(module, note);
                    String gotModule = result.getModule();
                    if (bulletinModules.contains(gotModule)){
                        String moduleToast = "Module existe deja!";
                        showToast(moduleToast);
                    }else{
                        resultatList.add(result);
                        bulletinModules.add(gotModule);
                        bulletinNotes.add(note);
                        String creationToast ="Résultat ajouté!";
                        showToast(creationToast);

                        if (resultatList.size() == modules.size()) {
                            double sum = 0;
                            for(int i = 0; i < modules.size(); i++)
                                sum += bulletinNotes.get(i);
                            Double moyenne = sum/5;
                            ((TextView)findViewById(R.id.moyenne)).setText(String.valueOf(moyenne));
                        }
                    }
                }
            }
        });

    }
}
    private void showToast(String text){
        Toast.makeText(Bulletins.this, text, Toast.LENGTH_SHORT).show();
    }
