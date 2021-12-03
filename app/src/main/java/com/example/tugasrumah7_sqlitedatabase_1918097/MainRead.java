package com.example.tugasrumah7_sqlitedatabase_1918097;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Vector> listVector = new ArrayList<Vector>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, listVector);
        mListView = (ListView) findViewById(R.id.list_vector);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        listVector.clear();
        List<Vector> vector = db.ReadKonsumen();
        for (Vector mhs : vector) {
            Vector daftar = new Vector();
            daftar.set_id(mhs.get_id());
            daftar.set_jenis(mhs.get_jenis());
            daftar.set_harga(mhs.get_harga());
            daftar.set_deskripsi(mhs.get_deskripsi());
            listVector.add(daftar);if ((listVector.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Vector detailVct = (Vector)o;
        String Sid = detailVct.get_id();
        String Sjenis = detailVct.get_jenis();
        String Sharga = detailVct.get_harga();
        String Sdeskripsi = detailVct.get_deskripsi();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Ijenis", Sjenis);
        goUpdel.putExtra("Iharga", Sharga);
        goUpdel.putExtra("Ideskripsi", Sdeskripsi);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        listVector.clear();
        mListView.setAdapter(adapter_off);
        List<Vector> vector = db.ReadKonsumen();
        for (Vector vct : vector) {
            Vector daftar = new Vector();
            daftar.set_id(vct.get_id());
            daftar.set_jenis(vct.get_jenis());
            daftar.set_harga(vct.get_harga());
            daftar.set_deskripsi(vct.get_deskripsi());
            listVector.add(daftar);
            if ((listVector.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
