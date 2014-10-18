package com.dt.iTunesController;
import com.jacob.com.Dispatch;

/**
 * Represents a collection of source objects.
 * 
 * Note that collection indices are always 1-based.
 * 
 * You can retrieve all the sources using <code>ITSource.getSources()</code>.
 * 
 * @author <a href="mailto:steve@dot-totally.co.uk">Steve Eyre</a>
 * @version 0.2
 */
public class ITSourceCollection {

    protected Dispatch object;
    
    public ITSourceCollection(Dispatch d) {
        object = d;
    }
    
    /**
     * Returns the number of sources in the collection.
     * @return Returns the number of sources in the collection.
     */
    public int getCount() {
        return Dispatch.get(object, "Count").getInt();
    }
    
    /**
     * Returns an ITSource object corresponding to the given index (1-based).
     * @param index Index of the source to retrieve, must be less than or
     * equal to <code>ITSourceCollection.getCount()</code>. 
     * @return Returns an ITSource object corresponding to the given index.
     * Will be set to NULL if no source could be retrieved.
     */
    public ITSource getItem (int index) {
        Dispatch item = Dispatch.call(object, "Item", index).toDispatch();
        return new ITSource(item);
    }
    
    /**
     * Returns an ITSource object withthe specified name.
     * @param name The name of the source to retrieve.
     * @return Returns an ITSource object corresponding to the given index.
     * Will be set to NULL if no source could be retrieved.
     */
    public ITSource getItemByName (String name) {
        Dispatch item = Dispatch.call(object, "ItemByName", name).toDispatch();
        return new ITSource(item);
    }
    
    /**
     * Returns an ITSource object with the specified persistent ID. See the
     * documentation on ITObject for more information on persistent IDs. 
     * @param highID The high 32 bits of the 64-bit persistent ID.
     * @param lowID The low 32 bits of the 64-bit persistent ID.
     * @return Returns an ITSource object with the specified persistent ID.
     * Will be set to NULL if no source could be retrieved.
     */
    public ITSource getItemByPersistentID (int highID, int lowID) {
        Dispatch item = Dispatch.call(object, "ItemByPersistentID", highID, lowID).toDispatch();
        return new ITSource(item);
    }

}