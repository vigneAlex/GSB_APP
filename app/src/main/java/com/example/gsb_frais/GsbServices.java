package com.example.gsb_frais;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GsbServices {
    @GET("visiteurs")
    Call<Visiteurs> getAllVisiteurs(@Header("Authorization") String authorization);

    @GET("visiteurs/{id}")
    Call<Visiteurs> getVisiteurs(@Path("id") int id);

    @GET("praticiens/{id}")
    Call<Praticien> getPraticien(@Path("id") int id);

    @POST("login_check")
    Call<Token> getToken(@Body Visiteur visiteur);

    @POST("visiteurs")
    Call<Visiteur> createVisiteur(@Body Visiteur visiteur);
}
