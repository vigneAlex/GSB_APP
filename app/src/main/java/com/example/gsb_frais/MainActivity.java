package com.example.gsb_frais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.gsb_frais.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String unmail = binding.edMail.getText().toString();
                String unMdp = binding.edMdp.getText().toString();

                GsbServices service = RetrofitClientInstance.getRetrofitInstance().create(GsbServices.class);
                Call<Token> call = service.getToken(new Visiteur(unmail, unMdp));
                call.enqueue(new Callback<Token>() {
                    @Override
                    public void onResponse(Call<Token> call, Response<Token> response) {
                        if(response.code() == 200) {
                            Token token = response.body();
                            Log.v("token", token.getToken());

                            Intent connexion = new Intent(MainActivity.this, HomeActivity.class);
                            connexion.putExtra("token", token.getToken());
                            connexion.putExtra("mail", unmail);
                            startActivity(connexion);
                        }
                        else if(response.code() == 401) {
                            Toast.makeText(MainActivity.this, "Nom d'utilisateur ou mot de passe invalide", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<Token> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        binding.btnCree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cree = new Intent(MainActivity.this, CreateVisiteurActivity.class);
                startActivity(cree);
            }
        });
    }

}