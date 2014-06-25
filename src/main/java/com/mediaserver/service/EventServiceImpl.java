package com.mediaserver.service;

import com.mediaserver.domain.Event;
import com.mediaserver.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Event> getEvents() {
        return repository.findAllEvents();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Event> getEvents(LocalDateTime startDate, LocalDateTime endDate) {
        return repository.findEventsBetween(startDate, endDate);
    }

    @Override
    @Transactional(readOnly = true)
    public Event getEvent(long id) {
        return repository.findEvent(id);
    }

    @Override
    @Transactional
    public void updateEvent(Event event) {
        repository.updateEvent(event);
    }

    @Override
    @Transactional
    public void createEvent(Event event) {
        repository.createEvent(event);
    }

    @Override
    @Transactional
    public void deleteEvent(Event event) {
        repository.deleteEvent(event);
    }

    @Override
    @Transactional
    public void deleteEvent(long id) {
        repository.deleteEvent(id);
    }
}
