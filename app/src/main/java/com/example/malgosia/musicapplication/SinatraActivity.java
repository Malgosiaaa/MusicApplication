package com.example.malgosia.musicapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class SinatraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        // Creates an Array List of Album objects
        final ArrayList<Album> sinatra = new ArrayList<Album>();
        sinatra.add(new Album(getString(R.string.frank_sinatra), getString(R.string.sinatra_s1), getString(R.string.sinatra_d1), R.drawable.sinatra));
        sinatra.add(new Album(getString(R.string.frank_sinatra), getString(R.string.sinatra_s2), getString(R.string.sinatra_d2), R.drawable.sinatra));
        sinatra.add(new Album(getString(R.string.frank_sinatra), getString(R.string.sinatra_s3), getString(R.string.sinatra_d3), R.drawable.sinatra));
        sinatra.add(new Album(getString(R.string.frank_sinatra), getString(R.string.sinatra_s4), getString(R.string.sinatra_d4), R.drawable.sinatra));
        sinatra.add(new Album(getString(R.string.frank_sinatra), getString(R.string.sinatra_s5), getString(R.string.sinatra_d5), R.drawable.sinatra));
        sinatra.add(new Album(getString(R.string.frank_sinatra), getString(R.string.sinatra_s6), getString(R.string.sinatra_d6), R.drawable.sinatra));
        sinatra.add(new Album(getString(R.string.frank_sinatra), getString(R.string.sinatra_s7), getString(R.string.sinatra_d7), R.drawable.sinatra));
        sinatra.add(new Album(getString(R.string.frank_sinatra), getString(R.string.sinatra_s8), getString(R.string.sinatra_d8), R.drawable.sinatra));
        sinatra.add(new Album(getString(R.string.frank_sinatra), getString(R.string.sinatra_s9), getString(R.string.sinatra_d9), R.drawable.sinatra));
        sinatra.add(new Album(getString(R.string.frank_sinatra), getString(R.string.sinatra_s10), getString(R.string.sinatra_d10), R.drawable.sinatra));
        sinatra.add(new Album(getString(R.string.frank_sinatra), getString(R.string.sinatra_s11), getString(R.string.sinatra_d11), R.drawable.sinatra));
        sinatra.add(new Album(getString(R.string.frank_sinatra), getString(R.string.sinatra_s12), getString(R.string.sinatra_d12), R.drawable.sinatra));
        sinatra.add(new Album(getString(R.string.frank_sinatra), getString(R.string.sinatra_s13), getString(R.string.sinatra_d13), R.drawable.sinatra));
        sinatra.add(new Album(getString(R.string.frank_sinatra), getString(R.string.sinatra_s14), getString(R.string.sinatra_d14), R.drawable.sinatra));
        sinatra.add(new Album(getString(R.string.frank_sinatra), getString(R.string.sinatra_s15), getString(R.string.sinatra_d15), R.drawable.sinatra));
        sinatra.add(new Album(getString(R.string.frank_sinatra), getString(R.string.sinatra_s16), getString(R.string.sinatra_d16), R.drawable.sinatra));

        // Creates a new SinatraAdapter which data source is the above ArrayList
        SinatraAdapter sinatraAdaptaer = new SinatraAdapter(this, sinatra);

        // Finds the ListView and attache adapter to it
        ListView songsList = (ListView) findViewById(R.id.list_view);
        songsList.setAdapter(sinatraAdaptaer);

        // Sets OnItemClickListener to make every list_item_view clickable
        songsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Creates Intent to switch to NowPlayingActivity
                Intent playSong = new Intent(SinatraActivity.this, NowPlayingActivity.class);
                Album currentSong = sinatra.get(position);

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
