package com.example.malgosia.musicapplication;

public class Album {

    // Artist name
    private String mArtistName;

    // Song title
    private String mSongTitle;

    // Song duration
    private String mDuration;

    // Image on album cover
    private int mImageCover;

    /**
     * Creation of new Album object
     */

    public Album(String artistName, String songTitle, String songDuration, int imageCover) {
        mArtistName = artistName;
        mSongTitle = songTitle;
        mDuration = songDuration;
        mImageCover = imageCover;
    }

    /**
     * Get the artist name
     */
    public String getArtistName() {
        return mArtistName;
    }

    /**
     * Get the song title
     */
    public String getSongTitle() {
        return mSongTitle;
    }

    /**
     * Get the song duration
     */
    public String getDuration() {
        return mDuration;
    }

    /**
     * Get the id of image resource which is album cover
     */
    public int getImageCover() {
        return mImageCover;
    }
}
