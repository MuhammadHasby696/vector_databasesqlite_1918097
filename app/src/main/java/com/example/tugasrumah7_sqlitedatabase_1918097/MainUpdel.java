package com.example.tugasrumah7_sqlitedatabase_1918097;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Sjenis, Sharga, Sdeskripsi;
    private EditText Ejenis, Eharga, Edeskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);setContentView(R.layout.activity_main_update);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Sjenis = i.getStringExtra("Ijenis");
        Sharga = i.getStringExtra("Iharga");
        Sdeskripsi = i.getStringExtra("Ideskripsi");
        Ejenis = (EditText) findViewById(R.id.updel_jenis);
        Eharga = (EditText) findViewById(R.id.updel_harga);
        Edeskripsi = (EditText) findViewById(R.id.updel_deskripsi);
        Ejenis.setText(Sjenis);
        Eharga.setText(Sharga);
        Edeskripsi.setText(Sdeskripsi);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sjenis = String.valueOf(Ejenis.getText());
                Sharga = String.valueOf(Eharga.getText());
                Sdeskripsi = String.valueOf(Edeskripsi.getText());
                if (Sjenis.equals("")){
                    Ejenis.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi jenis", Toast.LENGTH_SHORT).show();
                } else if (Sharga.equals("")){
                    Eharga.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi harga", Toast.LENGTH_SHORT).show();
                } else if (Sdeskripsi.equals("")){
                    Edeskripsi.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi deskripsi", Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateKonsumen(new Vector(Sid, Sjenis, Sharga, Sdeskripsi));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteKonsumen(new Vector(Sid, Sjenis, Sharga, Sdeskripsi));
                Toast.makeText(MainUpdel.this, "Data telah dihapus", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
