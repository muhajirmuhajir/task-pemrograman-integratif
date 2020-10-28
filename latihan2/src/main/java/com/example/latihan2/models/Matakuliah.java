package com.example.latihan2.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Matakuliah implements Parcelable {
    private String kode;
    private String  nama;
    private int sks;

    public Matakuliah() {
    }

    public Matakuliah(String kode, String nama, int sks) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
    }

    protected Matakuliah(Parcel in) {
        kode = in.readString();
        nama = in.readString();
        sks = in.readInt();
    }

    public static final Creator<Matakuliah> CREATOR = new Creator<Matakuliah>() {
        @Override
        public Matakuliah createFromParcel(Parcel in) {
            return new Matakuliah(in);
        }

        @Override
        public Matakuliah[] newArray(int size) {
            return new Matakuliah[size];
        }
    };

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(kode);
        parcel.writeString(nama);
        parcel.writeInt(sks);
    }
}
