package org.plumdev.serve.repositories;

import java.util.List;
import org.plumdev.serve.entities.MediaItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaRepository extends CrudRepository<MediaItem, Integer> {
    List<MediaItem> findAllByType(String type);
}
