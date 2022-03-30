package com.example.gsb_frais;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Toast;

import com.example.gsb_frais.databinding.ActivityHomeBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    private Visiteur leVisiteur;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        String token = getIntent().getExtras().getString("token");
        String mail = getIntent().getExtras().getString("mail");

        GsbServices service = RetrofitClientInstance.getRetrofitInstance().create(GsbServices.class);
        Call<Visiteurs> call = service.getAllVisiteurs("Bearer " + token);
        call.enqueue(new Callback<Visiteurs>() {
            @Override
            public void onResponse(Call<Visiteurs> call, Response<Visiteurs> response) {
                Visiteurs visiteurs = response.body();
                for (Visiteur visiteur : visiteurs.getVisiteurs()){
                    if (visiteur.getEmail().equals(mail)) {
                        leVisiteur = visiteur;
                        binding.tvNom.setText(visiteur.getNom());
                        binding.tvPrenom.setText(visiteur.getPrenom());

                        for (String praticien : visiteur.getPraticien()){
                            praticien = praticien.substring(16);
                            int unPraticien = Integer.parseInt(praticien);
                            GsbServices service = RetrofitClientInstance.getRetrofitInstance().create(GsbServices.class);
                            Call<Praticien> call1 = service.getPraticien("Bearer " + token ,unPraticien);
                            call1.enqueue(new Callback<Praticien>() {
                                @Override
                                public void onResponse(Call<Praticien> call, Response<Praticien> response) {
                                    Praticien praticien = response.body();
                                    leVisiteur.add(praticien);

                                }

                                @Override
                                public void onFailure(Call<Praticien> call, Throwable t) {

                                }
                            });
                        }
                    }
                    if (leVisiteur != null){
                        if (leVisiteur.getLesPraticiens() != null){
                            binding.rvPraticiens.setHasFixedSize(true);
                            LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
                            binding.rvPraticiens.setLayoutManager(layoutManager);
                            binding.rvPraticiens.setFocusable(false);
                            GsbRvAdapter myAdapterWeather = new GsbRvAdapter(leVisiteur.getLesPraticiens());
                            binding.rvPraticiens.setAdapter(myAdapterWeather);
                        }
                        else {
                            Toast.makeText(HomeActivity.this, "pas bon", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
            @Override
            public void onFailure(Call<Visiteurs> call, Throwable t) {
                Toast.makeText(HomeActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}