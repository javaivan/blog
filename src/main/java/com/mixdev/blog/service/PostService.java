package com.mixdev.blog.service;

import com.mixdev.blog.domain.Post;

import java.util.List;

/**
 * Created by osven on 04.02.16.
 */
public interface PostService {

    public Post findById(int id);

    public void save(Post post);

    public List<Post> findAll();
}
