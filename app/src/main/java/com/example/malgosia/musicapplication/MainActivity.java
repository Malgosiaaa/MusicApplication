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

        // Finds the TextView with the Kind of Blue Album
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
    }
}
