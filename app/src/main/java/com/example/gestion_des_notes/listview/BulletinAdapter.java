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

public class BulletinAdapter extends ArrayAdapter<Bulletin> {
    private static final String TAG = "BulletinListAdapter";
    private Context mContext;
    int mResource;
    /**
     * Default constructor for the BulletinListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public BulletinAdapter(Context context, int resource, ArrayList<Bulletin> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String module = getItem(position).getModule();
        String note = getItem(position).getNote();

        Bulletin bulletin = new Bulletin(module, note);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        TextView tvModule = (TextView) convertView.findViewById(R.id.module);
        TextView tvNote = (TextView) convertView.findViewById(R.id.note);

        tvModule.setText(module);
        tvNote.setText(String.valueOf(note));

        return convertView;
    }
}