package com.mediaserver.controller;

import com.mediaserver.entity.Platform;
import com.mediaserver.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/platforms")
public class PlatformsController {

    @Autowired
    private PlatformService platformService;

    @RequestMapping("/")
    public String home() {
        return "platforms";
    }

    @RequestMapping(value = "create/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Platform create(@RequestBody Platform smartphone) {
        return platformService.create(smartphone);
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Platform edit(@PathVariable int id,
                         @RequestBody Platform platform) {
        platform.setId(id);
        return platformService.update(platform);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Platform delete(@PathVariable int id) {
        return platformService.delete(id);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Platform> list() {
        return platformService.getAll();
    }
}