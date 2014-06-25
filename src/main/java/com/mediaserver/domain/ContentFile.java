package com.mediaserver.domain;

import javax.persistence.*;

@Entity(name = "files")
public class ContentFile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column
    private String path;

    @Column
    private String type;

    @Column(name = "content_type")
    private String contentType;

    @Column
    private long duration;

    @Column
    private String comment;

    public ContentFile() {
    }

    public ContentFile(long id, String path, String type, String contentType, long duration, String comment) {
        this.id = id;
        this.path = path;
        this.type = type;
        this.contentType = contentType;
        this.duration = duration;
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
