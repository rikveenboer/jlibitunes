package com.dt.iTunesController;
import com.jacob.com.Dispatch;

/**
 * Represents a playlist.
 * 
 * A playlist is always associated with an ITSource.
 * 
 * You can retrieve all the playlists defined for a source using
 * <code>ITSource.getPlaylists()</code>.
 * 
 * For convenience, you can retrieve the main library playlist using
 * <code>iTunes.getLibraryPlaylist()</code>.
 * 
 * You can create a new playlist using <code>iTunes.createPlaylist()</code>.
 * 
 * @author <a href="mailto:steve@dot-totally.co.uk">Steve Eyre</a>
 * @version 0.2
 */
public class ITPlaylist extends ITObject {
    
    public ITPlaylist (Dispatch d) {
        super(d);
    }
    
    /**
     * Delete this object.
     */
    public void delete() {
        Dispatch.call(object, "Delete");
    }
    
    /**
     * Start playing the first track in this object.
     */
    public void playFirstTrack() {
        Dispatch.call(object, "PlayFirstTrack");
    }
    
    /**
     * Print this object.
     * @param showPrintDialog If true, display the print dialog.
     * @param printKind The printout kind.
     * @param theme The name of the theme to use. This corresponds to the name
     * of a Theme combo box item in the print dialog for the specified printKind
     * (e.g. "Track length"). This string cannot be longer than 255 characters,
     * but it may be empty.
     */
    public void print(boolean showPrintDialog, ITPlaylistPrintKind printKind, String theme) {
        Dispatch.call(object, "Print", showPrintDialog, printKind.ordinal(), theme);
    }
    
    /**
     * Returns a collection containing the tracks with the specified text.
     * @param searchText The text to search for. This string cannot be longer
     * than 255 chracters.
     * @param searchFields Specifies which fields of each track should be
     * searched for searchText.
     * @return Collection of IITTrack objects. This will be NULL if no tracks
     * meet the search criteria.
     */
    public ITTrackCollection search (String searchText, ITPlaylistSearchField searchFields) {
        Dispatch collection = Dispatch.call(object, "Search", searchText, searchFields.ordinal()).getDispatch();
        return new ITTrackCollection(collection);
    }
    
    /**
     * Returns the kind of the object.
     * @return Returns the kind of the object.
     */
    public ITPlaylistKind getKind() {
        return ITPlaylistKind.values()[Dispatch.get(object, "Kind").getInt()];
    }
    
    /**
     * Returns an ITSource object corresponding to the source that contains the
     * object.
     * @return Returns an ITSource object corresponding to the source that
     * contains the object.
     */
    public ITSource getSource() {
        Dispatch source = Dispatch.get(object, "Source").toDispatch();
        return new ITSource(source);
    }
    
    /**
     * Returns the total length of all songs in the object (in seconds).
     * @return Returns the total length of all songs in the object (in
     * seconds).
     */
    public int getDuration() {
        return Dispatch.get(object, "Duration").getInt();
    }
    
    /**
     * Set whether songs in the object should be played in random order.
     * @param shouldShuffle True if songs in the object should be played in
     * random order.
     */
    public void setShuffle(boolean shouldShuffle) {
        Dispatch.put(object, "Shuffle", shouldShuffle);
    }
    
    /**
     * Returns the total size of all songs in the object (in bytes).
     * @return Returns the total size of all songs in the object (in bytes).
     */
    public double getSize() {
        return Dispatch.get(object, "Size").getDouble();
    }
    
    /**
     * Sets the playback repeat mode.
     * @param repeatMode The new playback repeat mode.
     */
    public void setSongRepeat(ITPlaylistRepeatMode repeatMode) {
        Dispatch.put(object, "SongRepeat", repeatMode.ordinal());
    }
    
    /**
     * Cycle repeat modes.
     */
    public void cycleSongRepeat() {
        int repeat = Dispatch.get(object, "SongRepeat").getInt();
        Dispatch.put(object, "SongRepeat", (repeat + 1) % 3);
    }
    
    /**
     * Returns the playback repeat mode.
     * @return Returns the playback repeat mode.
     */
    public ITPlaylistRepeatMode getSongRepeat() {
        return ITPlaylistRepeatMode.values()[Dispatch.get(object, "SongRepeat").getInt()];
    }
    
    /**
     * Returns the total length of all songs in the object (in MM:SS format).
     * @return Returns the total length of all songs in the object (in
     * MM:SS format).
     */
    public String getTime() {
        return Dispatch.get(object, "Time").getString();
    }
    
    /**
     * Returns true if the object is visible in the sources list.
     * @return True if the object is visible in the sources list.
     */
    public boolean getVisible() {
        return Dispatch.get(object, "Visible").getBoolean();
    }
    
    /**
     * Returns a collection containing the tracks in this object.
     * @return Collection of ITTrack objects.
     */
    public ITTrackCollection getTracks() {
        Dispatch tracks = Dispatch.get(object, "Tracks").toDispatch();
        return new ITTrackCollection(tracks);
    }

    /**
     * Returns the shuffle state.
     * @return true if current state is shuffle.
     */
    public boolean getShuffle() {
        return Dispatch.get(object, "Shuffle").getBoolean();
    }
    
    /**
     * Toggle the shuffle state.
     */
    public void toggleShuffle() {
        setShuffle(!getShuffle());
    }
    
    public boolean containsTrack(ITTrack track) {
        return getTracks().containsTrack(track);
    }
}
