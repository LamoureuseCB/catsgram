package com.practice.catsgram.service;

import com.practice.catsgram.exceptions.InvalidEmailException;
import com.practice.catsgram.exceptions.UserNotFoundException;
import com.practice.catsgram.model.Post;
import com.practice.catsgram.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final UserService userService;
    private List<Post> posts = new ArrayList<>();

    public List<Post> findAll() {
        return posts;
    }

    public Post create(Post post) {
        String authorsEmail = post.getAuthor();
        if (authorsEmail == null || authorsEmail.isBlank()) {
            throw new InvalidEmailException("Почтовый адрес автора не указан");
        }
        User user = userService.findUserByEmail(authorsEmail);
        if (user == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        posts.add(post);
        return post;
    }


    public Post getPostById(int postId) {
        return posts.stream()
                .filter(post -> post.getId() == postId)
                .findFirst()
                .orElse(null);
    }

}
