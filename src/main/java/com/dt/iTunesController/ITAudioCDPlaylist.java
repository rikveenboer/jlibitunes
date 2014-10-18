package com.dt.iTunesController;
import com.jacob.com.Dispatch;

/**
 * Represents an audio CD playlist.
 *
 * An audio CD playlist is always associated with an IITSource of kind
 * ITSourceKindAudioCD.
 *
 * You can retrieve all the playlists defined for a source using
 * <code>ITSource.getPlaylists()</code>.
 * @author <a href="mailto:steve@dot-totally.co.uk">Steve Eyre</a>
 * @version 0.2
 */
public class ITAudioCDPlaylist extends ITPlaylist {

    public ITAudioCDPlaylist(Dispatch d) {
        super(d);
    }

    /**
     * Returns the audio CD's artist.
     * @return Returns the audio CD's artist.
     */
    public String getArtist() {
        return Dispatch.get(object, "Artist").getString();
    }

    /**
     * Returns true if this audio CD is a compilation album.
     * @return Returns true if this audio CD is a compilation album.
     */
    public boolean isCompilation() {
        return Dispatch.get(object, "Compilation").getBoolean();
    }

    /**
     * Returns the audio CD's composer.
     * @return Returns the audio CD's composer.
     */
    public String getComposer() {
        return Dispatch.get(object, "Composer").getString();
    }

    /**
     * Returns the total number of discs in this CD's album.
     * @return Returns the total number of discs in this CD's album.
     */
    public long getDiscCount() {
        return Dispatch.get(object, "DiscCount").getLong();
    }

    /**
     * Returns the index of the CD disc in the source album.
     * @return Returns the index of the CD disc in the source album.
     */
    public long getDiscNumber() {
        return Dispatch.get(object, "DiscNumber").getLong();
    }

    /**
     * Returns the audio CD's genre.
     * @return Returns the audio CD's genre.
     */
    public String getGenre() {
        return Dispatch.get(object, "Genre").getString();
    }

    /**
     * Reveals the CD playlist in the main browser window.
     */
    public void reveal() {
        Dispatch.call(object, "Reveal");
    }

}
