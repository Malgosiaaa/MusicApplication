package com.example.malgosia.musicapplication;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NowPlayingActivity extends AppCompatActivity {

    // Sets global variable which monitors if song is playing or not
    boolean nowPlaying = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        // Intent which gets data about the song which user clicked on
        Intent intent = getIntent();
        Bundle songData = intent.getExtras();

        // Finds TextView where song title should be displayed in activity_now_playing
        TextView songTitle = (TextView) findViewById(R.id.now_playing_title);
        // Gets the song title which was picked by user
        songTitle.setText(songData.getString("EXTRA_SONG_TITLE"));

        // Finds TextView where artist name should be displayed in activity_now_playing
        TextView artistName = (TextView) findViewById(R.id.now_playing_artist);
        // Gets the song artist name which was picked by user
        artistName.setText(songData.getString("EXTRA_ARTIST_NAME"));

        // Finds TextView where duration should be displayed in activity_now_playing
        TextView songDuration = (TextView) findViewById(R.id.now_playing_duration);
        // Gets the duration of song which was picked by user
        songDuration.setText(songData.getString("EXTRA_SONG_DURATION"));

        // Finds ImageView where album cover image should be displayed in activity_now_playing
        ImageView albumCover = (ImageView) findViewById(R.id.now_playing_album_cover);
        // Gets the album cover of song which was picked by user
        albumCover.setImageResource(songData.getInt("EXTRA_ALBUM_COVER_IMAGE"));

        // Sets OnClick Listener for the play/pause button
        final ImageButton playPauseBtn = (ImageButton) findViewById(R.id.btn_play_pause);
        playPauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nowPlaying) {
                    playPauseBtn.setImageResource(R.drawable.ic_play);
                    nowPlaying = false;
                    Toast.makeText(NowPlayingActivity.this, R.string.paused, Toast.LENGTH_SHORT).show();
                } else {
                    playPauseBtn.setImageResource(R.drawable.ic_pause);
                    nowPlaying = true;
                    Toast.makeText(NowPlayingActivity.this, R.string.played, Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Sets OnClickListener for the stop button
        ImageButton stopBtn = (ImageButton) findViewById(R.id.btn_stop);
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nowPlaying) {
                    playPauseBtn.setImageResource(R.drawable.ic_play);
                    nowPlaying = false;
                    Toast.makeText(NowPlayingActivity.this, R.string.stopped, Toast.LENGTH_SHORT).show();
                } else {
                    playPauseBtn.setImageResource(R.drawable.ic_play);
                    nowPlaying = false;
                    Toast.makeText(NowPlayingActivity.this, R.string.stopped, Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Finds the ImageView with the BackButton
        ImageButton backButton = findViewById(R.id.btn_back);
        // Sets OnClickListener to it and gets back to the Album
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
