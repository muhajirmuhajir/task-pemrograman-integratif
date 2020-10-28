package com.example.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.Toko;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ArrayList<Toko> listToko;
    private OnItemClickCallback onItemClickCallback;

    public void setListToko(ArrayList<Toko> listToko) {
        this.listToko = listToko;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.toko_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, final int position) {
        holder.nama.setText("NAMA TOKO : " + listToko.get(position).getNama());
        holder.owner.setText("OWNER : "+ listToko.get(position).getOwner());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.OnItemClicked(listToko.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listToko.size() ;
    }

    public  interface OnItemClickCallback{
        void OnItemClicked(Toko toko);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nama;
        TextView owner;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nama = itemView.findViewById(R.id.nama);
            owner = itemView.findViewById(R.id.owner);

        }
    }
}
