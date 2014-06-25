package com.mediaserver.repository;

import com.mediaserver.domain.ContentFile;

import java.util.List;

public interface ContentFileRepository {

    List<ContentFile> findAllContentFiles();

    List<ContentFile> findContentFilesInPath(String path);

    ContentFile findContentFileById(long id);

    void updateContentFile(ContentFile file);

    void createContentFile(ContentFile file);

    void deleteContentFile(ContentFile file);

    void deleteContentFile(long id);

}
