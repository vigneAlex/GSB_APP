package com.example.gsb_frais;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Praticien implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("pra_nom")
    private String pra_nom;
    @SerializedName("pra_prenom")
    private String pra_prenom;
    @SerializedName("pra_tel")
    private String pra_tel;
    @SerializedName("pra_mail")
    private String pra_mail;
    @SerializedName("pra_rue")
    private String pra_rue;
    @SerializedName("pra_codePostal")
    private String pra_code_postal;
    @SerializedName("pra_ville")
    private String pra_ville;
    @SerializedName("pra_coef_notoriete")
    private int pra_coef_notoriete;
    @SerializedName("pra_visites")
    private List<String> visites;
    private ArrayList<Visites> lesVisites;

    public Praticien(int id, String pra_nom, String pra_prenom, String pra_tel, String pra_mail, String pra_rue, String pra_code_postal, String pra_ville, int pra_coef_notoriete) {
        this.id = id;
        this.pra_nom = pra_nom;
        this.pra_prenom = pra_prenom;
        this.pra_tel = pra_tel;
        this.pra_mail = pra_mail;
        this.pra_rue = pra_rue;
        this.pra_code_postal = pra_code_postal;
        this.pra_ville = pra_ville;
        this.pra_coef_notoriete = pra_coef_notoriete;
    }

    public void add(Visites uneVisite){
        if(lesVisites == null){
            lesVisites = new ArrayList<>();
        }
        lesVisites.add(uneVisite);
    }

    public int getId() {
        return id;
    }

    public String getPra_nom() {
        return pra_nom;
    }

    public String getPra_prenom() {
        return pra_prenom;
    }

    public String getPra_tel() {
        return pra_tel;
    }

    public String getPra_mail() {
        return pra_mail;
    }

    public String getPra_rue() {
        return pra_rue;
    }

    public String getPra_code_postal() {
        return pra_code_postal;
    }

    public String getPra_ville() {
        return pra_ville;
    }

    public int getPra_coef_notoriete() {
        return pra_coef_notoriete;
    }

    public List<String> getVisites() {
        return visites;
    }

    public ArrayList<Visites> getLesVisites() {
        return lesVisites;
    }
}
