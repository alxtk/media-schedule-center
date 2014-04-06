package com.mediaserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.Map;

@Controller
public class MainController {

    @RequestMapping("/json")
    @ResponseBody
    public Map<String, String> helloWorld() {
        return Collections.singletonMap("message", "Hello World");
    }

    @RequestMapping("/")
    public String home() {
        //System.out.println(!ftpServer.isStopped());
        return "index";
    }

}