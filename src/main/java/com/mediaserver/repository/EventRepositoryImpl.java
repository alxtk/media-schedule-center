package com.mediaserver.repository;

import com.mediaserver.domain.Event;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class EventRepositoryImpl implements EventRepository{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Event> getAllEvents() {
        return sessionFactory.getCurrentSession().createCriteria(Event.class).list();
    }

    @Override
    public List<Event> getEvents(LocalDateTime startDate, LocalDateTime endDate) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public Event getEvent(long id) {
        return (Event) sessionFactory.getCurrentSession().get(Event.class, id);
    }

    @Override
    public void createEvent(Event event) {
        sessionFactory.getCurrentSession().save(event);
    }

    @Override
    public void updateEvent(Event event) {
        sessionFactory.getCurrentSession().update(event);
    }

    @Override
    public void deleteEvent(Event event) {
        sessionFactory.getCurrentSession().delete(event);
    }

    @Override
    public void deleteEventById(long id) {
        Event deleteEvent = new Event();
        deleteEvent.setId(id);
        sessionFactory.getCurrentSession().delete(deleteEvent);
    }

}
