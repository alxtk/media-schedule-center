package com.mediaserver.controller;

import com.mediaserver.domain.ContentFile;
import com.mediaserver.service.ContentFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/files")
public class ContentFileController {

    @Autowired
    private ContentFileService service;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<ContentFile> getContentFiles() {
        return service.getContentFiles();
    }

    @RequestMapping(value = "find", method = RequestMethod.GET)
    @ResponseBody
    public List<ContentFile> getContentFilesByPath(@RequestParam String path) {
        return service.getContentFiles(path);
    }

    @RequestMapping(value = "/{id}")
    @ResponseBody
    public ContentFile getContentFile(@PathVariable long id) {
        return service.getContentFile(id);
    }

}
