package com.practice.catsgram.service;

import com.practice.catsgram.exceptions.InvalidEmailException;
import com.practice.catsgram.exceptions.PostNotFoundException;
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
    private static int postId = 0;

    public List<Post> findAll(Integer size, String sort, Integer from) {
        List<Post> ascSortedPosts = new ArrayList<>();
        ascSortedPosts = posts.stream()
                .sorted((post1, post2) -> {
                    if ("asc".equals(sort)) {
                        return post1.getCreationDate().compareTo(post2.getCreationDate());
                    } else {
                        return post2.getCreationDate().compareTo(post1.getCreationDate());
                    }
                }).toList();
        List<Post> sizeDateSortedPosts = new ArrayList<>();
        sizeDateSortedPosts = ascSortedPosts.stream().
                limit(size).
                toList();
//        не знаю какой метод у стримов применить к from???

        return sizeDateSortedPosts;

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
        post.setId(++postId);
        posts.add(post);
        return post;
    }

    public Post findPostById(int postId) {
        return posts.stream().
                filter(post -> postId == post.getId()).findFirst().orElseThrow(() -> new PostNotFoundException(String.format("Пост %d не найден", postId)));

    }


}
