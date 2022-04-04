package com.example.gsb_frais;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class GsbRvVisitesAdapter extends RecyclerView.Adapter<GsbRvVisitesAdapter.ViewHolder>  {
    private ArrayList<Visites> dateModelList;


    public GsbRvVisitesAdapter(ArrayList<Visites> dateModelList) {
        this.dateModelList = dateModelList;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_visites, parent, false);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.dateTv.setText(String.valueOf(dateModelList.get(position).getDate()));
        holder.motifTv.setText(String.valueOf(dateModelList.get(position).getMotif()));
        holder.commentaireTv.setText(String.valueOf(dateModelList.get(position).getCommentaire()));
    }

    @Override
    public int getItemCount() {

        return dateModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView dateTv, motifTv, commentaireTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dateTv = itemView.findViewById(R.id.date);
            motifTv = itemView.findViewById(R.id.motif);
            commentaireTv = itemView.findViewById(R.id.commentaire);
        }
    }
}
