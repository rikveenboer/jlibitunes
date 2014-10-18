package com.dt.iTunesController;
import com.jacob.com.Dispatch;

/**
 * Represents a collection of Artwork objects.
 * 
 * Note that collection indices are always 1-based.
 * 
 * You can retrieve all the Artworks defined for a source using
 * <code>ITSource.getArtwork()</code>.
 * 
 * @author <a href="mailto:steve@dot-totally.co.uk">Steve Eyre</a>
 * @version 0.2
 */
public class ITArtworkCollection {

    protected Dispatch object;
    
    public ITArtworkCollection(Dispatch d) {
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
     * Returns an ITArtwork object corresponding to the given index (1-based).
     * @param index Index of the playlist to retrieve, must be less than or
     * equal to <code>ITArtworkCollection.getCount()</code>. 
     * @return Returns an ITArtwork object corresponding to the given index.
     * Will be set to NULL if no playlist could be retrieved.
     */
    public ITArtwork getItem (int index) {
        Dispatch item = Dispatch.call(object, "Item", index).toDispatch();
        return new ITArtwork(item);
    }
    
    /**
     * Returns an ITArtwork object with the specified persistent ID. See the
     * documentation on ITObject for more information on persistent IDs. 
     * @param highID The high 32 bits of the 64-bit persistent ID.
     * @param lowID The low 32 bits of the 64-bit persistent ID.
     * @return Returns an ITArtwork object with the specified persistent ID.
     * Will be set to NULL if no playlist could be retrieved.
     */
    public ITArtwork getItemByPersistentID (int highID, int lowID) {
        Dispatch item = Dispatch.call(object, "ItemByPersistentID", highID, lowID).toDispatch();
        return new ITArtwork(item);
    }
}
