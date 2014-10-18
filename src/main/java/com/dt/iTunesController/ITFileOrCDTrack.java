package com.dt.iTunesController;
import com.jacob.com.Dispatch;

/**
 * Represents a file or CD track.
 * @author <a href="mailto:steve@dot-totally.co.uk">Steve Eyre</a>
 * @version 0.2
 */
public class ITFileOrCDTrack extends ITTrack {

    public ITFileOrCDTrack (Dispatch d) {
        super(d);
    }

    /**
     * Reveals the track in the main browser window.
     */
    public void reveal() {
        Dispatch.call(object, "Reveal");
    }

    public ITVideoKind getVideoKind() {
        return ITVideoKind.values()[Dispatch.get(object, "VideoKind").getInt()];
    }
    
    public ITRatingKind getRatingKind() {
        return ITRatingKind.values()[Dispatch.get(object, "RatingKind").getInt()];
    }

    public String getLocation() {
        return Dispatch.get(object, "Location").getString();
    }

    public ITArtworkCollection getArtworks() {
        Dispatch artworks = Dispatch.get(object, "Artwork").toDispatch();
        return new ITArtworkCollection(artworks);
    }

}
