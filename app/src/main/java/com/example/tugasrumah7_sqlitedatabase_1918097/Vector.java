package com.example.tugasrumah7_sqlitedatabase_1918097;

public class Vector {
    private String _id, _jenis, _harga, _deskripsi;
    public Vector(String id, String jenis, String harga, String deskripsi) {
        this._id = id;
        this._jenis = jenis;
        this._harga = harga;
        this._deskripsi = deskripsi;
    }

    public Vector() {

    }

    public String get_id() {
        return _id;
    }
    public String get_jenis() {
        return _jenis;
    }
    public String get_harga() {
        return _harga;
    }
    public String get_deskripsi() {
        return _deskripsi;
    }
    public void set_id(String _id) { this._id = _id; }
    public void set_jenis(String _jenis) { this._jenis = _jenis; }
    public void set_harga(String _harga) { this._harga = _harga; }
    public void set_deskripsi(String _deskripsi) {
        this._deskripsi = _deskripsi;
    }
}