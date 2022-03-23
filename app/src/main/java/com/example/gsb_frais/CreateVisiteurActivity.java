package com.example.gsb_frais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.gsb_frais.databinding.ActivityCreateVisiteurBinding;
import com.example.gsb_frais.databinding.ActivityCreateVisiteurBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateVisiteurActivity extends AppCompatActivity {

    ActivityCreateVisiteurBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateVisiteurBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_create_visiteur);

        binding.btnEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String unNom = binding.edNom.getText().toString();
                String unPrenom = binding.edPrenom.getText().toString();
                String unmail = binding.edMail.getText().toString();
                String unMdp = binding.edMdp.getText().toString();
                String unTel = binding.edTel.getText().toString();

                GsbServices service = RetrofitClientInstance.getRetrofitInstance().create(GsbServices.class);
                Visiteur visiteur = new Visiteur(unNom, unPrenom, unmail, unMdp, unTel);
                Call<Visiteur> call = service.createVisiteur(visiteur);
                call.enqueue(new Callback<Visiteur>() {
                    @Override
                    public void onResponse(Call<Visiteur> call, Response<Visiteur> response) {

                        Visiteur visiteur = response.body();
                        Toast.makeText(CreateVisiteurActivity.this, "inscription reussi", Toast.LENGTH_SHORT).show();
                        Intent cree = new Intent(CreateVisiteurActivity.this, MainActivity.class);
                        startActivity(cree);
                    }

                    @Override
                    public void onFailure(Call<Visiteur> call, Throwable t) {
                        Toast.makeText(CreateVisiteurActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
