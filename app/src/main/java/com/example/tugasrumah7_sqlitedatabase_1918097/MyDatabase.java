package com.example.tugasrumah7_sqlitedatabase_1918097;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_vectorart";
    private static final String tb_konsumen = "tb_konsumen";
    private static final String tb_konsumen_id = "id";
    private static final String tb_konsumen_jenis = "jenis";
    private static final String tb_konsumen_harga = "harga";
    private static final String tb_konsumen_deskripsi = "deskripsi";
    private static final String CREATE_TABLE_VECTORART = "CREATE TABLE " +
    tb_konsumen +"("
            + tb_konsumen_id + " INTEGER PRIMARY KEY ,"
            + tb_konsumen_jenis + " TEXT ,"
            + tb_konsumen_harga + " TEXT ,"
            + tb_konsumen_deskripsi + " TEXT "+ ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_VECTORART);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }

    public void CreateKonsumen(Vector data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_konsumen_id, data.get_id());
        values.put(tb_konsumen_jenis, data.get_jenis());
        values.put(tb_konsumen_harga, data.get_harga());
        values.put(tb_konsumen_deskripsi, data.get_deskripsi());
        db.insert(tb_konsumen, null, values);
        db.close();
    }

    public List<Vector> ReadKonsumen() {
        List<Vector> listCsn = new ArrayList<Vector>();
        String selectQuery = "SELECT * FROM " + tb_konsumen;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Vector data = new Vector();
                data.set_id(cursor.getString(0));
                data.set_jenis(cursor.getString(1));
                data.set_harga(cursor.getString(2));
                data.set_deskripsi(cursor.getString(3));
                listCsn.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listCsn;
    }

    public int UpdateKonsumen(Vector data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_konsumen_jenis, data.get_jenis());
        values.put(tb_konsumen_harga, data.get_harga());
        values.put(tb_konsumen_deskripsi, data.get_deskripsi());
        return db.update(tb_konsumen, values, tb_konsumen_id + " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteKonsumen(Vector data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_konsumen,tb_konsumen_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}
