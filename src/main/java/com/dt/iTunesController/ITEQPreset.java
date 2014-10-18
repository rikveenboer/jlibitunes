package com.dt.iTunesController;

import com.jacob.com.Dispatch;

/**
 * Represents an equalizer preset. 
 * You can retrieve or set the currently selected EQ preset using the
 * <code>iTunes.getCurrentEQPreset()<code> method. 
 * @author <a href="mailto:steve@dot-totally.co.uk">Steve Eyre</a>
 * @version 0.2
 */
public class ITEQPreset {
    
    protected Dispatch object;
    
    public ITEQPreset(Dispatch d) {
        object = d;
    }
    
    /**
     * Returns the name of the EQ Preset (e.g. "Acoustic").
     * @return Returns the name of the EQ Preset (e.g. "Acoustic").
     */
    public String getName() {
        return Dispatch.get(object, "Name").getString();
    }
    
    /**
     * Returns true if the EQ preset can be modified.
     * @return True if the EQ preset can be modified.
     */
    public boolean getModifiable() {
        return Dispatch.get(object, "Modifiable").getBoolean();
    }
    
    /**
     * Set the equalizer preamp level (-12.0 db to +12.0 db).
     * @param level The new equalizer preamp level (-12.0 db to +12.0 db).
     */
    public void setPreamp(double level) {
        Dispatch.put(object, "Preamp", level);
    }
    
    /**
     * Returns the equalizer preamp level (-12.0db to +12.0db).
     * @return Returns the equalizer preamp level (-12.0db to +12.0db).
     */
    public double getPreamp() {
        return Dispatch.get(object, "Preamp").getDouble();
    }

    /**
     * Set the equalizer 32Hz level (-12.0 db to +12.0 db).
     * @param level The new equalizer 32Hz level (-12.0 db to +12.0db).
     */
    public void setBand1(double level) {
        Dispatch.put(object, "Band1", level);
    }
 
    /**
     * Returns the equalizer 32Hz level (-12.0 db to +12.0 db).
     * @return Returns the equalizer 32Hz level (-12.0 db to +12.0 db).
     */
    public double getBand1() {
        return Dispatch.get(object, "Band1").getDouble();
    }
 
    /**
     * Set the equalizer 64Hz level (-12.0 db to +12.0 db).
     * @param level The new equalizer 64Hz level (-12.0 db to +12.0db).
     */
    public void setBand2(double level) {
        Dispatch.put(object, "Band2", level);
    }
 
    /**
     * Returns the equalizer 64Hz level (-12.0 db to +12.0 db).
     * @return Returns the equalizer 64Hz level (-12.0 db to +12.0 db).
     */
    public double getBand2() {
        return Dispatch.get(object, "Band2").getDouble();
    }
 
    /**
     * Set the equalizer 125Hz level (-12.0 db to +12.0 db).
     * @param level The new equalizer 125Hz level (-12.0 db to +12.0db).
     */
    public void setBand3(double level) {
        Dispatch.put(object, "Band3", level);
    }
 
    /**
     * Returns the equalizer 125Hz level (-12.0 db to +12.0 db).
     * @return Returns the equalizer 125Hz level (-12.0 db to +12.0 db).
     */
    public double getBand3() {
        return Dispatch.get(object, "Band3").getDouble();
    }
 
    /**
     * Set the equalizer 250Hz level (-12.0 db to +12.0 db).
     * @param level The new equalizer 250Hz level (-12.0 db to +12.0db).
     */
    public void setBand4(double level) {
        Dispatch.put(object, "Band4", level);
    }
 
    /**
     * Returns the equalizer 250Hz level (-12.0 db to +12.0 db).
     * @return Returns the equalizer 250Hz level (-12.0 db to +12.0 db).
     */
    public double getBand4() {
        return Dispatch.get(object, "Band4").getDouble();
    }
 
    /**
     * Set the equalizer 500Hz level (-12.0 db to +12.0 db).
     * @param level The new equalizer 500Hz level (-12.0 db to +12.0db).
     */
    public void setBand5(double level) {
        Dispatch.put(object, "Band5", level);
    }
 
    /**
     * Returns the equalizer 500Hz level (-12.0 db to +12.0 db).
     * @return Returns the equalizer 500Hz level (-12.0 db to +12.0 db).
     */
    public double getBand5() {
        return Dispatch.get(object, "Band5").getDouble();
    }
 
    /**
     * Set the equalizer 1KHz level (-12.0 db to +12.0 db).
     * @param level The new equalizer 1KHz level (-12.0 db to +12.0db).
     */
    public void setBand6(double level) {
        Dispatch.put(object, "Band6", level);
    }
 
    /**
     * Returns the equalizer 1KHz level (-12.0 db to +12.0 db).
     * @return Returns the equalizer 1KHz level (-12.0 db to +12.0 db).
     */
    public double getBand6() {
        return Dispatch.get(object, "Band6").getDouble();
    }
 
    /**
     * Set the equalizer 2KHz level (-12.0 db to +12.0 db).
     * @param level The new equalizer 2KHz level (-12.0 db to +12.0db).
     */
    public void setBand7(double level) {
        Dispatch.put(object, "Band7", level);
    }
 
    /**
     * Returns the equalizer 2KHz level (-12.0 db to +12.0 db).
     * @return Returns the equalizer 2KHz level (-12.0 db to +12.0 db).
     */
    public double getBand7() {
        return Dispatch.get(object, "Band7").getDouble();
    }
 
    /**
     * Set the equalizer 4KHz level (-12.0 db to +12.0 db).
     * @param level The new equalizer 4KHz level (-12.0 db to +12.0db).
     */
    public void setBand8(double level) {
        Dispatch.put(object, "Band8", level);
    }
 
    /**
     * Returns the equalizer 4KHz level (-12.0 db to +12.0 db).
     * @return Returns the equalizer 4KHz level (-12.0 db to +12.0 db).
     */
    public double getBand8() {
        return Dispatch.get(object, "Band8").getDouble();
    }
 
    /**
     * Set the equalizer 8KHz level (-12.0 db to +12.0 db).
     * @param level The new equalizer 8KHz level (-12.0 db to +12.0db).
     */
    public void setBand9(double level) {
        Dispatch.put(object, "Band9", level);
    }
 
    /**
     * Returns the equalizer 8KHz level (-12.0 db to +12.0 db).
     * @return Returns the equalizer 8KHz level (-12.0 db to +12.0 db).
     */
    public double getBand9() {
        return Dispatch.get(object, "Band9").getDouble();
    }
 
    /**
     * Set the equalizer 16KHz level (-12.0 db to +12.0 db).
     * @param level The new equalizer 16KHz level (-12.0 db to +12.0db).
     */
    public void setBand10(double level) {
        Dispatch.put(object, "Band10", level);
    }
 
    /**
     * Returns the equalizer 16KHz level (-12.0 db to +12.0 db).
     * @return Returns the equalizer 16KHz level (-12.0 db to +12.0 db).
     */
    public double getBand10() {
        return Dispatch.get(object, "Band10").getDouble();
    }
    
    /**
     * Delete this EQ Preset.
     * Any EQ preset can be deleted, including built-in presets, except for the
     * Manual preset.
     * @param updateAllTracks If true, any tracks that use this EQ preet will be
     * set to have no assigned EQ preset.
     */
    public void delete(boolean updateAllTracks) {
        Dispatch.call(object, "Delete", updateAllTracks);
    }
    
    /**
     * Rename this EQ Preset.
     * The name of any EQ preset can be changed, including built-in presets,
     * except for the Manual preset.
     * EQ preset names cannot start with leading spaces. If you specify a name
     * that starts with leading spaces they will be stripped out.
     * @param updateAllTracks If true, any tracks that use this EQ preet will be
     * updated with the new preset name.
     */
    public void rename(String newName, boolean updateAllTracks) {
        Dispatch.call(object, "Rename", newName, updateAllTracks);
    }
    
}
