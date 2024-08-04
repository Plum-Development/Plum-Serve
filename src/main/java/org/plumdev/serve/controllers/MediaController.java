package org.plumdev.serve.controllers;

import org.plumdev.serve.entities.MediaItem;
import org.plumdev.serve.services.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/media")
public class MediaController {
    private final MediaService mediaService;

    @Autowired
    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @GetMapping(produces = "application/json")
    public List<MediaItem> getAllMediaItems() {
        return mediaService.getAll();
    }

    @GetMapping(name = "/{id}", produces = "application/json")
    public MediaItem getMediaItemById(@PathVariable int id) throws Exception {
        return mediaService.getById(id).orElseThrow(() -> new Exception("Media item not found"));
    }

    @PostMapping(consumes = "application/json")
    public void addMediaItem(@RequestBody MediaItem mediaItem) {
        mediaService.createMediaItem(
                mediaItem.getTitle(),
                mediaItem.getType(),
                mediaItem.getUrl()
        );
    }
}
