package com.example.gsb_frais;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Visiteur implements Serializable {
    @SerializedName("id")
    private Integer id;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("visNom")
    private String nom;
    @SerializedName("visPrenom")
    private String prenom;
    @SerializedName("visTel")
    private String tel;
    @SerializedName("visDateEmbauche")
    private String dateEmbauche;

    private String token;

    @SerializedName("vis_Praticiens")
    private List<String> praticiens;

    public Visiteur(String nom, String prenom, String email, String password, String tel ){
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.tel = tel;
    }

    public Visiteur(String username, String password) {
        this.password = password;
        this.username = username;
    }

    @SerializedName("username")
    private String username;

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTel() {
        return tel;
    }

    public String getDateEmbauche() {
        return dateEmbauche;
    }

    public String getToken() {
        return token;
    }

    public List<String> getPraticien() {
        return praticiens;
    }
}
