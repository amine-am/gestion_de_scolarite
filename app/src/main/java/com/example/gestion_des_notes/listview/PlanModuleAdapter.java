package com.example.gestion_des_notes.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.gestion_des_notes.R;

import java.util.ArrayList;

public class PlanModuleAdapter extends ArrayAdapter<PlanModule> {
    private Context mContext;
    int mResource;
    /**
     * Default constructor for the BulletinListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public PlanModuleAdapter(Context context, int resource, ArrayList<PlanModule> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String id = getItem(position).getId();
        String module = getItem(position).getModule();

        PlanModule bulletin = new PlanModule(id, module);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        TextView tvId = (TextView) convertView.findViewById(R.id.id);
        TextView tvModule = (TextView) convertView.findViewById(R.id.name);

        tvId.setText(id);
        tvModule.setText(module);

        return convertView;
    }
}