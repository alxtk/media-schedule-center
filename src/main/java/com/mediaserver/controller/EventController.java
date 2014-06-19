package com.mediaserver.controller;

import com.mediaserver.domain.Event;
import com.mediaserver.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping("/all")
    @ResponseBody
    public List<Event> getEventList() {
        return eventService.getEvents();
    }

}
