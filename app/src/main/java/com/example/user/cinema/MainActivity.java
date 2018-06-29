package com.example.user.cinema;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import java.util.ArrayList;
import retrofit2.*;

public class MainActivity extends AppCompatActivity  {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private BottomNavigationView bottomNavigationView;
    private TextView textView;

    ArrayList<Unmain> list;
    ArrayList<MovieResult> movieList;
    ListView listView;

    public static final String MOVIE_NAME="movie_name";
    public static final String MOVIE_VOTE="movie_vote";
    public static final String MOVIE_COUNTRY="movie_country";
    public static final String MOVIE_COUNT="movie_countvote";
    public static final String MOVIE_AGE="movie_age";

    public static final String CINEMA_NAME="cinema_name";
    public static final String CINEMA_VOTE="cinema_vote";
    public static final String CINEMA_ADDRESS="cinema_address";
    public static final String CINEMA_PHONE="cinema_phone";
    public static final String CINEMA_URL="cinema_url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView=(ListView) findViewById(R.id.list_view);
        Cinemas();
    }

    public void initUi(){
        textView=(TextView)findViewById(R.id.text);
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_activity_main);
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.bottom_cinema:
                        Cinemas();
                        return true;

                    case R.id.bottom_films:
                        Movies();;
                        return true;

                }
                return false;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
        }
        return super.onOptionsItemSelected(item);
    }

    public void Cinemas(){
        ApiCinema apiInterface=ApiClient.getClient().create(ApiCinema.class);
        Call<ModelCinema> call=apiInterface.getCinemas();

        call.enqueue(new Callback<ModelCinema>() {
            @Override
            public void onResponse(Call<ModelCinema> call, Response<ModelCinema> response) {
                list=response.body().getResult().getUnmain();
                CinemaAdapter cinemaAdapter=new CinemaAdapter(MainActivity.this,list);
                listView.setAdapter(cinemaAdapter);
            }

            @Override
            public void onFailure(Call<ModelCinema> call, Throwable t) {textView.setText("Lol");
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,CinemaActivity.class);
                Unmain cinema = list.get(position);
                intent.putExtra(CINEMA_NAME,cinema.getName());
                intent.putExtra(CINEMA_ADDRESS,cinema.getAddress());
                intent.putExtra(CINEMA_PHONE,cinema.getPhone());
                intent.putExtra(CINEMA_URL,cinema.getUrl());
                intent.putExtra(CINEMA_VOTE,cinema.getVote());
                startActivity(intent);
            }
        });

    }
    public void Movies(){
        ApiMovie apiMovie=ApiClient.getClient().create(ApiMovie.class);
        Call<ModelMovie> callMovie=apiMovie.getMovies();

        callMovie.enqueue(new Callback<ModelMovie>() {
            @Override
            public void onResponse(Call<ModelMovie> call, Response<ModelMovie> response) {
                movieList=response.body().getResult();
                MovieAdapter movieAdapter=new MovieAdapter(MainActivity.this,movieList);
                listView.setAdapter(movieAdapter);
            }

            @Override
            public void onFailure(Call<ModelMovie> call, Throwable t) {textView.setText("Lol");
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,MovieActivity.class);
                MovieResult movie = movieList.get(position);
                intent.putExtra(MOVIE_NAME,movie.getName());
                intent.putExtra(MOVIE_COUNTRY,movie.getCountries());
                intent.putExtra(MOVIE_COUNT,movie.getCountVote());
                intent.putExtra(MOVIE_AGE,movie.getAgeLimit());
                intent.putExtra(MOVIE_VOTE,movie.getVote());
                startActivity(intent);
            }
        });
    }
}

