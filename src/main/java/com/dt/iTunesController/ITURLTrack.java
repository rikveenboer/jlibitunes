package com.dt.iTunesController;
import com.jacob.com.Dispatch;

/**
 * Represents a URL track.
 *
 * A URL track references a network audio stream.
 * @author <a href="mailto:steve@dot-totally.co.uk">Steve Eyre</a>
 * @version 0.2
 */
public class ITURLTrack extends ITTrack {

    public ITURLTrack (Dispatch d) {
        super(d);
    }

    /**
     * Returns the URL of the stream represented by this track.
     * @return The URL of the stream represented by this track.
     */
    public String getURL () {
        return Dispatch.get(object, "URL").getString();
    }

    /**
     * Set the URL of the stream represented by this track.
     * @param url The URL of the stream represented by this track.
     */
    public void setURL (String url) {
        Dispatch.call(object, "URL", url);
    }

    /**
     * Returns true if this track is a podcast track. If a podcast track is an
     * <code>IITURLTrack</code>, the podcast episode has not been downloaded.
     * @return Returns true if this track is a podcast track.
     */
    public boolean isPodcast () {
        return Dispatch.get(object, "Podcast").getBoolean();
    }

    /**
     * Returns the category for the track.
     * @return Returns the category for the track.
     */
    public String getCategory () {
        return Dispatch.get(object, "Category").getString();
    }

    /**
     * Sets the category for the track.
     * @param category Sets the category for the track.
     */
    public void setCategory (String category) {
        Dispatch.call(object, "Category", category);
    }

    /**
     * Returns the description for the track.
     * @return Returns the description for the track.
     */
    public String getDescription () {
        return Dispatch.get(object, "Description").getString();
    }

    /**
     * Sets the description for the track.
     * @param description The new description for the track.
     */
    public void setDescription (String description) {
        Dispatch.call(object, "Description", description);
    }

    /**
     * Returns the long description for the track.
     * @return Returns the description for the track.
     */
    public String getLongDescription () {
        return Dispatch.get(object, "LongDescription").getString();
    }

    /**
     * Sets the long description for the track.
     * @param longDescription The new long description for the track.
     */
    public void setLongDescription (String longDescription) {
        Dispatch.call(object, "LongDescription", longDescription);
    }

    /**
     * Returns the user or computed rating of the album that this track belongs
     * to (0 to 100). If the album rating has never been set, or has been set to
     * 0, it will be computed based on the ratings of tracks in the album.
     * @return Returns the album rating of the album that this track belongs to (0 to 100).
     */
    public long getAlbumRating () {
        return Dispatch.get(object, "AlbumRating").getLong();
    }

    /**
     * Set the album rating of the album that this track belongs to (0 to 100).
     * If the album rating is set to 0, it will be computed based on the ratings
     * of tracks in the album.
     * @param albumRating The new album rating of the album that this track
     * belongs to (0 to 100). If rating is outside this range, it will be
     * pinned.
     */
    public void setAlbumRating (long albumRating) {
        Dispatch.call(object, "AlbumRating", albumRating);
    }

    /**
     * Returns the album rating kind. If the album rating has never been set, or
     * has been set to 0, the kind is ITRatingKindComputed. Otherwise, the kind
     * is ITRatingKindUser.
     * @return Returns the album rating kind.
     */
    public ITRatingKind getAlbumRatingKind () {
        return ITRatingKind.values()[Dispatch.get(object, "AlbumRatingKind").getInt()];
    }

    /**
     * Returns the track rating kind. If the track rating has never been set, or
     * has been set to 0, the kind is ITRatingKindComputed. Otherwise, the kind
     * is ITRatingKindUser.
     * @return Returns the track rating kind.
     */
    public ITRatingKind getRatingKind () {
        return ITRatingKind.values()[Dispatch.get(object, "RatingKind").getInt()];
    }

    /**
     * Returns a collection of playlists that contain the song that this track
     * represents.
     *
     * This is the same collection of playlists that are shown in the "Show in
     * Playlist" contextual menu for a track, plus the specific playlist that
     * contains this track.
     *
     * A track represents a song in a single playlist, use
     * <code>ITTrack.getPlaylist()</code> to get the specific playlist that
     * contains this track.
     * @return Collection of ITPlaylist objects.
     */
    public ITPlaylistCollection getPlaylists () {
        Dispatch playlists = Dispatch.get(object, "Playlists").toDispatch();
        return new ITPlaylistCollection(playlists);
    }

    /**
     * Update the podcast feed for this track. This is equivalent to the user
     * choosing Update Podcast from the contextual menu for the podcast feed
     * that contains this track.
     */
    public void updatePodcastFeed () {
        Dispatch.call(object, "UpdatePodcastFeed");
    }

    /**
     * Start downloading the podcast episode that corresponds to this track.
     * This is equivalent to the user clicking the Get button next to this
     * track.
     */
    public void downloadPodcastEpisode () {
        Dispatch.call(object, "DownloadPodcastEpisode");
    }

    /**
     * Reveals the track in the main browser window.
     */
    public void reveal() {
        Dispatch.call(object, "Reveal");
    }

}
