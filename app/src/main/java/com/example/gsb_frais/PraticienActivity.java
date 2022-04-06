package com.example.gsb_frais;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.example.gsb_frais.databinding.ActivityPraticienBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PraticienActivity extends AppCompatActivity {

    ActivityPraticienBinding binding;
    private Praticien lePraticien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPraticienBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        String token = getIntent().getExtras().getString("token");
        Praticien lePraticien = (Praticien) getIntent().getSerializableExtra("praticien");

        binding.praNom.setText(lePraticien.getPra_nom());
        binding.praPrenom.setText(lePraticien.getPra_prenom());
        binding.praTel.setText(lePraticien.getPra_tel());
        binding.praMail.setText(lePraticien.getPra_mail());
        binding.praRue.setText(lePraticien.getPra_rue());
        binding.praCp.setText(lePraticien.getPra_code_postal());
        binding.praVille.setText(lePraticien.getPra_ville());
        binding.praCoef.setText(String.valueOf(lePraticien.getPra_coef_notoriete()));

        for (String visite : lePraticien.getVisites()){
            visite = visite.substring(13);
            int uneVisite = Integer.parseInt(visite);
            GsbServices service = RetrofitClientInstance.getRetrofitInstance().create(GsbServices.class);
            Call<Visites> call = service.getVisites("Bearer " + token ,uneVisite);
            call.enqueue(new Callback<Visites>() {
                @Override
                public void onResponse(Call<Visites> call, Response<Visites> response) {
                    Visites visites = response.body();
                    lePraticien.add(visites);

                    binding.rvVisites.setHasFixedSize(true);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                    binding.rvVisites.setLayoutManager(layoutManager);
                    binding.rvVisites.setFocusable(false);
                    GsbRvVisitesAdapter myAdapterWeather = new GsbRvVisitesAdapter(lePraticien.getLesVisites());
                    binding.rvVisites.setAdapter(myAdapterWeather);

//                    for (Visites visite : lePraticien.getLesVisites()){
//                        String motif = visite.getMotif().substring(12);
//                        int leMotif = Integer.parseInt(motif);
//                        GsbServices service = RetrofitClientInstance.getRetrofitInstance().create(GsbServices.class);
//                        Call<Motif> call1 = service.getMotifs("Bearer " + token ,leMotif);
//                        call1.enqueue(new Callback<Motif>() {
//                            @Override
//                            public void onResponse(Call<Motif> call1, Response<Motif> response) {
//                                Motif motif = response.body();
//                                visite.setLeMotif(motif);
//
//                                if (lePraticien != null){
//                                    if (lePraticien.getLesVisites().size() == lePraticien.getVisites().size()){
//                                        binding.rvVisites.setHasFixedSize(true);
//                                        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
//                                        binding.rvVisites.setLayoutManager(layoutManager);
//                                        binding.rvVisites.setFocusable(false);
//                                        GsbRvVisitesAdapter myAdapterWeather = new GsbRvVisitesAdapter(lePraticien.getLesVisites());
//                                        binding.rvVisites.setAdapter(myAdapterWeather);
//                                    }
//                                }
//                            }
//
//                            @Override
//                            public void onFailure(Call<Motif> call1, Throwable t) {
//
//                            }
//                        });
//                    }





                }

                @Override
                public void onFailure(Call<Visites> call, Throwable t) {

                }
            });
        }
        binding.btnIti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://maps.google.com/maps?daddr="+ lePraticien.getPra_rue() + " "+ lePraticien.getPra_code_postal()+ " " + lePraticien.getPra_ville();
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,  Uri.parse(url));
                startActivity(intent);
            }
        });

    }
}