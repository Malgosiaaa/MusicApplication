package com.example.malgosia.musicapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class RichardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        // Creates an Array List of Album objects
        final ArrayList<Album> richard = new ArrayList<Album>();
        richard.add(new Album(getString(R.string.little_richard), getString(R.string.richard_s1), getString(R.string.richard_d1), R.drawable.little_richard));
        richard.add(new Album(getString(R.string.little_richard), getString(R.string.richard_s2), getString(R.string.richard_d2), R.drawable.little_richard));
        richard.add(new Album(getString(R.string.little_richard), getString(R.string.richard_s3), getString(R.string.richard_d3), R.drawable.little_richard));
        richard.add(new Album(getString(R.string.little_richard), getString(R.string.richard_s4), getString(R.string.richard_d4), R.drawable.little_richard));
        richard.add(new Album(getString(R.string.little_richard), getString(R.string.richard_s5), getString(R.string.richard_d5), R.drawable.little_richard));
        richard.add(new Album(getString(R.string.little_richard), getString(R.string.richard_s6), getString(R.string.richard_d6), R.drawable.little_richard));
        richard.add(new Album(getString(R.string.little_richard), getString(R.string.richard_s7), getString(R.string.richard_d7), R.drawable.little_richard));
        richard.add(new Album(getString(R.string.little_richard), getString(R.string.richard_s8), getString(R.string.richard_d8), R.drawable.little_richard));
        richard.add(new Album(getString(R.string.little_richard), getString(R.string.richard_s9), getString(R.string.richard_d9), R.drawable.little_richard));
        richard.add(new Album(getString(R.string.little_richard), getString(R.string.richard_s10), getString(R.string.richard_d10), R.drawable.little_richard));
        richard.add(new Album(getString(R.string.little_richard), getString(R.string.richard_s11), getString(R.string.richard_d11), R.drawable.little_richard));
        richard.add(new Album(getString(R.string.little_richard), getString(R.string.richard_s12), getString(R.string.richard_d12), R.drawable.little_richard));

        // Creates a new RichardAdapter which data source is the above ArrayList
        RichardAdapter richardAdaptaer = new RichardAdapter(this, richard);

        // Finds the ListView and attache adapter to it
        ListView songsList = (ListView) findViewById(R.id.list_view);
        songsList.setAdapter(richardAdaptaer);

        // Sets OnItemClickListener to make every list_item_view clickable
        songsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Creates Intent to switch to NowPlayingActivity
                Intent playSong = new Intent(RichardActivity.this, NowPlayingActivity.class);
                Album currentSong = richard.get(position);

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
