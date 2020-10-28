package com.example.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.Produk;

import java.util.ArrayList;

public class ProdukAdapter extends RecyclerView.Adapter<ProdukAdapter.ViewHolder> {
    private ArrayList<Produk> listProduk;

    public void setListProduk(ArrayList<Produk> listProduk) {
        this.listProduk = listProduk;
    }

    @NonNull
    @Override
    public ProdukAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.produk_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdukAdapter.ViewHolder holder, int position) {
        holder.produk.setText("Nama Produk : " + listProduk.get(position).getNama());
        holder.stok.setText("Stok : " + listProduk.get(position).getStok());
        holder.harga.setText("Harga : " + listProduk.get(position).getHarga());
    }

    @Override
    public int getItemCount() {
        return listProduk.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView produk;
        TextView stok;
        TextView harga;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            produk = itemView.findViewById(R.id.produk);
            harga = itemView.findViewById(R.id.harga);
            stok = itemView.findViewById(R.id.stok);
        }
    }
}
