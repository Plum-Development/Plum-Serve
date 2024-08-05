package org.plumdev.serve.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "media_items")
public class MediaItem {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String type;

    private String url;

    public MediaItem() {}

    public MediaItem(String title, String type, String url) {
        this.title = title;
        this.type = type;
        this.url = url;
    }

    public MediaItem setType(String type) {
        this.type = type;
        return this;
    }

    public MediaItem setId(Integer id) {
        this.id = id;
        return this;
    }

    public MediaItem setTitle(String title) {
        this.title = title;
        return this;
    }

    public MediaItem setUrl(String url) {
        this.url = url;
        return this;
    }
}
