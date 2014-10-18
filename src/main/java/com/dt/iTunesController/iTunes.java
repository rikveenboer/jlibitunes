package com.dt.iTunesController;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.DispatchEvents;

/**
 * Defines the top-level iTunes application object.
 * 
 * This interface defines the top-level iTunes application object. All other
 * iTunes interfaces are accessed through this object.
 * 
 * @author <a href="mailto:steve@dot-totally.co.uk">Steve Eyre</a>
 * @version 0.2
 */
public class iTunes {
    ActiveXComponent iTunes;
    iTunesEvents iTunesEvents;
    DispatchEvents dispatchEvents;
   
    /**
     * Initiate iTunes Controller.
     * @return 
     */
    public void connect() {
        iTunes = new ActiveXComponent("iTunes.Application");
    }

    /**
     * Add an event handler to the iTunes controller.
     * @param itef The class that will handle the iTunes events.
     */
    public void addEventHandler(iTunesEventsInterface itef) {
        iTunesEvents = new iTunesEvents(itef);
        dispatchEvents = new DispatchEvents(iTunes, iTunesEvents);
        //System.out.println("New event handler added.");
    }
    
    /**
     * Reposition to the beginning of the current track or go to the previous
     * track if already at start of current track.
     */
    public void backTrack() {
        iTunes.invoke("BackTrack");
    }
    
    /**
     * Skip forward in a playing track.
     */
    public void fastForward() {
        iTunes.invoke("FastForward");
    }
    
    /**
     * Advance to the next track in the current playlist.
     */
    public void nextTrack() {
        iTunes.invoke("NextTrack");
    }
    
    /**
     * Pause playback.
     */
    public void pause() {
        iTunes.invoke("Pause");
    }
    
    /**
     * Play the currently targeted track.
     */
    public void play() {
        iTunes.invoke("ASDSDPlay");
    }
    
    /**
     * Play the specified file path, adding it to the library if not already
     * present.
     */
    public void playFile(String filePath) {
        iTunes.invoke("PlayFile", filePath);
    }
    
    /**
     * Toggle the playing/paused state of the current track.
     */
    public void playPause() {
        iTunes.invoke("PlayPause");
    }
    
    /**
     * Return to the previous track in the current playlist.
     */
    public void previousTrack() {
        iTunes.invoke("PreviousTrack");
    }
    
    /**
     * Disable fast forward/rewind and resume playback, if playing.
     */
    public void resume() {
        iTunes.invoke("Resume");
    }
    
    /**
     * Skip backwards in a playing track.
     */
    public void rewind() {
        iTunes.invoke("Rewind");
    }
    
    /**
     * Stop playback.
     */
    public void stop() {
        iTunes.invoke("Stop");
    }
    
    /**
     * Retrieves the current state of the player buttons in the window
     * containing the currently targeted track. If there is no currently
     * targeted track, returns the current state of the player buttons
     * in the main browser window.
     */
    public void getPlayerButtonsState(boolean previousEnabled,
            String playPause, boolean nextEnabled) {
        
    }
    
    /**
     * Returns true if this version of the iTunes type library is compatible
     * with  the specified version.
     * @param majorVersion Major version of iTunes interface. 
     * @param minorVersion Minor version of iTunes interface. 
     * @return Returns true if this version is compatible with the indicated
     * interface version.
     */
    public boolean getCheckVersion (int majorVersion, int minorVersion) {
        return iTunes.invoke("CheckVersion", majorVersion, minorVersion).getBoolean();
    }
    
    /**
     * Returns an IITObject corresponding to the specified IDs.
     * The object may be a source, playlist, or track.
     * @param sourceID The ID that identifies the source. Valid for a source,
     * playlist, or track.
     * @param playlistID The ID that identifies the playlist. Valid for a
     * playlist or track. Must be zero for a source.
     * @param trackID The ID that identifies the track within the playlist.
     * Valid for a track. Must be zero for a source or playlist.
     * @param databaseID The ID that identifies the track, independent of its
     * playlist. Valid for a track. Must be zero for a source or playlist.
     * @return Returns an IITObject object corresponding to the specified IDs.
     * Will be set to NULL if no object could be retrieved.
     */
    public ITObject getITObjectByID(int sourceID, int playlistID, int trackID, int databaseID) {
        Dispatch object = Dispatch.call(iTunes, "GetITObjectByID", sourceID, playlistID, trackID, databaseID).toDispatch();
        return new ITObject(object);
    }
    
    /**
     * Creates a new playlist in the main library.
     * @param playlistName The name of the new playlist (may be empty).
     * @return Returns an ITPlaylist object corresponding to the new playlist.
     */
    public ITPlaylist createPlaylist(String playlistName) {
        Dispatch cplaylist = Dispatch.call(iTunes, "CreatePlaylist", playlistName).toDispatch();
        ITPlaylist playlist = new ITPlaylist(cplaylist);
        ITPlaylistKind playlistKind = playlist.getKind();
        if (playlistKind == ITPlaylistKind.ITPlaylistKindCD)
            return new ITAudioCDPlaylist(cplaylist);
        else if (playlist.getKind() == ITPlaylistKind.ITPlaylistKindLibrary)
            return new ITLibraryPlaylist(cplaylist);
        else if (playlist.getKind() == ITPlaylistKind.ITPlaylistKindUser)
            return new ITUserPlaylist(cplaylist);
        else
            return playlist;
    }
    
    /**
     * Open the specified iTunes Store or streaming audio URL.
     * @param url The URL to open. The length of the URL cannot exceed 512
     * characters. iTunes Store URLs start with itms:// or itmss://. Streaming
     * audio URLs start with http://.
     */
    public void openURL (String url) {
        iTunes.invoke("OpenURL", url);
    }
    
    /**
     * Go to the iTunes Store home page.
     */
    public void gotoMusicStoreHomePage() {
        iTunes.invoke("GoToMusicStoreHomePage");
    }
    
    /**
     * Update the contents of the iPod.
     */
    public void updateIPod() {
        iTunes.invoke("UpdateIPod");
    }
    
    /**
     * Exits the iTunes application.
     */
    public void quit() {
        iTunes.invoke("Quit");
    }
    
    /**
     * Creates a new EQ preset.
     * The EQ preset will be created "flat", i.e. the preamp and all band levels
     * will be set to 0.
     * EQ preset names cannot start with leading spaces. If you specify a name
     * that starts with leading spaces they will be stripped out.
     * If <code>eqPresetName</code> is empty, the EQ preset will be created with
     * a default name. 
     * @param eqPresetName The name of the new EQ Preset (may be empty)
     * @return Returns an ITEQPreset object corresponding to the new EQ Preset.
     */
    public ITEQPreset createEQPreset(String eqPresetName) {
        Dispatch eqPreset = Dispatch.call(iTunes, "CreateEQPreset", eqPresetName).toDispatch();
        return new ITEQPreset(eqPreset);
    }
    
    /**
     * Creates a new playlist in an existing source.
     * You may not be able to create a playlist in every source. For example,
     * you cannot create a playlist in an audio CD source, or in an iPod source
     * if it is in auto update mode.
     * If <code>playlistName</code> is empty, the playlist will be created with
     * a default name.
     * @param playlistName The name of the new playlist (may be empty).
     * @param source The source that will contain the new playlist.
     * @return Returns an ITPlaylist object corresponding to the new playlist.
     */
    public ITPlaylist createPlaylistInSource(String playlistName, ITSource source) {
        Dispatch cplaylist = Dispatch.call(iTunes, "CreatePlaylistInSource", playlistName, source.fetchDispatch()).toDispatch();
        ITPlaylist playlist = new ITPlaylist(cplaylist);
        ITPlaylistKind playlistKind = playlist.getKind();
        if (playlistKind == ITPlaylistKind.ITPlaylistKindCD)
            return new ITAudioCDPlaylist(cplaylist);
        else if (playlist.getKind() == ITPlaylistKind.ITPlaylistKindLibrary)
            return new ITLibraryPlaylist(cplaylist);
        else if (playlist.getKind() == ITPlaylistKind.ITPlaylistKindUser)
            return new ITUserPlaylist(cplaylist);
        else
            return playlist;
    }
    
    /**
     * Subscribes to the specified podcast feed URL. Any "unsafe" characters in
     * the URL should already be converted into their corresponding escape
     * sequences, iTunes will not do this.
     * @param url The URL to subscribe to.
     */
    public void subscribeToPodcast(String url) {
        iTunes.invoke("SubscribeToPodcast", url);
    }
    
    /**
     * Updates all podcast feeds. This is equivalent to the user pressing the
     * Update button when Podcasts is selected in the Source list.
     */
    public void updatePodcastFeeds() {
        iTunes.invoke("UpdatePodcastFeeds");
    }
    
    /**
     * Creates a new folder in the main library.
     * If <code>folderName</code> is empty, the folder will be created with a
     * default name.
     * @param folderName The name of the new folder (may be empty).
     * @return Returns an ITPlaylist object corresponding to the new folder.
     */
    public ITUserPlaylist createFolder(String folderName) {
        Dispatch folder = Dispatch.call(iTunes, "CreateFolder", folderName).toDispatch();
        return new ITUserPlaylist(folder);
    }
    
    /**
     * Creates a new folder in an existing source. 
     * You may not be able to create a folder in every source. For example, you
     * cannot create a folder in an audio CD source, or in an iPod source if it
     * is in auto update mode.
     * If <code>folderName</code> is empty, the folder will be created with a
     * default name.
     * @param folderName The name of the new folder (may be empty)
     * @param iSource The source that will contain the new folder.
     * @return Returns an ITPlaylist object corresponding to the new folder.
     */
    public ITUserPlaylist createFolderInSource(String folderName, ITSource iSource) {
        Dispatch folder = Dispatch.call(iTunes, "CreateFolderInSource", folderName, iSource.fetchDispatch()).toDispatch();
        return new ITUserPlaylist(folder);
    }
    
    /**
     * Returns a collection of music sources (music library, CD, device, etc.).
     * @return Collection of ITSource objects.
     */
    public ITSourceCollection getSources() {
        Dispatch sources = Dispatch.call(iTunes, "Sources").toDispatch();
        return new ITSourceCollection(sources);
    }
    
    /**
     * Sets the sound output volume (0=minimum, 100=maximum).
     * @param volume New sound output volume
     */
    public void setSoundVolume(int volume) {
        iTunes.setProperty("SoundVolume", volume);
    }
    
    /**
     * Returns the sound output volume (0=minimum, 100=maximum).
     * @return Current sound output volume
     */
    public int getSoundVolume() {
        return iTunes.getPropertyAsInt("SoundVolume");
    }
    
    /**
     * Sets sound output mute state.
     * @param shouldMute If true, sound output will be muted.
     */
    public void setMute(boolean shouldMute) {
        iTunes.setProperty("Mute", shouldMute);
    }
    
    /**
     * Returns true if the sound output is muted.
     * @return True if sound output is muted.
     */
    public boolean getMute() {
        return iTunes.getPropertyAsBoolean("Mute");
    }

    /**
     * Toggle the mute state.
     */
    public void toggleMute() {
        setMute(!getMute());
    }

    /**
     * Toggle the shuffle state.
     */
    public void toggleShuffle() {
        getCurrentPlaylist().toggleShuffle();
    }

    /**
     * Returns the current player state.
     * @return Returns the current player state.
     */
    public ITPlayerState getPlayerState() {
        return ITPlayerState.values()[Dispatch.get(iTunes, "PlayerState").getInt()];
    }
    
    /**
     * Sets the player's position within the currently playing track in
     * seconds.
     * If playerPos specifies a position before the beginning of the track,
     * the position will be set to the beginning. If playerPos specifies a
     * position after the end of the track, the position will be set to the
     * end.
     * @param playerPos The player's position within the currently playing
     * track in seconds.
     */
    public void setPlayerPosition(int playerPos) {
        iTunes.setProperty("playerPosition", playerPos);
    }
    
    /**
     * Returns the player's position within the currently playing track in
     * seconds. 
     * @return The player's position within the currently playing track in
     * seconds.
     */
    public int getPlayerPosition() {
        return iTunes.getPropertyAsInt("playerPosition");
    }
    
    /**
     * Returns the source that represents the main library.
     * You can also find the main library source by iterating over
     * <code>iTunes.getSources()</code> and looking for an <code>ITSource</code>
     * of kind <code>ITSourceKindLibrary</code>.
     * @return Returns the source that represents the main  library.
     */
    public ITSource getLibrarySource() {
        Dispatch lsource = iTunes.getProperty("LibrarySource").toDispatch();
        return new ITSource(lsource);
    }
    
    /**
     * Returns the main library playlist in the main library source.
     * @return An IITLibraryPlaylist object corresponding to the main library
     * playlist.
     */
    public ITLibraryPlaylist getLibraryPlaylist() {
        Dispatch lplaylist = iTunes.getProperty("LibraryPlaylist").toDispatch();
        return new ITLibraryPlaylist(lplaylist);
    }
    
    /**
     * Returns the currently targetd track.
     * @return An ITTrack object corresponding to the currently targeted track.
     * Will be set to NULL if there is no currently targeted track.
     */
    public ITTrack getCurrentTrack() {
        Dispatch item = iTunes.getProperty("CurrentTrack").toDispatch();
        ITTrack track = new ITTrack(item);
        if (track.getKind()==ITTrackKind.ITTrackKindFile) {
        	return new ITFileOrCDTrack(item);
        } else if (track.getKind()==ITTrackKind.ITTrackKindCD) {
            	return new ITFileOrCDTrack(item);
        } else if (track.getKind()==ITTrackKind.ITTrackKindURL ) {
        	return new ITURLTrack(item);
        } else {
        	return track;
		}
    }
    
    /**
     * Returns the playlist containing the currently targeted track.
     * @return An ITPlaylist object corresponding to the playlist containing the
     * currently targeted track.
     * Will be set to NULL if there is no currently targeted playlist.
     */
    public ITPlaylist getCurrentPlaylist() {
        Dispatch cplaylist = iTunes.getProperty("CurrentPlaylist").toDispatch();
        ITPlaylist playlist = new ITPlaylist(cplaylist);
        ITPlaylistKind playlistKind = playlist.getKind();
        if (playlistKind == ITPlaylistKind.ITPlaylistKindCD)
            return new ITAudioCDPlaylist(cplaylist);
        else if (playlist.getKind() == ITPlaylistKind.ITPlaylistKindLibrary)
            return new ITLibraryPlaylist(cplaylist);
        else if (playlist.getKind() == ITPlaylistKind.ITPlaylistKindUser)
            return new ITUserPlaylist(cplaylist);
        else
            return playlist;
    }
    
    /**
     * Returns a collection containing the currently selected track or tracks. 
     * The frontmost visible window in iTunes must be a browser or playlist
     * window. If there is no frontmost visible window (e.g. iTunes is minimized
     * to the system tray), the main browser window is used.
     * @return Collection of ITrack objects.
     * Will be set to NULL if there is no current selection.
     */
    public ITTrackCollection getSelectedTracks() {
        Dispatch stracks = iTunes.getProperty("SelectedTracks").toDispatch();
        return new ITTrackCollection(stracks);
    }
    
    /**
     * Returns the version of the iTunes application.
     * @return
     */
    public String getVersion() {
        return iTunes.getPropertyAsString("Version");
    }

    /**
     * Returns the high 32 bits of the persistent ID of the specified IITObject.
     * See the documentation on IITObject for more information on persistent
     * IDs.
     *
     * The object may be a source, playlist, or track.
     * @param iObject The object to fetch the High Persistent ID.
     * @return The high 32 bits of the 64-bit persistent ID.
     */
    public long getITObjectPersistentIDHigh (ITObject iObject) {
        Dispatch object = iObject.fetchDispatch();
        return Dispatch.call(object, "GetObjectPersistentIDHigh", object).getLong();
    }

    /**
     * Returns the low 32 bits of the persistent ID of the specified IITObject.
     * See the documentation on IITObject for more information on persistent
     * IDs.
     *
     * The object may be a source, playlist, or track.
     * @param iObject The object to fetch the Low Persistent ID.
     * @return The low 32 bits of the 64-bit persistent ID.
     */
    public long getITObjectPersistentIDLow (ITObject iObject) {
        Dispatch object = iObject.fetchDispatch();
        return Dispatch.call(object, "GetObjectPersistentIDLow", object).getLong();
    }
    
    public ITObjectPersistentID getObjectPersistentIDs(ITObject iObject){
    	return new ITObjectPersistentID(getITObjectPersistentIDHigh(iObject),getITObjectPersistentIDLow(iObject));
    }

    public ITBrowserWindow getBrowserWindow(){
        Dispatch window = iTunes.getProperty("BrowserWindow").toDispatch();
    	return new ITBrowserWindow(window);
    }

    public void cycleSongRepeat() {
        getCurrentPlaylist().cycleSongRepeat();
    }

    public ITPlaylist getPlaylist(String name) {
        ITPlaylistCollection playlistCollection = getLibrarySource().getPlaylists();
        ITPlaylist playlist = playlistCollection.ItemByName(name);
        try {
            playlist.getName();
        } catch (IllegalStateException e) {
            playlist = createPlaylist(name);
        }
        return playlist;
    }

    public ITUserPlaylist getUserPlaylist(String name) {
        ITPlaylist playlist = getPlaylist(name);
        ITUserPlaylist userPlaylist = new ITUserPlaylist(playlist.fetchDispatch());
        return userPlaylist;
    }

    public void playlistAddTrack(String name, ITTrack track) {
        ITUserPlaylist userPlaylist = getUserPlaylist(name);
        if (!userPlaylist.containsTrack(track)) {
            userPlaylist.addTrack(track);
        }
    }

    public void playlistAddCurrentTrack(String name) {
        playlistAddTrack(name, getCurrentTrack());
    }

    public void release() {
        ComThread.Release();
    }
}
