package com.example.user.cinema;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCinema {

    @GET("kinoteatrs_load")
    Call<ModelCinema> getCinemas();
}
