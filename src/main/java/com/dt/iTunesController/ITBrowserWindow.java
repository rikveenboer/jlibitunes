package com.dt.iTunesController;
import com.jacob.com.Dispatch;

/**
 * Represents the main browser window. 
 * 
 * You can retrieve the main browser window using
 * <code>iTunes.BrowserWindow()</code>.
 * 
 * @author <a href="mailto:steve@dot-totally.co.uk">Steve Eyre</a>
 * @version 0.2
 */

public class ITBrowserWindow extends ITWindow {
    
    public ITBrowserWindow (Dispatch d) {
        super(d);
    }
    
    /**
     * Returns the kind of the object.
     * @return Returns the kind of the object.
     */
    public boolean getMiniPlayer() {
        return Dispatch.get(object, "MiniPlayer").getBoolean();
    }

	// TODO: Comments
    
    public ITTrackCollection getSelectedTracks() {
        Dispatch collection = Dispatch.call(object, "SelectedTracks").getDispatch();
        return new ITTrackCollection(collection);
    }

    public ITPlaylist getSelectedPlaylist() {
        Dispatch playlist = Dispatch.get(object, "SelectedPlaylist").toDispatch();
        return new ITPlaylist(playlist);
    }

    public void setSelectedPlaylist(ITPlaylist playlist) {
    	Dispatch dispatchRef = playlist.fetchDispatch();
        Dispatch.put(object, "SelectedPlaylist", dispatchRef);
    }

}
