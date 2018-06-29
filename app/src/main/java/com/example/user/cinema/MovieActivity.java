package com.example.user.cinema;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;

public class MovieActivity extends AppCompatActivity {

    private TextView textName;
    private TextView textCountVote;
    private TextView textAge;
    private TextView textVote;
    private TextView textCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);
        Intent intent=getIntent();

        textName=(TextView)findViewById(R.id.name);
        textVote=(TextView)findViewById(R.id.vote);
        textCountVote=(TextView)findViewById(R.id.countvote);
        textAge=(TextView)findViewById(R.id.age);
        textCountry=(TextView)findViewById(R.id.country);

        textName.setText(String.valueOf(intent.getStringExtra(MainActivity.MOVIE_NAME)));
        textVote.setText(String.valueOf(intent.getStringExtra(MainActivity.MOVIE_VOTE)));
        textCountVote.setText(String.valueOf(intent.getStringExtra(MainActivity.MOVIE_COUNT)));
        textAge.setText(String.valueOf(intent.getStringExtra(MainActivity.MOVIE_AGE)));
        textCountry.setText(String.valueOf(intent.getStringExtra(MainActivity.MOVIE_COUNTRY)));

    }

}
