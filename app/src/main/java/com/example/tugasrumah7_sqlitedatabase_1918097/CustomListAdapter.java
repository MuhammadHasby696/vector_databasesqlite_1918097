package com.example.tugasrumah7_sqlitedatabase_1918097;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Vector> Vector;
    public CustomListAdapter(Activity activity, List<Vector>
            Vector) {
        this.activity = activity;
        this.Vector = Vector;
    }
    @Override
    public int getCount() {
        return Vector.size();
    }

    @Override
    public Object getItem(int location) {
        return Vector.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView jenis = (TextView) convertView.findViewById(R.id.text_jenis);
        TextView harga = (TextView) convertView.findViewById(R.id.text_harga);
        TextView deskripsi = (TextView) convertView.findViewById(R.id.text_deskripsi);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.iconid);
        Vector m = Vector.get(position);
        jenis.setText("Jenis Vector : "+ m.get_jenis());
        harga.setText("Harga : "+ m.get_harga());
        deskripsi.setText("Deskripsi : "+ m.get_deskripsi());
        return convertView;
    }
}
