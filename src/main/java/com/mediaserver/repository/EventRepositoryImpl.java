package com.mediaserver.repository;

import com.mediaserver.domain.Event;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventRepositoryImpl implements EventRepository{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Event> getAllEvents() {
        return sessionFactory.openSession().createCriteria(Event.class).list();
    }

}
