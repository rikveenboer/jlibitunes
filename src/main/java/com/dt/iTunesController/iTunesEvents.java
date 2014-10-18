package com.dt.iTunesController;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 * This class is used to forward all iTunes COM Events to a class that
 * implements <code>iTunesEventsInterface</code>. To receive events, create
 * a class that implements the interface, and then use
 * <code>iTunes.addEventHandler()</code>.
 * 
 * @author <a href="mailto:steve@dot-totally.co.uk">Steve Eyre</a>
 * @version 0.2
 */
public class iTunesEvents {
    
    private iTunesEventsInterface eventHandler;
    
    public iTunesEvents (iTunesEventsInterface itef) {
        eventHandler = itef;
    }
    
    public void OnDatabaseChangedEvent(Variant[] args) {
        // Not currently implemented
    }

    public void OnPlayerPlayEvent(Variant[] args) {
        ITTrack itt = new ITTrack((Dispatch)args[0].getDispatch());
        eventHandler.onPlayerPlayEvent(itt);
    }

    public void OnPlayerStopEvent(Variant[] args) {
        ITTrack itt = new ITTrack((Dispatch)args[0].getDispatch());
        eventHandler.onPlayerStopEvent(itt);
    }

    public void OnPlayerPlayingTrackChangedEvent(Variant[] args) {
        ITTrack itt = new ITTrack((Dispatch)args[0].getDispatch());
        eventHandler.onPlayerPlayingTrackChangedEvent(itt); 
    }
    
    public void OnCOMCallsDisabledEvent(Variant[] args) {
        ITCOMDisabledReason reason = ITCOMDisabledReason.values()[args[0].getInt()];
        eventHandler.onCOMCallsDisabledEvent(reason);
    }
    
    public void OnCOMCallsEnabledEvent(Variant[] args) {
        eventHandler.onCOMCallsEnabledEvent();
    }
    
    public void OnQuittingEvent(Variant[] args) {
        eventHandler.onQuittingEvent();
    }
    
    public void OnAboutToPromptUserToQuitEvent(Variant[] args) {
        eventHandler.onAboutToPromptUserToQuitEvent();
    }
    
    public void OnSoundVolumeChangedEvent(Variant[] args) {
        eventHandler.onSoundVolumeChangedEvent(args[0].getInt());
    }

}
