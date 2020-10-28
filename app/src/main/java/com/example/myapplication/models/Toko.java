package com.example.myapplication.models;

import java.util.ArrayList;

public class Toko {
    private String nama;
    private String owner;
    private ArrayList<Produk> produk;

    public  Toko(){

    }

    public Toko(String nama, String owner, ArrayList<Produk> produk) {
        this.nama = nama;
        this.owner = owner;
        this.produk = produk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public ArrayList<Produk> getProduk() {
        return produk;
    }

    public void setProduk(ArrayList<Produk> produk) {
        this.produk = produk;
    }
}
