package com.mediaserver.repository;

import com.mediaserver.domain.ContentFile;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContentFileRepositoryImpl implements ContentFileRepository{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<ContentFile> findAllContentFiles() {
        return sessionFactory.getCurrentSession().createCriteria(ContentFile.class).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ContentFile> findContentFilesInPath(String path) {
        return sessionFactory.getCurrentSession()
                .createCriteria(ContentFile.class)
                .add(Restrictions.like("path", path + '%'))
                .list();
    }

    @Override
    public ContentFile findContentFileById(long id) {
        return (ContentFile) sessionFactory.getCurrentSession().get(ContentFile.class, id);
    }

    @Override
    public void updateContentFile(ContentFile file) {
        sessionFactory.getCurrentSession().update(file);
    }

    @Override
    public void createContentFile(ContentFile file) {
        sessionFactory.getCurrentSession().save(file);
    }

    @Override
    public void deleteContentFile(ContentFile file) {
        sessionFactory.getCurrentSession().delete(file);
    }

    @Override
    public void deleteContentFile(long id) {
        ContentFile file = new ContentFile();
        file.setId(id);
        deleteContentFile(file);
    }
}
