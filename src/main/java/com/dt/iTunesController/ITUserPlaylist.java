package com.dt.iTunesController;
import com.jacob.com.Dispatch;

/**
 * Represents a user-defined playlist.
 *
 * A user playlist includes both smart and manual user-defined playlists.
 * @author <a href="mailto:steve@dot-totally.co.uk">Steve Eyre</a>
 * @version 0.2
 */
public class ITUserPlaylist extends ITPlaylist {
    
    public ITUserPlaylist(Dispatch d) {
        super(d);
    }

    /**
     * Add a file or files inside a folder to the playlist.
     * You cannot use this method to add a file that requires conversion to be
     * added (e.g. a CD track), use <code>iTunes.convertFile()</code> or
     * <code>iTunes.convertFile2()</code> instead. If you add a folder that
     * contains files that require conversion, they will be skipped.
     * @param filePath The full path to the file or folder to add.
     * @return Returns an ITOperationStatus object corresponding to the
     * asynchronous operation. If an error occurs, or no files were added, this
     * will be set to <code>NULL</code>.
     */
    public ITOperationStatus addFile (String filePath) {
        Dispatch status = Dispatch.call(object, "AddFile", filePath).toDispatch();
        return new ITOperationStatus(status);
    }

    /**
     * Add a streaming audio URL to the playlist.
     * @param url The URL to add. The length of the URL can be 255 characters or
     * less.
     * @return Returns an ITURLTrack object corresponding to the new track.
     */
    public ITURLTrack addURL (String url) {
        Dispatch URLTrack = Dispatch.call(object, "AddURL", url).toDispatch();
        return new ITURLTrack(URLTrack);
    }

    /**
     * Add an existing track to the playlist.
     * You cannot use this method to add a CD track (ITTrackKindCD) to another
     * playlist, use <code>iTunes.convertTrack()</code> or
     * <code>iTunes.convertTrack2()</code> instead.
     * You cannot add a shared library track (ITTrackKindSharedLibrary) to
     * another playlist.
     * @param track The track to add.
     * @return Returns an IITTrack object corresponding to the new track.
     */
    public ITTrack addTrack (ITTrack track) {
        Dispatch trackToAdd = track.fetchDispatch();
        Dispatch addedTrack = Dispatch.call(object, "AddTrack", trackToAdd).toDispatch();
        return new ITTrack(addedTrack);
    }

}
