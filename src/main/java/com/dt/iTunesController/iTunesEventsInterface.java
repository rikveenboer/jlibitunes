package com.dt.iTunesController;

/**
 * Interface for receiving iTunes events.
 * @author <a href="mailto:steve@dot-totally.co.uk">Steve Eyre</a>
 * @version 0.2
 */
public interface iTunesEventsInterface {
    
    /**
     * <strong>Not currently implemented</strong>.
     * 
     * The ITEventDatabaseChanged event is fired when the iTunes database is
     * changed.
     * 
     * Each parameter is a two-dimensional array of integers. The first
     * dimension is the number of objects. The second dimension is always 4 and
     * specifies each of the 4 ITObject IDs, where index 0 is the source ID,
     * index 1 is the playlist ID, index 2 is the track ID, and index 3 is the
     * track database ID. For more information on object IDs, see
     * <code>ITObject</code>.
     * 
     * Note that you can use <code>iTunes.getITObjectByID()</code> to retrieve
     * changed ITObject, but not for deleted objects (since they no longer
     * exist).
     * 
     * @param deletedObjectIDs
     * @param changedObjectIDs
     */
    public void onDatabaseChangedEvent(int[][] deletedObjectIDs, int[][] changedObjectIDs);
    
    /**
     * The ITEventPlayerPlay event is fired when a track begins playing.
     * @param iTrack An ITTrack object corresponding to the track that has
     * started playing.
     */
    public void onPlayerPlayEvent (ITTrack iTrack);
    
    /**
     * The ITEventPlayerStop event is fired when a track stops playing. 
     * @param iTrack An ITTrack object corresponding to the track that has
     * stopped playing.
     */
    public void onPlayerStopEvent (ITTrack iTrack);
    
    /**
     * The ITEventPlayerPlayingTrackChanged event is fired when information
     * about the currently playing track has changed. 
     * This event is fired when the user changes information about the currently
     * playing track (e.g. the name of the track).
     * This event is also fired when iTunes plays the next joined CD track in a
     * CD playlist, since joined CD tracks are treated as a single track.
     * @param iTrack An ITTrack object corresponding to the track that is now
     * playing. 
     */
    public void onPlayerPlayingTrackChangedEvent(ITTrack iTrack);
    
    /**
     * The ITEventCOMCallsDisabled event is fired when calls to the iTunes COM
     * interface will be deferred. 
     * Typically, iTunes will defer COM calls when any modal dialog is being
     * displayed. When the user dismisses the last modal dialog, COM calls will
     * be enabled again, and any deferred COM calls will be executed. You can
     * use this event to avoid making a COM call which will be deferred.
     * @param reason The reason the COM interface is being disabled. This is
     * typically <code>ITCOMDisabledReasonDialog</code>.
     */
    public void onCOMCallsDisabledEvent(ITCOMDisabledReason reason);
    
    /**
     * The ITEventCOMCallsEnabled event is fired when calls to the iTunes COM
     * interface will no longer be deferred. 
     * Typically, iTunes will defer COM calls when any modal dialog is being
     * displayed. When the user dismisses the last modal dialog, COM calls will
     * be enabled again, and any deferred COM calls will be executed.
     */
    public void onCOMCallsEnabledEvent();
    
    /**
     * The ITEventQuitting event is fired when iTunes is about to quit. 
     * If the user attempts to quit iTunes while a client still has outstanding
     * iTunes COM objects instantiated, iTunes will display a warning dialog.
     * The user can still choose to quit iTunes anyway, in which case this event
     * will be fired. After this event is fired, any existing iTunes COM objects
     * will no longer be valid.
     * This event is only used to notify clients that iTunes is quitting,
     * clients cannot prevent this from happening.
     */
    public void onQuittingEvent();
    
    /**
     * The ITEventAboutToPromptUserToQuit event is fired when iTunes is about
     * prompt the user to quit. 
     * This event gives clients the opportunity to prevent the warning dialog
     * prompt from occurring.
     * If the user attempts to quit iTunes while a client still has outstanding
     * iTunes COM objects instantiated, iTunes will display a warning dialog.
     * This event is fired just before the warning dialog is shown. iTunes will
     * then wait up to 5 seconds for clients to release any outstanding iTunes
     * COM objects. If all objects are released during this time, the warning
     * dialog will not be shown and iTunes will quit immediately.
     * Otherwise, the warning dialog will be shown. If the user chooses to quit
     * iTunes anyway, the ITEventQuitting event is fired. See
     * <code>iTunesEventsInterface.onQuittingEvent()</code> for more details.
     */
    public void onAboutToPromptUserToQuitEvent();
    
    /**
     * The ITEventSoundVolumeChanged event is fired when the sound output volume
     * has changed.
     * @param newVolume The new sound output volume (0 = minimum, 100 = maximum).
     */
    public void onSoundVolumeChangedEvent(int newVolume);

}
