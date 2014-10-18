package com.dt.iTunesController;
import com.jacob.com.Dispatch;

/**
 * Represents an iTunes window. 
 */

public class ITWindow {
    
    protected Dispatch object;
    
    public ITWindow(Dispatch d) {
        object = d;
    }
    
    /**
     * Returns the JACOB Dispatch object for this object.
     * @return Returns the JACOB Dispatch object for this object.
     */
    public Dispatch fetchDispatch() {
        return object;
    }
    
    /**
     * Returns the name of the object.
     * @return Returns the name of the object.
     */
    public String getName() {
        return Dispatch.get(object, "Name").getString();
    }
    
}
