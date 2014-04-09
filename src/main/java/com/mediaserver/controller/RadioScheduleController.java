package com.mediaserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/radio")
public class RadioScheduleController {

    @RequestMapping("/")
    public String home() {
        return "radio-schedule";
    }

}
