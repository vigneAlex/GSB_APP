package com.example.gsb_frais;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

public class GsbRvAdapter extends RecyclerView.Adapter<GsbRvAdapter.ViewHolder>  {
    private List<Praticien> dateModelList;


    public GsbRvAdapter(List<Praticien> dateModelList) {
        this.dateModelList = dateModelList;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {

        return dateModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
