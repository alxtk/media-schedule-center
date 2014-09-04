package com.mediaserver.repository;

import com.mediaserver.domain.Playlist;

import java.util.List;

public interface PlaylistRepository {

    List<Playlist> findAllPlaylists();

    void createPlaylist(Playlist playlist);

    void updatePlaylist(Playlist playlist);

    void deletePlaylist(Playlist playlist);

    void deletePlaylist(long id);

}
