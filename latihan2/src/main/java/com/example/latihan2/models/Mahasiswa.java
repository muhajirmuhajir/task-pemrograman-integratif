package com.example.latihan2.models;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Mahasiswa implements Parcelable {
    private String nama;
    private String nim;
    private int angkatan;

    @SerializedName("mata_kuliah")
    private ArrayList<Matakuliah> matakuliah;

    public Mahasiswa() {
    }

    public Mahasiswa(String nama, String nim, int angkatan, ArrayList<Matakuliah> matakuliah) {
        this.nama = nama;
        this.nim = nim;
        this.angkatan = angkatan;
        this.matakuliah = matakuliah;
    }

    protected Mahasiswa(Parcel in) {
        nama = in.readString();
        nim = in.readString();
        angkatan = in.readInt();
        matakuliah = in.createTypedArrayList(Matakuliah.CREATOR);
    }

    public static final Creator<Mahasiswa> CREATOR = new Creator<Mahasiswa>() {
        @Override
        public Mahasiswa createFromParcel(Parcel in) {
            return new Mahasiswa(in);
        }

        @Override
        public Mahasiswa[] newArray(int size) {
            return new Mahasiswa[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public int getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(int angkatan) {
        this.angkatan = angkatan;
    }

    public ArrayList<Matakuliah> getMatakuliah() {
        return matakuliah;
    }

    public void setMatakuliah(ArrayList<Matakuliah> matakuliah) {
        this.matakuliah = matakuliah;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeString(nim);
        parcel.writeInt(angkatan);
        parcel.writeTypedList(matakuliah);
    }
}
