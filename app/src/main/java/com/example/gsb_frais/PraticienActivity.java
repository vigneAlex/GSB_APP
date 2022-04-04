package com.example.gsb_frais;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

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
            visite = visite.substring(16);
            int uneVisite = Integer.parseInt(visite);
            GsbServices service = RetrofitClientInstance.getRetrofitInstance().create(GsbServices.class);
            Call<Visites> call1 = service.getVisites("Bearer " + token ,uneVisite);
            call1.enqueue(new Callback<Visites>() {
                @Override
                public void onResponse(Call<Visites> call, Response<Visites> response) {
                    Visites visites = response.body();
                    lePraticien.add(visites);
                    if (lePraticien != null){
                        if (lePraticien.getLesVisites().size() == lePraticien.getVisites().size()){
                            binding.rvVisites.setHasFixedSize(true);
                            LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                            binding.rvVisites.setLayoutManager(layoutManager);
                            binding.rvVisites.setFocusable(false);
                            GsbRvVisitesAdapter myAdapterWeather = new GsbRvVisitesAdapter(lePraticien.getLesVisites());
                            binding.rvVisites.setAdapter(myAdapterWeather);
                        }
                    }
                }

                @Override
                public void onFailure(Call<Visites> call, Throwable t) {

                }
            });
        }
    }
}