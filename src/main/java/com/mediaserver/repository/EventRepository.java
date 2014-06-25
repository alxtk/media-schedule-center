package com.mediaserver.repository;

import com.mediaserver.domain.Event;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository {

    List<Event> findAllEvents();

    List<Event> findEventsBetween(LocalDateTime startDate, LocalDateTime endDate);

    Event findEvent(long id);

    void createEvent(Event event);

    void updateEvent(Event event);

    void deleteEvent(Event event);

    void deleteEvent(long id);

}
