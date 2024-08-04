package org.plumdev.serve.repositories;

import org.plumdev.serve.entities.MediaItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediaRepository extends CrudRepository<MediaItem, Integer> {
    List<MediaItem> findAllByType(String type);
}
