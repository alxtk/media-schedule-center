package com.mediaserver.controller;

import com.mediaserver.domain.Playlist;
import com.mediaserver.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    PlaylistService playlistService;

    @RequestMapping(method = RequestMethod.GET)
    public String getPlaylistManagerView() {
        return "playlist-manager";
    }

    @RequestMapping("/edit/{playlistid}")
    public String getPlaylistEditorView(Model model, @PathVariable long playlistid) {
        model.addAttribute("PlaylistID", playlistid);
        return "playlist-edit";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    @ResponseBody
    public List<Playlist> getAllPlaylists() {
        return playlistService.findAllPlaylists();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> updatePlaylist(@RequestBody Playlist playlist) {
        if (playlist == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            playlistService.updatePlaylist(playlist);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
