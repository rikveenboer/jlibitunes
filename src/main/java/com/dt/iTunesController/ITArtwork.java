package com.dt.iTunesController;
import com.jacob.com.Dispatch;

/**
 * Represents a artwork.
 * 
 * Defines a single piece of artwork. 
 * 
 * Artwork is always associated with an individual track.
 * To add a piece of artwork to a track, use IITTrack::AddArtworkFromFile(). 
 * The IITTrack::Artwork property  
 * 
 * To get a collection of artwork associated with a track call
 * <code>ITTrack.getArtwork()</code>.
 * 
 * @author <a href="mailto:steve@dot-totally.co.uk">Steve Eyre</a>
 * @version 0.2
 */
public class ITArtwork extends ITObject {
    
    public ITArtwork (Dispatch d) {
        super(d);
    }
    
    /**
     * Delete this object.
     */
    public void delete() {
        Dispatch.call(object, "Delete");
    }
    
    /**
     * Returns the kind of the object.
     * @return Returns the kind of the object.
     */
    public ITArtworkFormat getFormat() {
        return ITArtworkFormat.values()[Dispatch.get(object, "Format").getInt()];
    }

	// TODO: Comments
    
    public boolean getIsDownloadedArtwork() {
        return Dispatch.get(object, "IsDownloadedArtwork").getBoolean();
    }
    
    public String getDescription() {
        return Dispatch.get(object, "Description").getString();
        
    }
    
    public void SaveArtworkToFile(String filePath) {
        Dispatch.call(object, "SaveArtworkToFile",filePath);
    }   
}
