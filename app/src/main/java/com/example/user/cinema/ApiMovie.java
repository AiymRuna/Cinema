package com.example.user.cinema;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiMovie {

    @GET("kinoafisha_load")
    Call<ModelMovie> getMovies();
}
