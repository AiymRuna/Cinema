package com.example.user.cinema;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static ApiCinema apiCinema;

    public static String BASE_URL="http://kinoafisha.ua/ajax/";

    private static Retrofit retrofit;

    public static Retrofit getClient(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}
