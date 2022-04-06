package com.example.gsb_frais;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Motif implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("mot_libelle")
    private String libelle;

    public Motif(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }
}
