package org.plumdev.serve.services;

import org.plumdev.serve.entities.MediaItem;
import org.plumdev.serve.repositories.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MediaService {
    private final MediaRepository mediaRepository;

    @Autowired
    public MediaService(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    @Transactional
    public MediaItem createMediaItem(String title, String type, String url) {
        return mediaRepository.save(new MediaItem(title, type, url));
    }

    public List<MediaItem> getAll() {
        return StreamSupport.stream(
                mediaRepository.findAll().spliterator(),
                false
                )
                .collect(Collectors.toList());
    }

    public Optional<MediaItem> getById(Integer mediaItemId) {
        return mediaRepository.findById(mediaItemId);
    }

    public List<MediaItem> getAllByType(String type) {
        return mediaRepository.findAllByType(type);
    }
}
