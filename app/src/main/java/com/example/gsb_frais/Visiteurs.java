package com.example.gsb_frais;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Visiteurs implements Serializable {
    @SerializedName("hydra:member") //notation retrofit2
    private List<Visiteur> visiteurs;

    public Visiteurs(List<Visiteur> visiteurs) {
        this.visiteurs = visiteurs;
    }

    public List<Visiteur> getVisiteurs() {
        return visiteurs;
    }

}

