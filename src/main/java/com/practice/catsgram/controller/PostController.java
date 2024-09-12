package com.practice.catsgram.controller;

import com.practice.catsgram.model.Post;
import com.practice.catsgram.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

  private final PostService postService;

    @GetMapping("/posts")
    public List<Post> findAll(@RequestParam String sort,
                              @RequestParam int page,
                              @RequestParam int size) {

        return postService.findAll(sort,size,page);
    }


    @PostMapping(value = "/post")
    public Post create(@RequestBody Post post) {
       return postService.create(post);
    }
    @GetMapping("/posts/{postId}")
    public Post getPostById(@PathVariable int postId) {
        return postService.getPostById(postId);
    }
}
