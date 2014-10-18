package com.dt.iTunesController;
import com.jacob.com.Dispatch;

/**
 * Represents an entry in the Source list (music library, CD, device, etc.).
 * You can retrieve all the sources using <code>iTunes.getSources()</code>.
 * @author <a href="mailto:steve@dot-totally.co.uk">Steve Eyre</a>
 * @version 0.2
 */
public class ITSource extends ITObject {
    
    public ITSource(Dispatch d) {
        super(d);
    }
    
    /**
     * Returns the kind of the source.
     * @return Returns the kind of the source.
     */
    public ITSourceKind getKind() {
        return ITSourceKind.values()[Dispatch.get(object, "Kind").getInt()];
    }
    
    /**
     * Returns the total size of the source, if it has a fixed size.
     * @return Returns the total size of the source, if it has a fixed size.
     */
    public double getCapacity() {
        return Dispatch.get(object, "Capacity").getDouble();
    }
    
    /**
     * Returns the free space on the source, if it has a fixed size.
     * @return Returns the free space on the source, if it has a fixed size.
     */
    public double getFreespace() {
        return Dispatch.get(object, "Freespace").getDouble();
    }

    /**
     * Returns a collection containing the playlists in this source.
     * The source's primary playlist is always the first playlist in the
     * collection.
     * @return Collection of IITPlaylist objects.
     */
    public ITPlaylistCollection getPlaylists() {
        Dispatch playlists = Dispatch.get(object, "Playlists").toDispatch();
        return new ITPlaylistCollection(playlists);
    }
    
}
