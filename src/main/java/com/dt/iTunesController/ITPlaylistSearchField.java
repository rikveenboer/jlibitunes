package com.dt.iTunesController;

/**
 * Specifies the fields in each track that will be searched by
 * <code>ITPlaylist.search()</code>.
 * @author <a href="mailto:steve@dot-totally.co.uk">Steve Eyre</a>
 * @version 0.2
 */
public enum ITPlaylistSearchField {
    ITPlaylistSearchFieldAll,
    ITPlaylistSearchFieldVisible,
    ITPlaylistSearchFieldArtists,
    ITPlaylistSearchFieldAlbums,
    ITPlaylistSearchFieldComposers,
    ITPlaylistSearchFieldSongNames;
}
