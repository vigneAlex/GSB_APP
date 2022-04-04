package com.example.gsb_frais;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class Visites implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("vstDateVisite")
    private Date date;
    @SerializedName("vstCommentaire")
    private String commentaire;
    @SerializedName("vstPraticiens")
    private String praticiens;
    @SerializedName("vstMotif")
    private String motif;
    @SerializedName("vstVisiteur")
    private String visiteur;

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public String getPraticiens() {
        return praticiens;
    }

    public String getMotif() {
        return motif;
    }

    public String getVisiteur() {
        return visiteur;
    }
}
