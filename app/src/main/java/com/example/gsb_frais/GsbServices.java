package com.example.gsb_frais;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GsbServices {
    @GET("/api/visiteurs")
    Call<Visiteurs> getAllVisiteurs(@Header("Authorization") String authorization);

    @GET("/api/visiteurs/{id}")
    Call<Visiteurs> getVisiteurs(@Path("id") int id);

    @GET("/api/praticiens/{id}")
    Call<Praticien> getPraticien(@Header("Authorization") String authorization, @Path("id") int id);

    @GET("/api/visites/{id}")
    Call<Visites> getVisites(@Header("Authorization") String authorization, @Path("id") int id);

    @POST("/api/login_check")
    Call<Token> getToken(@Body Visiteur visiteur);

    @POST("/api/visiteurs")
    Call<Visiteur> createVisiteur(@Body Visiteur visiteur);
}
