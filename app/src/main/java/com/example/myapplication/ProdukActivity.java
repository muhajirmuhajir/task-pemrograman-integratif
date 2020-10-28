package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapters.ProdukAdapter;
import com.example.myapplication.models.Produk;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ProdukActivity extends AppCompatActivity {
    private RecyclerView rvProduk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produk);

        getSupportActionBar().setTitle(this.getIntent().getStringExtra("toko"));

        rvProduk = findViewById(R.id.rv_produk);
        rvProduk.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        String produk = this.getIntent().getStringExtra("produk");
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Produk>>() {
        }.getType();
        ArrayList<Produk> produks = gson.fromJson(produk, type);

        ProdukAdapter adapter = new ProdukAdapter();
        Log.d("TAG_PRODUK", "onCreate: " + produks.get(0).getStok());
        adapter.setListProduk(produks);
        rvProduk.setAdapter(adapter);
    }
}