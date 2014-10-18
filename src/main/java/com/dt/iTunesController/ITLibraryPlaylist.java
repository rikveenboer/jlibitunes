package com.dt.iTunesController;
import com.jacob.com.Dispatch;

/**
 * Represents a library playlist.
 *
 * A library playlist consists of all the tracks in a user's library.
 *
 * For convenience, you can retrieve the main library playlist using
 * <code>iTunes.getLibraryPlaylist()</code>.
 * @author <a href="mailto:steve@dot-totally.co.uk">Steve Eyre</a>
 * @version 0.2
 */
public class ITLibraryPlaylist extends ITPlaylist {

    public ITLibraryPlaylist(Dispatch d) {
        super(d);
    }

}
