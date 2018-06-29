package com.example.user.cinema;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;

public class CinemaActivity extends AppCompatActivity {

    private TextView cinemaName;
    private TextView cinemaUrl;
    private TextView cinemaVote;
    private TextView cinemaAddress;
    private TextView cinemaPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema);
        Intent intent=getIntent();

        cinemaName=(TextView)findViewById(R.id.cinemaName);
        cinemaVote=(TextView)findViewById(R.id.cinemaVote);
        cinemaUrl=(TextView)findViewById(R.id.url);
        cinemaPhone=(TextView)findViewById(R.id.cinemaPhone);
        cinemaAddress=(TextView)findViewById(R.id.cinemaAddress);

        cinemaName.setText(String.valueOf(intent.getStringExtra(MainActivity.CINEMA_NAME)));
        cinemaVote.setText(String.valueOf(intent.getStringExtra(MainActivity.CINEMA_VOTE)));
        cinemaUrl.setText(String.valueOf(intent.getStringExtra(MainActivity.CINEMA_URL)));
        cinemaPhone.setText(String.valueOf(intent.getStringExtra(MainActivity.CINEMA_PHONE)));
        cinemaAddress.setText(String.valueOf(intent.getStringExtra(MainActivity.CINEMA_ADDRESS)));
    }
}
