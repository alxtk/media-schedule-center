package com.mediaserver.repository;

import com.mediaserver.domain.Event;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository {

    List<Event> getAllEvents();

    List<Event> getEvents(LocalDateTime startDate, LocalDateTime endDate);

    Event getEvent(long id);

    void createEvent(Event event);

    void updateEvent(Event event);

    void deleteEvent(Event event);

    void deleteEventById(long id);

}
