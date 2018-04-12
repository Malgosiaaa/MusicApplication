package com.example.malgosia.musicapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class FrankActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        // Creates an Array List of Album objects
        final ArrayList<Album> frank = new ArrayList<Album>();
        frank.add(new Album(getString(R.string.frank_sinatra), getString(R.string.frank_s1), getString(R.string.frank_d1), R.drawable.frank));
        frank.add(new Album(getString(R.string.frank_sinatra), getString(R.string.frank_s2), getString(R.string.frank_d2), R.drawable.frank));
        frank.add(new Album(getString(R.string.frank_sinatra), getString(R.string.frank_s3), getString(R.string.frank_d3), R.drawable.frank));
        frank.add(new Album(getString(R.string.frank_sinatra), getString(R.string.frank_s4), getString(R.string.frank_d4), R.drawable.frank));
        frank.add(new Album(getString(R.string.frank_sinatra), getString(R.string.frank_s5), getString(R.string.frank_d5), R.drawable.frank));
        frank.add(new Album(getString(R.string.frank_sinatra), getString(R.string.frank_s6), getString(R.string.frank_d6), R.drawable.frank));
        frank.add(new Album(getString(R.string.frank_sinatra), getString(R.string.frank_s7), getString(R.string.frank_d7), R.drawable.frank));
        frank.add(new Album(getString(R.string.frank_sinatra), getString(R.string.frank_s8), getString(R.string.frank_d8), R.drawable.frank));
        frank.add(new Album(getString(R.string.frank_sinatra), getString(R.string.frank_s9), getString(R.string.frank_d9), R.drawable.frank));
        frank.add(new Album(getString(R.string.frank_sinatra), getString(R.string.frank_s10), getString(R.string.frank_d10), R.drawable.frank));
        frank.add(new Album(getString(R.string.frank_sinatra), getString(R.string.frank_s11), getString(R.string.frank_d11), R.drawable.frank));
        frank.add(new Album(getString(R.string.frank_sinatra), getString(R.string.frank_s12), getString(R.string.frank_d12), R.drawable.frank));
        frank.add(new Album(getString(R.string.frank_sinatra), getString(R.string.frank_s13), getString(R.string.frank_d13), R.drawable.frank));
        frank.add(new Album(getString(R.string.frank_sinatra), getString(R.string.frank_s14), getString(R.string.frank_d14), R.drawable.frank));
        frank.add(new Album(getString(R.string.frank_sinatra), getString(R.string.frank_s15), getString(R.string.frank_d15), R.drawable.frank));

        // Creates a new FrankAdapter which data source is the above ArrayList
        FrankAdapter frankAdaptaer = new FrankAdapter(this, frank);

        // Finds the ListView and attache adapter to it
        ListView songsList = (ListView) findViewById(R.id.list_view);
        songsList.setAdapter(frankAdaptaer);

        // Sets OnItemClickListener to make every list_item_view clickable
        songsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Creates Intent to switch to NowPlayingActivity
                Intent playSong = new Intent(FrankActivity.this, NowPlayingActivity.class);
                Album currentSong = frank.get(position);

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
