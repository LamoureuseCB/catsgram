package com.practice.catsgram.controller;

import com.practice.catsgram.model.Post;
import com.practice.catsgram.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<Post> findAll(@RequestParam(value = "size") Integer size,
                              @RequestParam(value = "sort") String sort,
                              @RequestParam(value = "page") Integer page) {
        int from = page * size;// нашла в интернете формулу расчета пагинации,
//        page — номер страницы (начиная с 0),
//        size — количество элементов на странице

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
