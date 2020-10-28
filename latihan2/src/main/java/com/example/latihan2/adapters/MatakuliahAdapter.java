package com.example.latihan2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.latihan2.R;
import com.example.latihan2.models.Matakuliah;

import java.util.ArrayList;

public class MatakuliahAdapter extends RecyclerView.Adapter<MatakuliahAdapter.ViewHolder> {
    private ArrayList<Matakuliah> matakuliahArrayList =  new ArrayList<>();

    public void setMatakuliahArrayList(ArrayList<Matakuliah> matakuliahArrayList) {
        this.matakuliahArrayList = matakuliahArrayList;
    }

    @NonNull
    @Override
    public MatakuliahAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_matakuliah, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatakuliahAdapter.ViewHolder holder, int position) {
        holder.nama.setText(matakuliahArrayList.get(position).getNama());
        holder.sks.setText("SKS : "+ matakuliahArrayList.get(position).getSks());
        holder.kode.setText("KODE : "+ matakuliahArrayList.get(position).getKode());
    }

    @Override
    public int getItemCount() {
        return matakuliahArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView  nama;
        TextView sks;
        TextView kode;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.nama);
            sks = itemView.findViewById(R.id.sks);
            kode = itemView.findViewById(R.id.kode);
        }
    }
}
