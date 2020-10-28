package com.example.latihan2;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.latihan2.adapters.MatakuliahAdapter;
import com.example.latihan2.models.Mahasiswa;
import com.example.latihan2.models.Matakuliah;

import java.util.ArrayList;

public class MatakuliahActivity extends AppCompatActivity {
    private RecyclerView rvMatakuliah;
    @SuppressLint("RestrictedApi")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matakuliah);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        rvMatakuliah = findViewById(R.id.rv_matakuliah);
        rvMatakuliah.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        MatakuliahAdapter adapter = new MatakuliahAdapter();

        Mahasiswa mahasiswa = getIntent().getParcelableExtra("mahasiswa");
        getSupportActionBar().setTitle(mahasiswa.getNama());

        adapter.setMatakuliahArrayList(mahasiswa.getMatakuliah());
        rvMatakuliah.setAdapter(adapter);

    }
}