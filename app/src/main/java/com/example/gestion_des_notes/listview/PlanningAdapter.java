package com.example.gestion_des_notes.listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.gestion_des_notes.R;

import java.util.ArrayList;

public class PlanningAdapter extends ArrayAdapter<Plan> {
    private static final String TAG = "PlanningAdapter";
    private Context mContext;
    int mResource;
    /**
     * Default constructor for the BulletinListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public PlanningAdapter(Context context, int resource, ArrayList<Plan> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String id = getItem(position).getId();
        String fil = getItem(position).getFil();
        String niv = getItem(position).getNiv();

        Plan plan = new Plan(id, fil, niv);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        TextView tvid = (TextView) convertView.findViewById(R.id.id);
        TextView tvfil = (TextView) convertView.findViewById(R.id.filiere);
        TextView tvniv = (TextView) convertView.findViewById(R.id.niveau);


        tvid.setText(id);
        tvfil.setText(fil);
        tvniv.setText(niv);

        return convertView;
    }
}