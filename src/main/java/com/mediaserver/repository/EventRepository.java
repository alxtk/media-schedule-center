package com.mediaserver.repository;

import com.mediaserver.domain.Event;

import java.util.List;

public interface EventRepository {

    List<Event> getAllEvents();

}
