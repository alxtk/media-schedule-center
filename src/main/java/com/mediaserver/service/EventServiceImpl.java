package com.mediaserver.service;

import com.google.common.collect.Lists;
import com.mediaserver.domain.Event;
import com.mediaserver.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository repository;

    @Override
    public List<Event> getEvents() {
        return Lists.newArrayList(repository.getAllEvents());
    }
}
