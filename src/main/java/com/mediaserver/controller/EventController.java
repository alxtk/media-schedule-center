package com.mediaserver.controller;

import com.mediaserver.domain.Event;
import com.mediaserver.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Event> getEventList() {
        return eventService.getEvents();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Event getEventById(@PathVariable long id) {
        return eventService.getEvent(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> updateEvent(@RequestBody Event event) {
        if (event == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            eventService.updateEvent(event);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
