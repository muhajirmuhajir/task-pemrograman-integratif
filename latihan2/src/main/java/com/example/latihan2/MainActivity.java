package com.example.latihan2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.latihan2.adapters.MahasiswaAdapter;
import com.example.latihan2.models.Mahasiswa;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMahasiswa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("List Mahasiswa");

        rvMahasiswa = findViewById(R.id.rv_mahasiswa);
        rvMahasiswa.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        ApiService.Api.getService().getAllMahasiswa().enqueue(new Callback<ArrayList<Mahasiswa>>() {
            @Override
            public void onResponse(Call<ArrayList<Mahasiswa>> call, Response<ArrayList<Mahasiswa>> response) {
                MahasiswaAdapter adapter = new MahasiswaAdapter();
                adapter.setMahasiswaArrayList(response.body());

                adapter.setOnItemClickCallback(new MahasiswaAdapter.OnItemClickCallback() {
                    @Override
                    public void OnItemClicked(Mahasiswa mahasiswa) {
                        Intent intent = new Intent(getApplicationContext(), MatakuliahActivity.class);
                        intent.putExtra("mahasiswa", mahasiswa);
                        startActivity(intent);
                    }
                });
                rvMahasiswa.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Mahasiswa>> call, Throwable t) {
                Log.d("API_RESPONSE", "onResponse: Failed");
            }
        });
    }
}
