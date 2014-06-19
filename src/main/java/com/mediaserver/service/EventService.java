package com.mediaserver.service;

import com.mediaserver.domain.Event;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EventService {

    List<Event> getEvents();

}
