package com.mediaserver.service;

import com.mediaserver.domain.ContentFile;

import java.util.List;

public interface ContentFileService {

    List<ContentFile> getContentFiles();

    List<ContentFile> getContentFiles(String path);

    ContentFile getContentFile(long id);

    void updateContentFile(ContentFile file);

    void createContentFile(ContentFile file);

    void deleteContentFile(ContentFile file);

    void deleteContentFile(long id);

}
