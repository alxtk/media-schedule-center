package com.mediaserver.service;

import com.mediaserver.domain.Playlist;
import com.mediaserver.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    PlaylistRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Playlist> findAllPlaylists() {
        return repository.findAllPlaylists();
    }

    @Override
    @Transactional
    public void createPlaylist(Playlist playlist) {
        repository.createPlaylist(playlist);
    }

    @Override
    @Transactional
    public void updatePlaylist(Playlist playlist) {
        repository.updatePlaylist(playlist);
    }

    @Override
    @Transactional
    public void deletePlaylist(Playlist playlist) {
        repository.deletePlaylist(playlist);
    }

    @Override
    @Transactional
    public void deletePlaylist(long id) {
        repository.deletePlaylist(id);
    }

}
