package com.dt.iTunesController;
import com.jacob.com.*;
import java.util.Date;

/**
 * Represents a track.
 * 
 * A track represents a song in a single playlist. A song may be in more than
 * one playlist, in which case it would be represented by multiple tracks.
 * 
 * You can retrieve the currently targeted (playing) track using
 * <code>iTunes.getCurrentTrack()</code>.
 * 
 * Typically, an ITrack is accessed through an ITTrackCollection.
 * 
 * You can retrieve all the tracks defined for a playlist using
 * <code>ITPlaylist.getTracks()</code>.
 * 
 * You can retrieve the currently selected track or tracks using
 * <code>iTunes.getSelectedTracks()</code>.
 * 
 * @author <a href="mailto:steve@dot-totally.co.uk">Steve Eyre</a>
 * @version 0.2
 */
public class ITTrack extends ITObject {
    
    public ITTrack (Dispatch d) {
        super(d);
    }
    
    /**
     * Delete this object.
     */
    public void delete() {
        Dispatch.call(object, "Delete");
    }
    
    /**
     * Start playing this object.
     */
    public void play() {
        Dispatch.call(object, "Play");
    }
    
    /**
     * Set the name of the album containing the object.;
     * @param album The new name of the album containing the object. 
     */
    public void setAlbum(String album) {
        Dispatch.put(object, "Album", album);
    }
    
    /**
     * Returns the name of the album containing the object.
     * @return Returns the name of the album containing the object.
     */
    public String getAlbum() {
        return Dispatch.get(object, "Album").getString();
    }
    
    /**
     * Set the name of the artist/source of the object.
     * @param artist The new artist/source of the object.
     */
    public void setArtist(String artist) {
        Dispatch.put(object, "Artist", artist);
    }
    
    /**
     * Returns the name of the artist/source of the object.
     * @return Returns the name of the artist/source of the object.
     */
    public String getArtist() {
        return Dispatch.get(object, "Artist").getString();
    }
    
    /**
     * Returns the bit rate of the object (in kbps).
     * @return Returns the bit rate of the object (in kbps).
     */
    public int getBitRate() {
        return Dispatch.get(object, "BitRate").getInt();
    }
    
    /**
     * Set the tempo of the object (in beats per minute).
     * @param beatsPerMinute The new tempo of the object (in beats per minute).
     */
    public void setBPM(int beatsPerMinute) {
        Dispatch.put(object, "BPM", beatsPerMinute);
    }
    
    /**
     * Returns the tempo of the object (in beats per minute).
     * @return Returns the tempo of the object (in beats per minute).
     */
    public int getBPM() {
        return Dispatch.get(object, "BPM").getInt();
    }
    
    /**
     * Set freeform notes about the object.
     * @param comment The new freeform notes about the object.
     */
    public void setComment(String comment) {
        Dispatch.put(object, "Comment", comment);
    }
    
    /**
     * Returns freeform notes about the object.
     * @return Returns freeform notes about the object.
     */
    public String getComment() {
        return Dispatch.get(object, "Comment").getString();
    }
    
    /**
     * Set whether this object is from a compilation album.
     * @param isCompilation True if this object should be from a compilation album.
     */
    public void setCompilation(boolean isCompilation) {
        Dispatch.put(object, "Compilation", isCompilation);
    }
    
    /**
     * Returns true if this object is from a compilation album.
     * @return Returns true if this object is from a compilation album.
     */
    public boolean getCompilation() {
        return Dispatch.get(object, "Compilation").getBoolean();
    }
    
    /**
     * Set the composer of the object. 
     * @param composer The new composer of the object. 
     */
    public void setComposer (String composer) {
        Dispatch.put(object, "Composer", composer);
    }
    
    /**
     * Returns the composer of the object. 
     * @return Returns the composer of the object. 
     */
    public String getComposer() {
        return Dispatch.get(object, "Composer").getString();
    }
    
    /**
     * Returns the date the object was added to the playlist.
     * @return Returns the date the object was added to the playlist.
     */
    public Date getDateAdded() {
        return Dispatch.get(object, "DateAdded").getJavaDate();
    }
    
    /**
     * Set the total number of discs in the source album.
     * @param discCount The new total number of discs in the source album.
     */
    public void setDiscCount (int discCount) {
        Dispatch.put(object, "DiscCount", discCount);
    }
    
    /**
     * Returns the total number of discs in the source album.
     * @return Returns the total number of discs in the source album.
     */
    public int getDiscCount() {
        return Dispatch.get(object, "DiscCount").getInt();
    }
    
    /**
     * Set the index of the disc containing the object on the source album.
     * @param discNumber The new index of the disc containing the object on the
     * source album.
     */
    public void setDiscNumber (int discNumber) {
        Dispatch.put(object, "DiscNumber", discNumber);
    }
    
    /**
     * Returns the index of the disc containing the object on the source album.
     * @return Returns the index of the disc containing the object on the source
     * album.
     */
    public int getDiscNumber() {
        return Dispatch.get(object, "DiscNumber").getInt();
    }
    
    /**
     * Returns the length of the object (in seconds).
     * @return Returns the length of the object (in seconds).
     */
    public int getDuration() {
        return Dispatch.get(object, "Duration").getInt();
    }
    
    /**
     * Set whether this object is checked for playback.
     * @param shouldBeEnabled True if the object should be checked for playback.
     */
    public void setEnabled (boolean shouldBeEnabled) {
        Dispatch.put(object, "Enabled", shouldBeEnabled);
    }
    
    /**
     * Returns true if the object is checked for playback.
     * @return Returns true if the object is checked for playback.
     */
    public boolean getEnabled() {
        return Dispatch.get(object, "Enabled").getBoolean();
    }
    
    /**
     * Set the name of the EQ preset of the object. 
     * @param eq The new name of the EQ preset of the object.
     */
    public void setEQ (String eq) {
        Dispatch.put(object, "EQ", eq);
    }
    
    /**
     * Returns the name of the EQ preset of the object.
     * @return Returns the name of the EQ preset of the object.
     */
    public String getEQ() {
        return Dispatch.get(object, "EQ").getString();
    }
    
    /**
     * Set the stop time of the object (in seconds).
     * @param finish The new stop time of the object (in seconds).
     */
    public void setFinish(int finish) {
        Dispatch.put(object, "Finish", finish);
    }
    
    /**
     * Returns the stop time of the object (in seconds).
     * @return Returns the stop time of the object (in seconds).
     */
    public int getFinish() {
        return Dispatch.get(object, "Finish").getInt();
    }
    
    /**
     * Returns the music/audio genre (category) of the object.
     * @param genre Returns the music/audio genre (category) of the object.
     */
    public void setGenre(String genre) {
        Dispatch.put(object, "Genre", genre);
    }
    
    /**
     * Set the music/audio genre (category) of the object.
     * @return The new music/audio genre (category) of the object.
     */
    public String getGenre() {
        return Dispatch.get(object, "Genre").getString();
    }
    
    /**
     * Set the grouping (piece) of the object.
     * Generally used to denote movements within classical work.
     * @param grouping The new grouping (piece) of the object.
     */
    public void setGrouping (String grouping) {
        Dispatch.put(object, "Grouping", grouping);
    }
    
    /**
     * Returns the grouping (piece) of the object.
     * Generally used to denote movements within classical work.
     * @return Returns the grouping (piece) of the object.
     */
    public String getGrouping() {
        return Dispatch.get(object, "Grouping").getString();
    }
    
    public ITTrackKind getKind() {
        return ITTrackKind.values()[Dispatch.get(object, "Kind").getInt()];
    }
    
    /**
     * Returns the text description of the object (e.g. "AAC audio file").
     * @return Returns the text description of the object (e.g. "AAC audio file").
     */
    public String getKindAsString() {
        return Dispatch.get(object, "KindAsString").getString();
    }
    
    /**
     * Returns the modification date of the content of the object.
     * @return Returns the modification date of the content of the object.
     */
    public Date getModificationDate() {
        return Dispatch.get(object, "ModificationDate").getJavaDate();
    }
    
    /**
     * Set the number of times the object has been played. This property cannot
     * be set if the object is not playable (e.g. a PDF file). 
     * @param playedCount The new number of times the object has been played.
     */
    public void setPlayedCount (int playedCount) {
        Dispatch.put(object, "PlayedCount", playedCount);
    }
    
    /**
     * Returns the number of times the object has been played.
     * @return Returns the number of times the object has been played.
     */
    public int getPlayedCount() {
        return Dispatch.get(object, "PlayedCount").getInt();
    }
    
    /**
     * Set the date and time the object was last played. This property cannot be
     * set if the object is not playable (e.g. a PDF file).
     * A value of zero means no played date.
     * @param playedDate The new date and time the object was last played.
     */
    public void setPlayedDate (Date playedDate) {
        Dispatch.put(object, "PlayedDate", playedDate);
    }
    
    /**
     * Returns the date and time the object was last played.
     * A value of zero means no played date.
     * @return Returns the date and time the object was last played.
     */
    public Date getPlayedDate() {
        return Dispatch.get(object, "PlayedDate").getJavaDate();
    }
    
    /**
     * Returns an ITPlaylist object corresponding to the playlist that contains
     * the object. Use ITFileOrCDTrack::Playlists() or IITURLTrack::Playlists()
     * to get the collection of all playlists that contain the song this object
     * represents. 
     * @return Returns an ITPlaylist object corresponding to the playlist that
     * contains the object.
     */
    public ITPlaylist getPlaylist() {
        Dispatch playlist = Dispatch.get(object, "Playlist").toDispatch();
        return new ITPlaylist(playlist);
    }
    
    /**
     * Returns the play order index of the object in the owner playlist
     * (1-based). 
     * You can pass this index to IITTrackCollection::ItemByPlayOrder() for the
     * collection returned by ITPlaylist::Tracks() to retrieve an ITTrack
     * object corresponding to this object.
     * @return Returns the play order index of the object in the owner playlist.
     */
    public int getPlayOrderIndex() {
        return Dispatch.get(object, "PlayOrderIndex").getInt();
    }
    
    /**
     * Set the rating of the object (0 to 100). If the object rating is set to 0,
     * it will be computed based on the album rating. 
     * @param rating The new rating of the object (0 to 100).
     */
    public void setRating (int rating) {
        Dispatch.put(object, "Rating", rating);
    }
    
    /**
     * Returns the rating of the object (0 to 100). If the object rating has never
     * been set, or has been set to 0, it will be computed based on the album
     * rating.
     * @return Returns the rating of the object (0 to 100).
     */
    public int getRating() {
        return Dispatch.get(object, "Rating").getInt();
    }
    
    /**
     * Returns the sample rate of the object (in Hz).
     * @return Returns the sample rate of the object (in Hz).
     */
    public int getSampleRate() {
        return Dispatch.get(object, "SampleRate").getInt();
    }
    
    /**
     * Returns the size of the object (in bytes).
     * @return Returns the size of the object (in bytes).
     */
    public int getSize() {
        return Dispatch.get(object, "Size").getInt();
    }
    
    /**
     * Set the start time of the object (in seconds).
     * @param start The new start time of the object (in seconds).
     */
    public void setStart (int start) {
        Dispatch.put(object, "Start", start);
    }
    
    /**
     * Returns the start time of the object (in seconds).
     * @return Returns the start time of the object (in seconds).
     */
    public int getStart() {
        return Dispatch.get(object, "Start").getInt();
    }
    
    /**
     * Returns the length of the object (in MM:SS format).
     * @return Returns the length of the object (in MM:SS format).
     */
    public String getTime() {
        return Dispatch.get(object, "Time").getString();
    }
    
    /**
     * Set the total number of tracks on the source album.
     * @param trackCount The new total number of tracks on the source album.
     */
    public void setTrackCount (int trackCount) {
        Dispatch.put(object, "TrackCount", trackCount);
    }
    
    /**
     * Returns the total number of tracks on the source album.
     * @return Returns the total number of tracks on the source album.
     */
    public int getTrackCount() {
        return Dispatch.get(object, "TrackCount").getInt();
    }
    
    /**
     * Set the index of the object on the source album.
     * @param trackNumber The new index of the object on the source album.
     */
    public void setTrackNumber (int trackNumber) {
        Dispatch.put(object, "TrackNumber", trackNumber);
    }
    
    /**
     * Returns the index of the object on the source album.
     * @return Returns the index of the object on the source album.
     */
    public int getTrackNumber() {
        return Dispatch.get(object, "TrackNumebr").getInt();
    }
    
    /**
     * Set the relative volume adjustment of the object (-100% to 100%).
     * @param volumeAdjustment Set the relative volume adjustment of the object
     * (-100% to 100%).
     */
    public void setVolumeAdjustment (int volumeAdjustment) {
        Dispatch.put(object, "VolumeAdjustment", volumeAdjustment);
    }
    
    /**
     * Returns the relative volume adjustment of the object (-100% to 100%).
     * @return Returns the relative volume adjustment of the object (-100% to 100%).
     */
    public int getVolumeAdjustment() {
        return Dispatch.get(object, "VolumeAdjustment").getInt();
    }
    
    /**
     * Set the year the object was recorded/released.
     * @param year The new year the object was recorded/released.
     */
    public void setYear (int year) {
        Dispatch.put(object, "Year", year);
    }
    
    /**
     * Returns the year the object was recorded/released.
     * @return Returns the year the object was recorded/released.
     */
    public int getYear() {
        return Dispatch.get(object, "Year").getInt();
    }

    /**
     * Returns the track associated artworks
     * @return Returns the track associated artworks
     */
    public ITArtworkCollection getArtwork() {
        Dispatch art = Dispatch.get(object, "Artwork").toDispatch();
        return new ITArtworkCollection(art);
    }
}
