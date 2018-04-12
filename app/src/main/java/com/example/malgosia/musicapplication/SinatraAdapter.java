package com.example.malgosia.musicapplication;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SinatraAdapter extends ArrayAdapter<Album> {
    /**
     * Constructor for Sinatra Adapter
     *
     * @param context is the current context which is used to inflate the list layout file
     * @param sinatra is the list of Album objects which will populate the list
     */

    public SinatraAdapter(Activity context, ArrayList<Album> sinatra) {
        super(context, 0, sinatra);
    }

    /**
     * Provides a ListView for the adapter to populate
     *
     * @param position    is the position on the list where data from current object should be displayed
     * @param convertView is the recycled item view to populate
     * @param parent      is the parent ViewGroup which is used to inflation
     * @return view for the right position in the AdapterView
     */

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_view, parent, false);
        }

        // Get the Album object located at this particular position on the list
        Album currentAlbumItem = getItem(position);

        // Finds the TextView in the list_item_view where the song title should be displayed
        TextView songTitle = (TextView) listItemView.findViewById(R.id.song_title);
        // Sets this title onto TextView
        songTitle.setText(currentAlbumItem.getSongTitle());

        // Finds the TextView in the list_item_view where the artist name should be displayed
        TextView artistName = (TextView) listItemView.findViewById(R.id.artist_name);
        // Sets this name onto TextView
        artistName.setText(currentAlbumItem.getArtistName());

        // Finds the TextView in the list_item_view where the song duration should be displayed
        TextView songDuration = (TextView) listItemView.findViewById(R.id.song_duration);
        // Sets this duration onto TextView
        songDuration.setText(currentAlbumItem.getDuration());

        // Finds the ImageView in the list_item_view where the album cover image should be displayed
        ImageView albumCover = (ImageView) listItemView.findViewById(R.id.album_cover);
        // Sets this resource onto ImageView
        albumCover.setImageResource(currentAlbumItem.getImageCover());

        return listItemView;
    }
}
