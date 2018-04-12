package com.example.malgosia.musicapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Finds the TextView with the "Kind of Blue" Album
        TextView kindOfBlue = (TextView) findViewById(R.id.kind_of_blue);
        // Sets OnClickListener to it
        kindOfBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creates intent to open MilesActivity
                Intent milesIntent = new Intent(MainActivity.this, MilesActivity.class);
                startActivity(milesIntent);
            }
        });

        // Finds the TextView with the "Here's Little Richard" Album
        TextView hereLittleRichard = (TextView) findViewById(R.id.here_little_richard);
        // Sets OnClickListener to it
        hereLittleRichard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creates intent to open RichardActivity
                Intent richardIntent = new Intent(MainActivity.this, RichardActivity.class);
                startActivity(richardIntent);
            }
        });

        // Finds the TextView with the "Songs for Swingin' Lovers" Album
        TextView swinginLovers = (TextView) findViewById(R.id.swingin_lovers);
        // Sets OnClickListener to it
        swinginLovers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creates intent to open FrankActivity
                Intent frankIntent = new Intent(MainActivity.this, FrankActivity.class);
                startActivity(frankIntent);
            }
        });

        // Finds the TextView with the "In the Wee Small Hours" Album
        TextView smallHours = (TextView) findViewById(R.id.wee_small_hours);
        // Sets OnClickListener to it
        smallHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creates intent to open SinatraActivity
                Intent sinatraIntent = new Intent(MainActivity.this, SinatraActivity.class);
                startActivity(sinatraIntent);
            }
        });

    }
}
