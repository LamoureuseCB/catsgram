package com.practice.catsgram.controller;

import com.practice.catsgram.exceptions.IncorrectParameterException;
import com.practice.catsgram.model.Post;
import com.practice.catsgram.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.practice.catsgram.utils.Constants.SORTS;


@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<Post> findAll(@RequestParam(value = "size") Integer size,
                              @RequestParam(value = "sort") String sort,
                              @RequestParam(value = "page") Integer page) {
        if (!SORTS.contains(sort)) {
            throw new IncorrectParameterException("sort");
        }
        if (page < 0) {
            throw new IncorrectParameterException("page");
        }
        if (size <= 0) {
            throw new IncorrectParameterException("size");
        }
        int from = page * size;

        return postService.findAll(size, sort, from);
    }

    @PostMapping(value = "/post")
    public Post create(@RequestBody Post post) {
        return postService.create(post);
    }

    @GetMapping("/post/{postId}")
    public Post findPost(@PathVariable int postId) {
        return postService.findPostById(postId);
    }
}
