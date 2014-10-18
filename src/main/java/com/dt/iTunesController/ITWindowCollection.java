package com.dt.iTunesController;
import com.jacob.com.Dispatch;

/**
 * Represents a collection of window objects.
 * 
 * Note that collection indices are always 1-based.
 * 
 * You can retrieve all the windows using
 * <code>iTunes.getWindows()</code>.
 * 
 * @author <a href="mailto:steve@dot-totally.co.uk">Steve Eyre</a>
 * @version 0.2
 */
public class ITWindowCollection {

    protected Dispatch object;
    
    public ITWindowCollection(Dispatch d) {
        object = d;
    }

	// TODO: iTunes.getWindows()
    
    /**
     * Returns the number of playlists in the collection.
     * @return Returns the number of playlists in the collection.
     */
    public int getCount() {
        return Dispatch.get(object, "Count").getInt();
    }
    
    /**
     * Returns an ITWindow object corresponding to the given index (1-based).
     * @param index Index of the playlist to retrieve, must be less than or
     * equal to <code>ITWindowCollection.getCount()</code>. 
     * @return Returns an ITWindow object corresponding to the given index.
     * Will be set to NULL if no playlist could be retrieved.
     */
    public ITWindow getItem (int index) {
        Dispatch item = Dispatch.call(object, "Item", index).toDispatch();
        return new ITWindow(item);
    }
    /**
     * Returns an ITWindow object with the specified name.
     * @param name The name of the window to retrieve.
     * @return Returns an ITWindow object corresponding to the given index.
     * Will be set to NULL if no ITWindow could be retrieved.
     */
    public ITWindow ItemByName (String name) {
        Dispatch item = Dispatch.call(object, "ItemByName", name).toDispatch();
        return new ITWindow(item);
    }
    
}
