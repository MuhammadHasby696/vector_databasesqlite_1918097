package com.example.tugasrumah7_sqlitedatabase_1918097;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Ejenis, Eharga, Edeskripsi;
    private String Sjenis, Sharga, Sdeskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);

        db = new MyDatabase(this);
        Ejenis = (EditText) findViewById(R.id.create_jenis);
        Eharga = (EditText) findViewById(R.id.create_harga);
        Edeskripsi = (EditText) findViewById(R.id.create_deskripsi);

        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sjenis = String.valueOf(Ejenis.getText());
                Sharga = String.valueOf(Eharga.getText());
                Sdeskripsi = String.valueOf(Edeskripsi.getText());
                if (Sjenis.equals("")){
                    Ejenis.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi jenis", Toast.LENGTH_SHORT).show();
                }
                else if (Sharga.equals("")) {
                    Eharga.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi harga", Toast.LENGTH_SHORT).show();
                }
                else if (Sdeskripsi.equals("")) {
                    Edeskripsi.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi deskripsi", Toast.LENGTH_SHORT).show();
                }
                else {
                    Ejenis.setText("");
                    Eharga.setText("");
                    Edeskripsi.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah", Toast.LENGTH_SHORT).show();
                    db.CreateKonsumen(new Vector(null, Sjenis, Sharga, Sdeskripsi));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
