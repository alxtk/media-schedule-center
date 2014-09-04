package com.mediaserver.domain;

import javax.persistence.*;
import java.util.List;

public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @Column
    private String title;

    @Column
    private String type;

    @ManyToMany
    @JoinTable(name = "playlist_files",
            joinColumns = @JoinColumn(name = "playlist_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "file_id", referencedColumnName = "id")
    )
    private List<ContentFile> files;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ContentFile> getFiles() {
        return files;
    }

    public void setFiles(List<ContentFile> files) {
        this.files = files;
    }
}
