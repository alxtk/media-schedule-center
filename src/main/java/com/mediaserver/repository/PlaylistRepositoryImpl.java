package com.mediaserver.repository;

import com.mediaserver.domain.Playlist;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaylistRepositoryImpl implements PlaylistRepository{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Playlist> findAllPlaylists() {
        return sessionFactory.getCurrentSession().createCriteria(Playlist.class).list();
    }

    @Override
    public void createPlaylist(Playlist playlist) {
        sessionFactory.getCurrentSession().save(playlist);
    }

    @Override
    public void updatePlaylist(Playlist playlist) {
        sessionFactory.getCurrentSession().update(playlist);
    }

    @Override
    public void deletePlaylist(Playlist playlist) {
        sessionFactory.getCurrentSession().delete(playlist);
    }

    @Override
    public void deletePlaylist(long id) {
        Playlist playlist = new Playlist();
        playlist.setId(id);
        deletePlaylist(playlist);
    }
}
