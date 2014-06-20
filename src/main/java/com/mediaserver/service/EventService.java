package com.mediaserver.service;

import com.mediaserver.domain.Event;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

public interface EventService {

    List<Event> getEvents();

    List<Event> getEvents(LocalDateTime startDate, LocalDateTime endDate);

    Event getEvent(long id);

    void updateEvent(Event event);

    void createEvent(Event event);

    void deleteEvent(Event event);

    void deleteEvent(long id);

}
