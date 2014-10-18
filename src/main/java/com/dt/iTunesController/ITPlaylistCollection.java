package com.dt.iTunesController;
import com.jacob.com.Dispatch;

/**
 * Represents a collection of playlist objects.
 * 
 * Note that collection indices are always 1-based.
 * 
 * You can retrieve all the playlists defined for a source using
 * <code>ITSource.getPlaylists()</code>.
 * 
 * @author <a href="mailto:steve@dot-totally.co.uk">Steve Eyre</a>
 * @version 0.2
 */
public class ITPlaylistCollection {

    protected Dispatch object;
    
    public ITPlaylistCollection(Dispatch d) {
        object = d;
    }
    
    /**
     * Returns the number of playlists in the collection.
     * @return Returns the number of playlists in the collection.
     */
    public int getCount() {
        return Dispatch.get(object, "Count").getInt();
    }
    
    /**
     * Returns an ITPlaylist object corresponding to the given index (1-based).
     * @param index Index of the playlist to retrieve, must be less than or
     * equal to <code>ITPlaylistCollection.getCount()</code>. 
     * @return Returns an ITPlaylist object corresponding to the given index.
     * Will be set to NULL if no playlist could be retrieved.
     */
    public ITPlaylist getItem (int index) {
        Dispatch item = Dispatch.call(object, "Item", index).toDispatch();
        return new ITPlaylist(item);
    }
    
    /**
     * Returns an ITPlaylist object withthe specified name.
     * @param name The name of the playlist to retrieve.
     * @return Returns an ITPlaylist object corresponding to the given index.
     * Will be set to NULL if no playlist could be retrieved.
     */
    public ITPlaylist ItemByName (String name) {
        Dispatch item = Dispatch.call(object, "ItemByName", name).toDispatch();
        return new ITPlaylist(item);
    }
    
    /**
     * Returns an ITPlaylist object with the specified persistent ID. See the
     * documentation on ITObject for more information on persistent IDs. 
     * @param highID The high 32 bits of the 64-bit persistent ID.
     * @param lowID The low 32 bits of the 64-bit persistent ID.
     * @return Returns an ITPlaylist object with the specified persistent ID.
     * Will be set to NULL if no playlist could be retrieved.
     */
    public ITPlaylist getItemByPersistentID (int highID, int lowID) {
        Dispatch item = Dispatch.call(object, "ItemByPersistentID", highID, lowID).toDispatch();
        return new ITPlaylist(item);
    }

}
