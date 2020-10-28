package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapters.Adapter;
import com.example.myapplication.models.Produk;
import com.example.myapplication.models.Toko;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvToko;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvToko = findViewById(R.id.rv_toko);

        getSupportActionBar().setTitle("List Toko");

        rvToko.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Adapter adapter = new Adapter();


        try {
            JSONArray tokoAry = new JSONArray(loadJSONFromAsset(getApplicationContext()));
            ArrayList<Toko> listToko = new ArrayList<>();

            for (int i = 0; i < tokoAry.length(); i++) {
                Toko toko = new Toko();
                JSONObject tokoObj = tokoAry.getJSONObject(i);

                toko.setNama(tokoObj.getString("nama"));
                toko.setOwner(tokoObj.getString("owner"));

                ArrayList<Produk> produks = new ArrayList<>();
                JSONArray produkAry = tokoObj.getJSONArray("produk");

                for (int j = 0; j < produkAry.length(); j++) {
                    Produk produk = new Produk();
                    JSONObject produkObj = produkAry.getJSONObject(j);
                    produk.setNama(produkObj.getString("nama"));
                    produk.setStok(produkObj.getInt("stok"));
                    produk.setHarga(produkObj.getInt("harga"));

                    produks.add(produk);
                }

                toko.setProduk(produks);
                listToko.add(toko);
            }

            adapter.setListToko(listToko);
            adapter.setOnItemClickCallback(new Adapter.OnItemClickCallback() {
                @Override
                public void OnItemClicked(Toko toko) {
                    Gson gson = new Gson();

                    Intent intent = new Intent(getApplicationContext(), ProdukActivity.class);
                    intent.putExtra("produk", gson.toJson(toko.getProduk()));
                    intent.putExtra("toko", toko.getNama());
                    startActivity(intent);
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }

        rvToko.setAdapter(adapter);

    }

    public String loadJSONFromAsset(Context context) {
        String json = null;

        try {
            InputStream is = context.getAssets().open("database.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }
}