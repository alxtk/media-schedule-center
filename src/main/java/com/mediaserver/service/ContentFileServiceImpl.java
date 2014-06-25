package com.mediaserver.service;

import com.mediaserver.domain.ContentFile;
import com.mediaserver.repository.ContentFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContentFileServiceImpl implements ContentFileService{

    @Autowired
    private ContentFileRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<ContentFile> getContentFiles() {
        return repository.findAllContentFiles();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContentFile> getContentFiles(String path) {
        return repository.findContentFilesInPath(path);
    }

    @Override
    @Transactional(readOnly = true)
    public ContentFile getContentFile(long id) {
        return repository.findContentFileById(id);
    }

    @Override
    @Transactional
    public void updateContentFile(ContentFile file) {
        repository.updateContentFile(file);
    }

    @Override
    @Transactional
    public void createContentFile(ContentFile file) {
        repository.createContentFile(file);
    }

    @Override
    @Transactional
    public void deleteContentFile(ContentFile file) {
        repository.deleteContentFile(file);
    }

    @Override
    @Transactional
    public void deleteContentFile(long id) {
        repository.deleteContentFile(id);
    }
}
