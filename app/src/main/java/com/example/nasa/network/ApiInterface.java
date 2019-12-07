package com.example.nasa.network;

import com.example.nasa.models.Nasa;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiInterface {

    @GET
    Call<Nasa> NASA_CALL(@Url String url);

}
