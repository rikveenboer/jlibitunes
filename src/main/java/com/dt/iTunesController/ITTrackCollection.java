package com.dt.iTunesController;
import com.jacob.com.Dispatch;

/**
 * Represents a collection of track objects.
 * 
 * Note that collection indices are always 1-based.
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
public class ITTrackCollection {

    protected Dispatch object;
    
    public ITTrackCollection(Dispatch d) {
        object = d;
    }
    
    /**
     * Returns the number of tracks in the collection.
     * @return Returns the number of tracks in the collection.
     */
    public int getCount() {
        return Dispatch.get(object, "Count").getInt();
    }
    
    /**
     * Returns an ITTrack object corresponding to the given index (1-based).
     * @param index Index of the track to retrieve, must be less than or
     * equal to <code>ITTrackCollection.getCount()</code>. 
     * @return Returns an ITTrack object corresponding to the given index.
     * Will be set to NULL if no track could be retrieved.
     */
    public ITTrack getItem (int index) {
        Dispatch item = Dispatch.call(object, "Item", index).toDispatch();
        ITTrack track = new ITTrack(item);
        if (track.getKind()==ITTrackKind.ITTrackKindFile) {
        	return new ITFileOrCDTrack(item);
        } else if (track.getKind()==ITTrackKind.ITTrackKindCD) {
            	return new ITFileOrCDTrack(item);
        } else if (track.getKind()==ITTrackKind.ITTrackKindURL ) {
        	return new ITURLTrack(item);
        } else {
        	return track;
		}
    }
    
    /**
     * Returns an ITTrack object corresponding to the given index (1-based).
     * @param index Index of the track to retrieve, must be less than or
     * equal to <code>ITTrackCollection.getCount()</code>. 
     * @return Returns an ITTrack object corresponding to the given index.
     * Will be set to NULL if no track could be retrieved.
     */
    public ITTrack getItemByPlayOrder(int index) {
        Dispatch item = Dispatch.call(object, "ItemByPlayOrder", index).toDispatch();
        return new ITTrack(item);
    }
    
    /**
     * Returns an ITTrack object withthe specified name.
     * @param name The name of the track to retrieve.
     * @return Returns an ITTrack object corresponding to the given index.
     * Will be set to NULL if no track could be retrieved.
     */
    public ITTrack ItemByName (String name) {
        Dispatch item = Dispatch.call(object, "ItemByName", name).toDispatch();
        return new ITTrack(item);
    }
    
    /**
     * Returns an ITTrack object with the specified persistent ID. See the
     * documentation on ITObject for more information on persistent IDs. 
     * @param highID The high 32 bits of the 64-bit persistent ID.
     * @param lowID The low 32 bits of the 64-bit persistent ID.
     * @return Returns an ITTrack object with the specified persistent ID.
     * Will be set to NULL if no track could be retrieved.
     */
    public ITTrack getItemByPersistentID (int highID, int lowID) {
        Dispatch item = Dispatch.call(object, "ItemByPersistentID", highID, lowID).toDispatch();
        return new ITTrack(item);
    }

}
