package com.practice.catsgram.model;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter

public class Post {
    private int id;

    private final String author; // автор
    private final Instant creationDate = Instant.now(); // дата создания
    private String description; // описание
    private String photoUrl; // url-адрес фотографии

    public Post(String author, String description, String photoUrl, int id) {
        this.author = author;
        this.description = description;
        this.photoUrl = photoUrl;
        this.id = id;
    }


}