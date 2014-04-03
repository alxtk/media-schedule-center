package com.mediaserver.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.Map;

@Controller
@EnableAutoConfiguration
@ComponentScan({
        "com.mediaserver",
        "com.mediaserver.controller"})
public class MainController {

    @RequestMapping("/")
    @ResponseBody
    public Map<String, String> helloWorld() {
        return Collections.singletonMap("message", "Hello World");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainController.class, args);
    }

};