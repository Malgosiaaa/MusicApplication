package com.example.malgosia.musicapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class MilesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        // Creates an Array List of Album objects
        final ArrayList<Album> miles = new ArrayList<Album>();
        miles.add(new Album(getString(R.string.miles_davis), getString(R.string.miles_s1), getString(R.string.miles_d1), R.drawable.miles));
        miles.add(new Album(getString(R.string.miles_davis), getString(R.string.miles_s2), getString(R.string.miles_d2), R.drawable.miles));
        miles.add(new Album(getString(R.string.miles_davis), getString(R.string.miles_s3), getString(R.string.miles_d3), R.drawable.miles));
        miles.add(new Album(getString(R.string.miles_davis), getString(R.string.miles_s4), getString(R.string.miles_d4), R.drawable.miles));
        miles.add(new Album(getString(R.string.miles_davis), getString(R.string.miles_s5), getString(R.string.miles_d5), R.drawable.miles));

        // Creates a new MilesAdapter which data source is the above ArrayList
        MilesAdapter milesAdaptaer = new MilesAdapter(this, miles);

        // Finds the ListView and attache adapter to it
        ListView songsList = (ListView) findViewById(R.id.list_view);
        songsList.setAdapter(milesAdaptaer);

        // Sets OnItemClickListener to make every list_item_view clickable
        songsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Creates Intent to switch to NowPlayingActivity
                Intent playSong = new Intent(MilesActivity.this, NowPlayingActivity.class);
                Album currentSong = miles.get(position);

                // Use extras to pass the data about the clicked song to NowPlaying Activity
                Bundle songData = new Bundle();
                songData.putString("EXTRA_SONG_TITLE", currentSong.getSongTitle());
                songData.putString("EXTRA_ARTIST_NAME", currentSong.getArtistName());
                songData.putString("EXTRA_SONG_DURATION", currentSong.getDuration());
                songData.putInt("EXTRA_ALBUM_COVER_IMAGE", currentSong.getImageCover());
                playSong.putExtras(songData);
                startActivity(playSong);
            }
        });

        // Finds the ImageView with the BackButton
        ImageButton backButton = findViewById(R.id.btn_list_back);
        // Sets OnClickListener to it and back to the MainActivity
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}
